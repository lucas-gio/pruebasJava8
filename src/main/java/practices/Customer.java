package practices;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
class Customer {
    private String code;
    private String name;
    private String lastName;
    private Date birthDate;
    private Date registrationDate;
    private Date lastPurchaseDate;
    private Boolean isActive;
}
