package talgatdemostoreemail.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class Order {
    private Long id;
    private String deliveryAddress;
    private String deliveryName;
    private String email;
    private Set<Long> itemIds = new HashSet<>();
    private BigDecimal orderTotal;
    private String comment;
}

