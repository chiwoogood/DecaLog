package kr.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Member {

	@Id
	private String username; // Spring Sequrity에서는 id가 아닌 username으로 지정
	
	private String password; // Spring Sequrity에서는 pw가 아닌 password로 지정
	
    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public boolean matchesPassword(String rawPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(rawPassword, this.password);
    }
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.MEMBER; // 기본값으로 Member를 설정합니다.
    
    private String profileURL;
    
	private String name;  // 이름
	
	private String nickname;
	
	private String email;
	
	
}











