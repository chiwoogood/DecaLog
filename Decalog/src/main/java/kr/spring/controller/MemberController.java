package kr.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
    @GetMapping("/mypage")
    public String mypage(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            Member member = memberService.findMemberByUsername(username);
            if (member != null) {
                model.addAttribute("member", member);
                return "member/mypage"; // 마이페이지 뷰 경로
            }
        }
        return "redirect:/login"; // 로그인하지 않았거나 사용자 정보가 없으면 로그인 페이지로 리다이렉션
    }
}
