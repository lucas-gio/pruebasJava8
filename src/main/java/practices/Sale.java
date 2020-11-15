package practices;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Sale {
    List<Item> itemList;
    Customer customer;
}
