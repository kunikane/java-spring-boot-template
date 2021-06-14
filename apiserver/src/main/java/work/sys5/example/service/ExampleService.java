package work.sys5.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import work.sys5.example.model.ExampleItem;

@Service
public class ExampleService {
    public List<ExampleItem> getExampleItems(int offset) {
        return List.of(new ExampleItem("aaa"), new ExampleItem("bbb"), new ExampleItem("ccc"));
    }
}
