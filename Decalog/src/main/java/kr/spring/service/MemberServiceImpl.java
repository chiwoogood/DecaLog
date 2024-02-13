package kr.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.spring.entity.Board;
import kr.spring.entity.Member;
import kr.spring.repository.BoardRepository;
import kr.spring.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public void join(Member vo, String confirmPassword) {
        if (!vo.getPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        memberRepository.save(vo);
    }
    
	@Override
	public void update(Member vo) {
	    Member existingMember = memberRepository.findByUsername(vo.getUsername()).orElse(null);
	    
	    if (existingMember != null) {
	        existingMember.setName(vo.getName());
	        // 나머지 필드도 필요에 따라 업데이트 가능
	        
	        memberRepository.save(existingMember);
	    } else {
	        // 기존 멤버 정보가 없는 경우 예외 처리 또는 다른 작업 수행
	    }
	}
	
	@Override
	public boolean login(String username, String password) {
	    Member member = memberRepository.findByUsername(username).orElse(null);
	    if (member != null) {
	        return passwordEncoder.matches(password, member.getPassword());
	    }
	    return false;
	}
	
}










