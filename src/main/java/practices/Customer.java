package practices;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
class Customer {
    private String code;
    private String name;
    private String lastName;
    private Date birthDate;
    private Date registrationDate;
    private Date lastPurchaseDate;
    private Boolean isActive;
}
