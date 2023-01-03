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

//    public Flux<Item> getAllItems(){
//        Flux<Item> items = WebClient.create("http://localhost:8080")
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/api/items")
//                        .queryParam("all").build())
//                .retrieve()
//                .bodyToFlux(Item.class);
//        return items;
//    }
//
//    public Mono<Item> getById(String id){
//        Mono<Item> item = WebClient.create()
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("localhost:8080/api/items")
//                        .queryParam("id",id).build())
//                .retrieve()
//                .bodyToMono(Item.class);
//        return item;
//    }
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
