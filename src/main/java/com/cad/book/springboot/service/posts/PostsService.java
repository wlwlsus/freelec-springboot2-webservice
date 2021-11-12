package com.cad.book.springboot.service.posts;


import com.cad.book.springboot.domain.posts.Posts;
import com.cad.book.springboot.domain.posts.PostsRepository;
import com.cad.book.springboot.web.dto.PostsResponseDto;
import com.cad.book.springboot.web.dto.PostsSaveRequestDto;
import com.cad.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Controller 와 Service 에 @Autowired 가 없는 이유 : 생성자로 주입받는 것이 가장 권장하는 방식
 *
 * @RequiredArgsConstructor 이를 사용하면 final 이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복이 대신 생성해준다.
 */
@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto postsSaveRequestDto) {
    return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
  }

  /**
   * @param id
   * @param requestDto
   * Query 날리는 부분이 없는 이유 : JPA 영속성 컨텍스트가 포함되어 있기 때문이다.
   * 영속성 컨텍스트란 엔티티를 영구 저장하는 환경이다. JPA 의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐이다.
   * 트랜잭션 안에서 DB Data 를 가져오면 영속성 컨텍스트가 유지된 상태이다.
   * 이 상태에서 해당 데이터 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
   * 즉 Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다.
   * 이를 더티 체킹(Dirty Checking) 이라고한다.
   */
  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {

    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 .id=" + id));

    return new PostsResponseDto(entity);
  }
}
