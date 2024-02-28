package kr.spring.service;

//import java.util.List;

//import kr.spring.entity.Board;
import kr.spring.entity.Member;

public interface MemberService {
	
	public void join(Member vo, String confirmPassword);

	public void update(Member vo);	

	public boolean login(String username, String password);

	public Member findMemberByUsername(String username);

}







