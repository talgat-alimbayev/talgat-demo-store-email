package talgatdemostoreemail.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private Long id;
    private String name;
    private BigDecimal price;
}
