package com.cad.book.springboot.web;

import com.cad.book.springboot.config.auth.dto.SessionUser;
import com.cad.book.springboot.service.posts.PostsService;
import com.cad.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final PostsService postsService;
  private final HttpSession httpSession;

  /**
   * 앞서 저장된 CustomOAuth2UserService 에서 로그인 성공 시 세선에 SessionUser 를 저장하도록 구성
   *
   * if (user != null) ... : 세션에 저장된 값이 있을 때만 model 에 userName 으로 등록
   */
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());

    SessionUser user = (SessionUser) httpSession.getAttribute("user");
    if (user != null) {
      model.addAttribute("userName", user.getName());
    }
    return "index";
  }

  @GetMapping("/posts/save")
  public String postsSave() {
    return "posts-save";
  }

  @GetMapping("/posts/update/{id}")
  public String postsUpdate(@PathVariable Long id, Model model) {
    PostsResponseDto dto = postsService.findById(id);

    model.addAttribute("posts", dto);
    return "posts-update";
  }
}
