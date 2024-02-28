package kr.spring.service;


import org.springframework.stereotype.Service;
import kr.spring.entity.Member;
import kr.spring.service.BlogCommentService;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {

    @Override
    public void create(Member vo) {
        // 여기에 코멘트 생성 로직 구현
    }
}