package com.cad.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 모든 Entity 의 상위 클래스가 된다.
 * createdDate, modifiedDate 를 자동으로 관리하는 역할.
 *
 * @MappedSuperclass BaseTimeEntity 를 상속할 경우 필드(createdDate, modifiedDate)들도 칼럼으로 인식하도록 한다.
 * @EntityListeners(AuditingEntityListener.class) BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
 * @CreatedDate Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
 * @LastModifiedDate 조회한 Entity 의 값을 변경할 때 시간이 자동 저장된다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

  @CreatedDate
  private LocalDateTime createdDate;

  @LastModifiedDate
  private LocalDateTime modifiedDate;
}
