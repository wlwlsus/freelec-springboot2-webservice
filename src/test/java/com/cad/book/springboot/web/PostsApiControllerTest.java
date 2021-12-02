package com.cad.book.springboot.web;


/**
 * 게시물 등록 기능 테스트 케이스
 *
 * @WithMockUser(roles = "USER")
 * - 인증된 모의(가짜) 사용자를 만들어서 사용한다.
 * - roles 에 권한을 추가할 수 있다.
 * - 즉, 이 어노테이션으로 인해 ROLE_USER 권한을 가진 사용자가 API 를 요청하는 것과 동일한 효과를 가지게 된다.
 * - SpringBootTest 에서는 MockMvc 를 사용하지 않기 작동하지 않는다.
 * @Before - 테스트 전 Mock 인스턴스 생성
 * <p>
 * mvc.perform : 생성된 MockMvc 로 API 를 테스트한다.
 * 본문 영역은 문자열로 표현하기 위해 ObjectMapper 를 통해 문자열을 JSON 으로 변환
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 랜덤 포트로 테스트 진행
//public class PostsApiControllerTest {

//  @Autowired
//  private WebApplicationContext context;
//
//  private MockMvc mvc;
//
//  @LocalServerPort
//  private int port;
//
//  @Autowired
//  private TestRestTemplate restTemplate;
//
//  @Autowired
//  private PostsRepository postsRepository;
//
//  @After
//  public void tearDown() throws Exception {
//    postsRepository.deleteAll();
//  }
//
//  @Before
//  public void setup() {
//    mvc = MockMvcBuilders
//        .webAppContextSetup(context)
//        .apply(springSecurity())
//        .build();
//  }

//  @Test
//  @WithMockUser(roles="USER")
//  public void Posts_등록된다() throws Exception {
//    //given
//    String title = "title";
//    String content = "content";
//    PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
//        .title(title)
//        .content(content)
//        .author("author")
//        .build();
//
//    String url = "http://localhost:" + port + "/api/v1/posts";
//
//    //when
//    mvc.perform(post(url)
//            .contentType(MediaType.APPLICATION_JSON_UTF8)
//            .content(new ObjectMapper().writeValueAsString(requestDto)))
//        .andExpect(status().isOk());
//
//    //then
//    List<Posts> all = postsRepository.findAll();
//    assertThat(all.get(0).getTitle()).isEqualTo(title);
//    assertThat(all.get(0).getContent()).isEqualTo(content);
//  }
//
//  @Test
//  @WithMockUser(roles = "USER")
//  public void Posts_수정된다() throws Exception {
//    // given
//    Posts savedPosts = postsRepository.save(Posts.builder()
//        .title("title")
//        .content("content")
//        .author("author")
//        .build());
//
//    Long updateId = savedPosts.getId();
//    String expectedTitle = "title2";
//    String expectedContent = "content2";
//
//    PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
//        .title(expectedTitle)
//        .content(expectedContent)
//        .build();
//
//    String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
//
//    HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//    // when
////    ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
//    mvc.perform(put(url)
//            .contentType(MediaType.APPLICATION_JSON_UTF8)
//            .content(new ObjectMapper().writeValueAsString(requestDto)))
//        .andExpect(status().isOk());
//
//    // then
//    List<Posts> all = postsRepository.findAll();
//
//    assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//    assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
//  }


//}