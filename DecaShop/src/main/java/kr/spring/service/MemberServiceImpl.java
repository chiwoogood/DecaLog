package kr.spring.service;

import java.util.List;
import java.util.Optional;

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
	public void join(Member vo) {
		String encPw = vo.getPassword();
		vo.setPassword(passwordEncoder.encode(encPw));
		memberRepository.save(vo);
	}
	
	@Override
	public void update(Member vo) {
//	    Member existingMember = memberRepository.findById(vo.getId()).orElse(null);
//	    
//	    // 기존 멤버 정보가 존재하면 이름을 업데이트
//	    if (existingMember != null) {
//	        existingMember.setName(vo.getName());
//	        // 나머지 필드도 필요에 따라 업데이트 가능
//	        
//	        // 업데이트된 멤버 정보를 저장
//	        memberRepository.save(existingMember);
//	    } else {
//	        // 기존 멤버 정보가 없는 경우 예외 처리 또는 다른 작업 수행
//	    }
//		
//		memberRepository.save(vo);
//	}

//}
	}}










