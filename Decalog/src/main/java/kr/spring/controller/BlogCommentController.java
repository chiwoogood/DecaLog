package kr.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.entity.Member;
import kr.spring.service.BlogCommentService;

@Controller
@RequestMapping("/blogcomment/*")
public class BlogCommentController {
	
	@Autowired
	private BlogCommentService blogCommentService;
    
    @PostMapping("/create")
    public String create(Member vo) {
        blogCommentService.create(vo);
        return "redirect:/blog/"; // 성공 시 리다이렉션할 경로
    
    }
}
