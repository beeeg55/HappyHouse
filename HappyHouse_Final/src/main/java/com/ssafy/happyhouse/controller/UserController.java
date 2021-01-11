package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.dto.UserInterestDto;
import com.ssafy.happyhouse.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@RequestParam("userid") String userid, @RequestParam("userpwd") String userpwd,
			HttpSession session, Model model) {
		if (userid == null | userid.trim().length() == 0 || userpwd == null || userpwd.trim().length() == 0) {
			model.addAttribute("errorMsg", "아이디와 비밀번호는 필수 입니다.");
			return "index";
		}
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpwd", userpwd);

		if (userService.login(map)) {
			int athor = userService.getAthority(userid);

			if (athor != -1) {
				session.setAttribute("id", userid);
				session.setAttribute("useage", athor);
			}
		} else {
			model.addAttribute("errorMsg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("userid") String userid, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		System.out.println(userid);
		userid = "%" + userid + "%";
		int useage = userService.getOneUserById(userid).getUseage();
		System.out.println(useage);
		map.put("userid", userid);
		map.put("useage", "-1");
		System.out.println(map);
		userService.updateUserUseage(map);
		session.invalidate();
		if (useage == 100) {
			return "index";
		} else {
			return "05_userlist/userlist";
		}
	}

	@RequestMapping("/register")
	public String register(User user, @RequestParam("sido") String sido, @RequestParam("gugun") String gugun,
			@RequestParam("dong") String dong) {
		System.out.println(user);
		String interest = sido + "_" + gugun + "_ " + dong;
		System.out.println(interest);
		userService.register(user);
		Map<String, String> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("interest", interest);
		userService.insertUserInterest(map);
		return "index";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("userid") String userid, @RequestParam("userpwd") String userpwd,
			@RequestParam("email") String email, @RequestParam("username") String username) {
		User user = new User();
		user.setId(userid);
		user.setName(username);
		user.setPwd(userpwd);
		user.setEmail(email);
		System.out.println(user);
		userService.updateUser(user);
		return "index";
	}

	@RequestMapping("/adminRegister")
	public String adminRegister(User user) {
		user.setUseage(100);
		System.out.println(user);
		userService.register(user);
		return "redirect:/user/userList";
	}

	@RequestMapping("/adminUpdate")
	public String adminUpdate(User user) {
		System.out.println(user);
		userService.updateUser(user);
		return "redirect:/user/userList";
	}

	@RequestMapping("/userList")
	public String userList(Model model) {
		List<User> list = userService.getUsers();
		model.addAttribute("userList", list);
		return "05_userlist/userlist";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("username") String username, Model model) {
		username = "%" + username + "%";
		List<User> list = userService.getUserByName(username);
		if (list != null) {
			model.addAttribute("userList", list);
		}
		return "05_userlist/userlist";
	}

	@ResponseBody
	@GetMapping("/showDetails")
	public User showDetails(@RequestParam String userid, HttpSession session) {
		return userService.getOneUserById(userid);
	}

	@RequestMapping("/main")
	public String main() {
		return "index";
	}

	@RequestMapping(value = "/findPwd", headers = { "Content-type=application/json" })
	@ResponseBody
	public User findPwd(@RequestParam("id") String id, @RequestParam("email") String email) {
		User user = userService.getOneUserById(id);
		return user;
	}

	@PostMapping("/insertInterest")
	public String insertInterest(HttpSession session, SidoGugunCodeDto sidoGugunCodeDto) {
		String id = (String) session.getAttribute("id");
		String interest = sidoGugunCodeDto.getSidoName() + '_' + sidoGugunCodeDto.getGugunName() + '_'
				+ sidoGugunCodeDto.getDongName();

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("interest", interest);
		userService.insertUserInterest(map);
		return "redirect:/biz/main";
	}

	@RequestMapping("/getInterestList")
	@ResponseBody
	public List<SidoGugunCodeDto> getInterestList(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		List<String> temp = userService.getUserInterest(id);
		List<SidoGugunCodeDto> list = new ArrayList<SidoGugunCodeDto>();
		for (String t : temp) {
			StringTokenizer st = new StringTokenizer(t, "_");
			String[] str = new String[3];
			SidoGugunCodeDto dto = new SidoGugunCodeDto();
			if (st.hasMoreTokens()) {
				dto.setSidoName(st.nextToken());
			}
			if (st.hasMoreTokens())
				dto.setGugunName(st.nextToken());
			if (st.hasMoreTokens())
				dto.setDongName(st.nextToken());
			list.add(dto);
		}
		model.addAttribute("list", list);
		return list;
	}

	@PostMapping("/deleteInterestList")
	public String deleteInterestList(HttpSession session, UserInterestDto userInterestDto) {
		String id = (String) session.getAttribute("id");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("interest", userInterestDto.getInterest().replace(' ', '_'));
		userService.deleteInterest(map);
		return "redirect:/biz/main";
	}
}
