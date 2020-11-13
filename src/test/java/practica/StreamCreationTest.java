package practica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Creación de streams desde distintas fuentes.")
class StreamCreationTest {

    @DisplayName("Creación del stream basado en un array de clientes")
    @Test public void streamArrayBased() {
        Map customer1 = Map.of("code","1","name","cliente1");
        Map customer2 = Map.of("code","2","name","cliente2");
        Map customer3 = Map.of("code","3","name","cliente3");
        Map customer4 = Map.of("code","4","name","cliente4");
        Map customer5 = Map.of("code","5","name","cliente5");

        Customer[] customersArray = {
            Customer.from(customer1),
            Customer.from(customer2),
            Customer.from(customer3),
            Customer.from(customer4),
            Customer.from(customer5),
        };

        // Se crea el stream con el método fábrica of.
        Stream<Customer> customersStream = Stream.of(customersArray);

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además se pueden obtener los cinco elementos almacenados previamente
        Assertions.assertEquals(customersStream.collect(Collectors.toList()).size(), customersArray.length);
    }

//    @DisplayName("Creación del stream basado en listado de clientes")
//    @Test public void listArrayBased() {
//        Map customer1 = Map.of("code","1","name","cliente1");
//        Map customer2 = Map.of("code","2","name","cliente2");
//        Map customer3 = Map.of("code","3","name","cliente3");
//        Map customer4 = Map.of("code","4","name","cliente4");
//        Map customer5 = Map.of("code","5","name","cliente5");
//
//        List<Customer> customerList = Arrays.asList(
//                Customer.from(customer1),
//                Customer.from(customer2),
//                Customer.from(customer3),
//                Customer.from(customer4),
//                Customer.from(customer5)
//        );
//
//        // Se crea el stream con el método fábrica of.
//        Stream<List<Customer>> customersStream = Stream.of(customerList);
//
//        // El stream obtenido no es null
//        Assertions.assertNotNull(customersStream);
//
//        // Y además se pueden obtener los cinco elementos almacenados previamente
//        List listFromStream = customersStream.collect(Collectors.toList());
//        Assertions.assertNotNull(listFromStream);
//        Assertions.assertEquals(listFromStream.size(), customerList.size());
//    }

    @DisplayName("Creación del stream basado en un Collection")
    @Test public void collectionStreamBased() {
        Map customer1 = Map.of("code","1","name","cliente1");
        Map customer2 = Map.of("code","2","name","cliente2");
        Map customer3 = Map.of("code","3","name","cliente3");
        Map customer4 = Map.of("code","4","name","cliente4");
        Map customer5 = Map.of("code","5","name","cliente5");

        Collection<Customer> customers = Arrays.asList(
                Customer.from(customer1),
                Customer.from(customer2),
                Customer.from(customer3),
                Customer.from(customer4),
                Customer.from(customer5)
        );

        // Se crea el stream stream() dado por Collection.
        Stream<Customer> customersStream = customers.stream();

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además se pueden obtener los cinco elementos almacenados previamente
        List listFromStream = customersStream.collect(Collectors.toList());
        Assertions.assertNotNull(listFromStream);
        Assertions.assertTrue(listFromStream.size() == customers.size());
    }

}

