package kr.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 환경설정파일 설정
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@Bean
	public PasswordEncoder passwordEncoder() { // 비밀번호 인코딩 기능
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	    
	    http.csrf().disable(); // CSRF인증 토큰 비활성화
	    
	    http.authorizeHttpRequests() // 사용자의 요청을 핸들링
	        .antMatchers("/", "/member/**").permitAll() // "/", "/member/**" 하위에 모든 접근을 허용
	        .antMatchers("/css/**", "/js/**", "/images/**").permitAll() // 정적 리소스에 대한 접근 허용
	        .antMatchers("/board/**").authenticated() // "/board/**"는 인증된 사용자만 허용
	        .and() // 추가
	        .formLogin() // 별도의 로그인 폼을 사용
	        .loginPage("/member/login") // 로그인 페이지 지정
	        .defaultSuccessUrl("/board/list") // 로그인 성공 시 이동할 페이지
	        .and() // 추가
	        .logout() // 로그아웃 설정
	        .logoutUrl("/member/logout") // 로그아웃 URL
	        .logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 페이지
	    
	    http.userDetailsService(userService);
	    
	    return http.build();
	}
	

}









