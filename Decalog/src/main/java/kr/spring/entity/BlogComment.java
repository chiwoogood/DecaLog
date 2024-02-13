package kr.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class BlogComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 기본 fetch 전략 사용
    @JoinColumn(name = "blog_id") // 블로그 포스트와 연결된 외래 키
    private Blog parentBlog; // 댓글이 속한 블로그 포스트

    private String author; // 댓글 작성자

    private String content; // 댓글 내용

    private LocalDateTime createdAt; // 댓글 작성 시간

    // 기타 필드 및 메소드...
}