package kr.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.spring.entity.BlogComment;


@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long>{

}
