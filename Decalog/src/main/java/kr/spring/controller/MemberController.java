package kr.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.entity.Member;
import kr.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
    @PostMapping("/join")
    public String join(Member vo, @RequestParam("passwordConfirm") String confirmPassword) {
        memberService.join(vo, confirmPassword);
        return "redirect:/member/login"; // 가입 성공 시 로그인 페이지로 이동
    }
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	
    @PostMapping("/login")
    public String login(Member vo) {
        if (memberService.login(vo.getUsername(), vo.getPassword())) {
            return "redirect:/board/list"; // 로그인 성공 시 게시판 목록 페이지로 이동
        } else {
            return "redirect:/member/login"; // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 이동
        }
    }
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@GetMapping("/update")
	public String update() {
		return "member/update";
	}
	
	@PostMapping("/update")
	public String update(Member vo) {
		memberService.update(vo);
		return "redirect:/board/list";
	}
	
}
