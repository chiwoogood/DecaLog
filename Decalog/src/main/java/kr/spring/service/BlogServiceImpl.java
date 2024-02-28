package kr.spring.service;

import org.springframework.stereotype.Service;
import kr.spring.entity.Member;

@Service
public class BlogServiceImpl implements BlogService {
    
    @Override
    public void create(Member vo) {
        // 여기에 비즈니스 로직 구현
    }
}