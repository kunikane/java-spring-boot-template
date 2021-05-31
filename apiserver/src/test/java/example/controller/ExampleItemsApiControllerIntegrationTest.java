package example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import work.sys5.example.ExampleApplication;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ExampleApplication.class})
@AutoConfigureWebTestClient
public class ExampleItemsApiControllerIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    public void setup() {
        webClient = webClient.mutate()
                .responseTimeout(Duration.ofSeconds(5))
                .build();
    }

    @Test
    public void getItemsTest() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            webClient.get().uri(uriBuilder -> uriBuilder
                    .path("/api/v1/example/items")
                    .queryParam("offset", 10)
                    .build()).exchange()
                    .expectStatus().isOk()
                    .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                    .expectBody().consumeWith((x) -> System.out.println("response: " + new String(x.getResponseBody())));
        });
    }
}
