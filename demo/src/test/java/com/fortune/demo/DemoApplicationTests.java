package com.fortune.demo;

import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class DemoApplicationTests extends AbstractTest {

	@Test
	void testWritePost() throws Exception {
		PostRequest postRequest = new PostRequest();
		postRequest.setTitle("HELLO");
		postRequest.setContent("BYE");

		String data = JacksonUtil.toJson(postRequest);
		System.out.println(data);

		this.mockMvc
				.perform(post("/api/post")
						.contentType(MediaType.APPLICATION_JSON)
						.content(data))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.title").value("HELLO"));
	}

	@Test
	void testReadPost() throws Exception {
		testWritePost();
		this.mockMvc
				.perform(get("/api/post/{id}",1))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.title").value("HELLO"));
	}

	@Test
	void testUpdatePost() throws Exception {
		testWritePost();
		PostRequest postRequest = new PostRequest();
		postRequest.setTitle("Update");
		postRequest.setContent("Update");

		String data = JacksonUtil.toJson(postRequest);
		System.out.println(data);

		this.mockMvc
				.perform(post("/api/update/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(data))
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.title").value("Update"));
	}

	@Test
	void testDeleteProperNumPost() throws Exception {
		testWritePost();
		this.mockMvc
				.perform(delete("/api/delete/{id}",1))
				.andExpect(status().is(HttpStatus.OK.value()));
	}

	@Test
	void testDeleteImproperNumPost() throws Exception {
		testWritePost();
		this.mockMvc
				.perform(delete("/api/delete/{id}",-1))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(content().string("No class com.fortune.demo.domain.Post entity with id -1 exists!"));
	}
}
