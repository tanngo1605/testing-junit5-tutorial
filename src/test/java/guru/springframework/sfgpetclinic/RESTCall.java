package guru.springframework.sfgpetclinic;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RESTCall {
    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    @Test
    void test() throws JsonMappingException, JsonProcessingException {
        ResponseEntity<String> result = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",
                String.class);
        Post post = objectMapper.readValue(result.getBody(), Post.class);
        System.out.println(post.toString());
        System.out.println(result.getBody());

    }

    @Test
    @DisplayName("get list as a result")
    void callList() throws JsonMappingException, JsonProcessingException {
        ResponseEntity<String> result = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts",
                String.class);
        List<Post> post = objectMapper.readValue(result.getBody(), new TypeReference<List<Post>>() {
        });
        System.out.println(post.toString());
        System.out.println(result.getBody());

    }

    //Does not need @Test for @ParameterizedTest
    @ParameterizedTest
    @ValueSource(strings = { "abcabcbb", "pwwk" })
    void test_(String val) {

        System.out.println(val);

    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Post {
    @JsonProperty("userId")
    int userId;
    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("body")
    String body;

    @Override
    public String toString() {
        return "Post [body=" + body + ", id=" + id + ", title=" + title + ", userId=" + userId + "]";
    }

}