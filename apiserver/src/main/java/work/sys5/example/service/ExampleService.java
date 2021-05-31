package work.sys5.example.service;

import org.springframework.stereotype.Service;
import work.sys5.example.model.ExampleItem;

import java.util.List;

@Service
public class ExampleService {
    public List<ExampleItem> getExampleItems(int offset) {
        return List.of(new ExampleItem("aaa"),
                new ExampleItem("bbb"),
                new ExampleItem("ccc"));
    }
}
