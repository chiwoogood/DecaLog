package kr.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.entity.Member;
import kr.spring.service.BlogCommentService;

@Controller
@RequestMapping("/blog/*")
public class BlogController {
    
	@Autowired
	private BlogCommentService blogService;
    
	
	
	@GetMapping("/list/{username}")
	public String List(@PathVariable String username, Model model) {
	    // username을 사용하여 해당 사용자의 블로그 리스트를 조회하는 로직 추가
	    // 예시: model.addAttribute("blogs", blogService.findBlogsByUsername(username));

	    return "member/blog/list"; // 사용자의 블로그 리스트를 보여줄 뷰 페이지 경로
	}
	
	
    @GetMapping("/create")
    public String createForm() {
        return "blog/create";
    }
    
    @PostMapping("/create")
    public String create(Member vo) {
        blogService.create(vo);
        return "redirect:/blog/"; // 성공 시 리다이렉션할 경로
    
    }
}