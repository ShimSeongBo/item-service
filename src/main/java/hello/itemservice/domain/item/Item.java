package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

//@Data 는 위험함. -> 예측하지 못하게 동작함.

@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // int -> 0을 해야함 Null을 쓰기위해서 Integer로 만듦.

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
