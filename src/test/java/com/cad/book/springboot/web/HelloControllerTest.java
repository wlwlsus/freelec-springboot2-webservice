package com.cad.book.springboot.web;


//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = HelloController.class, excludeFilters = {
//    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
//})
//public class HelloControllerTest {

//  @Autowired
//  private MockMvc mvc;

//  @WithMockUser(roles = "USER")
//  @Test
//  public void return_hello() throws Exception {
//    String hello = "hello";
//
//    mvc.perform(get("/hello"))
//        .andExpect(status().isOk())
//        .andExpect(content().string(hello));
//  }
//
//  @WithMockUser(roles = "USER")
//  @Test
//  public void return_helloDto() throws Exception {
//    String name = "hello";
//    int amount = 1000;
//
//    mvc.perform(get("/hello/dto")
//            .param("name", name)
//            .param("amount", String.valueOf(amount)))
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.name", is(name)))
//        .andExpect(jsonPath("$.amount", is(amount)));
//  }
//}