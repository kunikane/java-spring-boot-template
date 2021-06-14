package work.sys5.example.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import work.sys5.example.model.ExampleItem;
import work.sys5.example.service.ExampleService;

@Controller
@RequestMapping("${openapi.openAPIExample.base-path:/api/v1}")
@RequiredArgsConstructor
public class ExampleItemsApiController implements ExampleItemsApi {

    @NonNull private final NativeWebRequest request;

    @NonNull private final ExampleService exampleService;

    @Override
    public ResponseEntity<List<ExampleItem>> workSys5ExampleControllerGetItems(
            @Valid @RequestParam(value = "offset", required = false, defaultValue = "0")
                    Integer offset) {
        return ResponseEntity.ok(exampleService.getExampleItems(offset));
    }
}
