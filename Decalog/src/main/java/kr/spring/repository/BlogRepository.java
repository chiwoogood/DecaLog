package kr.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.spring.entity.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
