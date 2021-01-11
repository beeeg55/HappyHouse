package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private NoticeService noticeService;

	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

//	@RequestMapping("/main")
//	public String searchForm() {
//		return "04_notice/notice";
//	}

	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(@RequestParam String title, @RequestParam String des) {
		System.out.println("here");
		boolean flag = noticeService.writeArticle(new NoticeDto(title,des));
		System.out.println(flag);
		return "redirect:/notice/main";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, @RequestParam("des") String des) {
		noticeService.modifyArticle(new NoticeDto(id,des));
		return "redirect:/notice/main";
	}

	@RequestMapping("/select")
	public String getArticle(@RequestParam int id, Model model) {
		System.out.println("hi");
		NoticeDto notice = noticeService.getArticle(id);
		model.addAttribute("notice", notice);
		return "04_notice/noticeDetail";
	}

	@RequestMapping("/main")
	public String getList(Model model) {
		List<NoticeDto> noticeList = noticeService.listArticle();
		model.addAttribute("noticeList",noticeList);
		return "04_notice/notice";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int id) {
		noticeService.deleteArticle(id);
		return "redirect:/notice/main";
	}
}
