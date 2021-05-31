package example.controller;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import work.sys5.example.controller.ExampleItemsApiController;
import work.sys5.example.model.ExampleItem;
import work.sys5.example.service.ExampleService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ExampleItemsApiControllerTest {

    @Mock
    private NativeWebRequest nativeWebRequest;
    @Mock
    private ExampleService exampleService;
    @InjectMocks
    private ExampleItemsApiController exampleItemsApiController;

    @Test
    public void getItemsTest() {
        int offset = 3;
        val items = List.of(new ExampleItem("ttt"),
                new ExampleItem("yyy"),
                new ExampleItem("uuu"));
        val pin = "==pin==";
        when(exampleService.getExampleItems(offset)).thenReturn(items);
        val response = exampleItemsApiController.workSys5ExampleControllerGetItems(offset);
        assertThat(response).isEqualTo(ResponseEntity.ok(items));
    }

}
