package com.cad.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {


  /**
   * 실제로 SpringDataJpa 에서 제공하는 기본 메소드로 해결 가능
   * @Query 가 가독성이 좋긴 하다.
   * 규모가 있는 프로젝트에서는 Querydsl 을 사용하는게 좋다.
   * 이유 :
   * 1. 타입 안전성이 보장된다.
   * 2. 국내 많은 회사에서 사용 중이다.(쿠팡, 배민 등.. JPA 를 쓰는 회사들)
   * 3. 레퍼런스가 많다 -> 검색 자료가 많아서 좋음
   */
  @Query("SELECT p from Posts p ORDER BY p.id DESC ")
  List<Posts> findAllDesc();

}
