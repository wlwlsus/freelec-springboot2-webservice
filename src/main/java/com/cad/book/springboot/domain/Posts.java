package com.cad.book.springboot.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 어노테이션 순서 : 주요 어노테이션을 클래스와 가깝게
 *
 * @Getter 롬복은 간편하지만 필수는 아님 - 코틀린은 data class 로 롬복 필요 없음
 * @NoArgsConstructor 파라미터가 없는 기본 생성자 생성 -> public Posts() {}
 * @Entity 실제 DB 테이블과 매칭될 클래스, Entity 클래스라고도 부름름
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts {

  /**
   * @Id 해당 테이블의 PK
   * @GeneratedValue 스프링 부트 2.0 에서는 IDENTITY 이 붙어야만 auto increment 실행
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * @Column 테이블 칼럼 선언, 없어도 되지만 length, columnDefinition 옵션을 조정하기 위해서 사용
   */
  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}