package kr.spring.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity // Board VO가 Database Table로 만들때 설정
@Data
@ToString
public class Blog {

    @Id // 기본 키임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 전략을 데이터베이스 ID 자동 증가로 설정합니다.
    private Long id;

    private String title; // 블로그 포스트의 제목
    private String content; // 블로그 포스트의 내용
    
    @ManyToOne
    @JoinColumn(name = "author_username", referencedColumnName = "username")
    private Member author; // Member 엔티티를 참조

    @ElementCollection
    private List<String> imageUrls = new ArrayList<>();
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}