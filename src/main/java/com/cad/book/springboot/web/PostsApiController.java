package com.cad.book.springboot.web;

import com.cad.book.springboot.service.posts.PostsService;
import com.cad.book.springboot.web.dto.PostsResponseDto;
import com.cad.book.springboot.web.dto.PostsSaveRequestDto;
import com.cad.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
    return postsService.save(postsSaveRequestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
    return postsService.update(id, requestDto);
  }

  @GetMapping("api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id) {
    return postsService.findById(id);
  }

}
