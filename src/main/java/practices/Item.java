package practices;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Item {
    String code;
    String name;
    BigDecimal value;
}
