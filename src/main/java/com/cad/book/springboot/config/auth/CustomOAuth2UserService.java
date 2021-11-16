package com.cad.book.springboot.config.auth;


import com.cad.book.springboot.config.auth.dto.OAuthAttributes;
import com.cad.book.springboot.config.auth.dto.SessionUser;
import com.cad.book.springboot.domain.user.User;
import com.cad.book.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;


/**
 * 구글 로그인 이후 가져온 사용자의 정보(email, name, picture) 기반 가입 및 정보수정, 세션 저장 등 기능 지원
 *
 * registrationId
 * - 현재 로그인 중인 서비스를 구분하는 코드
 * - 지금은 구글만 사용하는 불필요한 값, 이후 네이버 로그인 연동시에 네이버 로그인인지, 구글 로그인인지 구분하기 위해 사용
 *
 * userNameAttributeName
 * - OAuth2 로그인 진행 시 키가 되는 필드값을 이야기한다.
 * - Primary Key 와 같은 의미
 * - 구글의 경우 기본적으로 코드 지원, BUT 네이버, 카카오는 X
 * - 이후 네이버 로그인와 구글 로그인을 동시 지원할 때 사용
 *
 * OAuthAttributes
 * - OAuth2UserService 를 통해 가져온 OAuth2User 의 attribute 를 담을 클래스
 * - 이후 네이버 등 다른 소셜 로그인도 이 클래스를 사용
 *
 * SessionUser
 * - 세션에 사용자 정보를 저장하기 위한 Dto 클래스
 */
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  private final UserRepository userRepository;
  private final HttpSession httpSession;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();

    OAuth2User oAuth2User = delegate.loadUser(userRequest);

    String registrationId = userRequest.getClientRegistration().getRegistrationId();

    String userNameAttributeName =
            userRequest.getClientRegistration()
                    .getProviderDetails()
                    .getUserInfoEndpoint()
                    .getUserNameAttributeName();

    OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

    User user = saveOrUpdate(attributes);

    httpSession.setAttribute("user", new SessionUser(user));

    return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
            attributes.getAttributes(),
            attributes.getNameAttributeKey());
  }

  private User saveOrUpdate(OAuthAttributes attributes) {
    User user = userRepository.findByEmail(attributes.getEmail())
            .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
            .orElse(attributes.toEntity());

    return userRepository.save(user);
  }
}
