package practices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Creación de streams desde distintas fuentes.")
class StreamCreationTests {

    @DisplayName("Creación del stream basado en un array de clientes")
    @Test void streamArrayBased() {
        Customer[] customersArray = createCustomersArray();

        // Se crea el stream con el método fábrica of.
        Stream<Customer> customersStream = Stream.of(customersArray);

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además se pueden obtener los cinco elementos almacenados previamente
        Assertions.assertEquals((int) customersStream.count(), customersArray.length);
    }

    @DisplayName("Creación del stream basado en listado de clientes")
    @Test void listArrayBased() {
        List<Customer> customerList = Arrays.asList(createCustomersArray());

        // Se crea el stream con el método fábrica of.
        Stream<List<Customer>> customersStream = Stream.of((customerList));

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        List<Customer> resultList = customersStream.flatMap(List::stream).collect(Collectors.toList());

        // Y además se pueden obtener los cinco elementos almacenados previamente
        Assertions.assertEquals(resultList.size(), customerList.size());
    }

    @DisplayName("Creación del stream basado en un Collection")
    @Test void collectionStreamBased() {
        Collection<Customer> customersCollection = new HashSet<>(Arrays.asList(createCustomersArray()));

        // Se crea el stream stream() dado por Collection.
        Stream<Customer> customersStream = customersCollection.stream();

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además se pueden obtener los cinco elementos almacenados previamente
        Set<Customer> setFromStream = customersStream.collect(Collectors.toSet());
        Assertions.assertNotNull(setFromStream);
        Assertions.assertEquals(setFromStream.size(), customersCollection.size());
    }

    @DisplayName("Creación del stream basado en elementos separados con Stream.of, y builder de Stream")
    @Test void separatedElementsStreamBased() {
        Customer[] customersArray = createCustomersArray();

        // Se crea el stream con elementos separados
        Stream<Customer> customersStream = Stream.of(customersArray[0], customersArray[3], customersArray[4]);

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además son los elementos espeados
        Set<Customer> setFromStream = customersStream.collect(Collectors.toSet());
        Assertions.assertNotNull(setFromStream);
        Assertions.assertEquals(setFromStream.size(), 3);
        Assertions.assertTrue(setFromStream.containsAll(Arrays.asList(customersArray[0], customersArray[3], customersArray[4])));


        // También, para elementos separados, con streambuilder.
        Stream.Builder<Customer> customerBuilder = Stream.builder();
        customersStream = customerBuilder
            .add(customersArray[0])
            .add(customersArray[3])
            .add(customersArray[4])
            .build();

        // El stream obtenido no es null
        Assertions.assertNotNull(customersStream);

        // Y además son los elementos espeados
        setFromStream = customersStream.collect(Collectors.toSet());
        Assertions.assertNotNull(setFromStream);
        Assertions.assertEquals(setFromStream.size(), 3);
        Assertions.assertTrue(setFromStream.containsAll(Arrays.asList(customersArray[0], customersArray[3], customersArray[4])));
    }

    /**
     * Creación de clientes de pruebas.
     * @return array de clientes de pruebas
     */
    private Customer[] createCustomersArray(){
        return new Customer[]{
            Customer.builder().code("1").name("cliente1").build(),
            Customer.builder().code("2").name("cliente2").build(),
            Customer.builder().code("3").name("cliente3").build(),
            Customer.builder().code("4").name("cliente4").build(),
            Customer.builder().code("5").name("cliente5").build()
        };
    }
}

