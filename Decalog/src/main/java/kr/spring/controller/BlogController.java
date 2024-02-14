package kr.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.service.BlogService;

@Controller
@RequestMapping("/blog/*")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
}
