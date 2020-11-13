package practica;

import java.util.Date;
import java.util.Map;

class Customer {
    private String code;
    private String name;
    private String lastName;
    private Date birthDate;
    private Date registrationDate;
    private Date lastPurchaseDate;
    private Boolean isActive;

    // Método fábrica estático que construye una instancia en base a un Map.
    // En caso de no especificar, se asigna null.
    static Customer from (Map map){
        Customer customer = new Customer();
        customer.code = (String) map.getOrDefault("code", null);
        customer.name = (String) map.getOrDefault("name", null);
        customer.lastName = (String) map.getOrDefault("lastName", null);
        customer.birthDate = (Date) map.getOrDefault("birthDate", null);
        customer.registrationDate = (Date) map.getOrDefault("registrationDate", null);
        customer.lastPurchaseDate = (Date) map.getOrDefault("lastPurchaseDate", null);
        customer.isActive = (Boolean) map.getOrDefault("isActive", null);

        return customer;
    }
}
