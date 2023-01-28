package talgatdemostoreemail.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String deliveryAddress;
    private String deliveryName;
    private String email;
    private List<ItemOrderDto> items = new ArrayList<>();
    private String comment;
    private Long userId;
}

