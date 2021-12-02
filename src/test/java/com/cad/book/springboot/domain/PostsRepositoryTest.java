package com.cad.book.springboot.domain;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PostsRepositoryTest {

//  @Autowired
//  PostsRepository postsRepository;
//
//  @After
//  public void cleanup() {
//    postsRepository.deleteAll();
//  }

//  @Test
//  public void open_saved_File() {
//    // given
//    String title = "테스트 게시글";
//    String content = "테스트 본문";
//
//    /**
//     * posts에 insert/update 실행 id 값 有:update / 無:insert
//     */
//    postsRepository.save(Posts.builder()
//        .title(title)
//        .content(content)
//        .author("cadqe13@gmail.com")
//        .build());
//
//    // when
//    List<Posts> postsList = postsRepository.findAll();
//
//    // then
//    Posts posts = postsList.get(0);
//    assertThat(posts.getTitle()).isEqualTo(title);
//    assertThat(posts.getContent()).isEqualTo(content);
//  }
//
//  @Test
//  public void BaseTimeEntity_등록() {
//    // given
//    LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
//    postsRepository.save(Posts.builder()
//        .title("title")
//        .content("content")
//        .author("author")
//        .build());
//
//    // when
//    List<Posts> postsList = postsRepository.findAll();
//
//    // then
//    Posts posts = postsList.get(0);
//
//    System.out.println(">>>>>>>>> createdDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
//
//    assertThat(posts.getCreatedDate()).isAfter(now);
//    assertThat(posts.getModifiedDate()).isAfter(now);
//  }

//}