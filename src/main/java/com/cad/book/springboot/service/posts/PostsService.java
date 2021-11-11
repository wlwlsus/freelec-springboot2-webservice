package com.cad.book.springboot.service.posts;


import com.cad.book.springboot.domain.PostsRepository;
import com.cad.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Controller 와 Service 에 @Autowired 가 없는 이유 : 생성자로 주입받는 것이 가장 권장하는 방식
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
}
