package talgatdemostoreemail.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgatdemostoreemail.model.Item;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServices {
    private RestTemplate rest;

    public ItemServices(RestTemplate rest) {
        this.rest = rest;
    }

    public List<Item> getItemsById(List<Long> ids){
        String listOfIds = ids.stream().map(Object::toString).collect(Collectors.joining(","));
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                rest.getForObject("http://localhost:8080/api/items?ids={id}", List.class, listOfIds),
                new TypeReference<List<Item>>() {});
    }

}
