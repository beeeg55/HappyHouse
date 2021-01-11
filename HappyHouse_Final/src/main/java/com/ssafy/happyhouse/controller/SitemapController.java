package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sitemap")
@Controller
public class SitemapController {
	
	@GetMapping("/main")
	public String sitemapForm() {
		return "06_sitemap/sitemap";
	}
}
