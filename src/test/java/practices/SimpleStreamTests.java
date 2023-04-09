package practices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

@DisplayName("Test simples de ejemplo de uso de streams")
class SimpleStreamTests {
    List<Integer> getIntegerList(){
        return List.of(1,2,3,4,5,6,7,8,7,6,5,4,3,2,1);
    }

    @DisplayName("skip: Dejar de lado los primeros n elementos")
    @Test
    void skip() {
        List<Integer> processed = getIntegerList()
                .stream()
                .skip(4)
                .collect(Collectors.toList());

        Assertions.assertEquals(
            processed,
            List.of(5,6,7,8,7,6,5,4,3,2,1)
        );
    }

    @DisplayName("forEach: Aplica una operación por cada elemento. Operación terminal. Se modifica el nombre de cada cliente." +
            "El listado ahora refiere a objetos modificados, tiene efecto colateral.")
    @Test
    void forEach() {
        List<Customer> customerList = List.of(
                Customer.builder().name("customer1").build(),
                Customer.builder().name("customer2").build()
        );

        List<String> result = customerList
                .stream()
               // .forEach(it-> it.setName(it.getName() + " modified!") );
                .map(it-> {
                    it.setName(it.getName() + " modified!");
                    return it.getName();
                } )
                .collect(Collectors.toList());

        Assertions.assertEquals(
                "customer1 modified!", // PRIMER CLIENTE, MODIFICADO
                customerList.stream().findFirst().get().getName()
        );

        Assertions.assertEquals(
                "customer2 modified!", // SEGUNDO CLIENTE, MODIFICADO
                customerList.stream().skip(1).findFirst().get().getName()
        );
    }

    @DisplayName("peek: Idem a forEach pero no es terminal y ¡sólo se usa para debug!. " +
            "Se modifica el nombre de cada cliente." +
            "El listado original ahora refiere a objetos modificados, tiene efecto colateral.")
    @Test
    void peek() {
        List<Customer> customerList = Arrays.asList(
                Customer.builder().name("customer1").build(),
                Customer.builder().name("customer2").build()
        );

        List<Customer> result = customerList
                .stream()
                .peek(it -> it.setName(it.getName() + " modified!"))
                .peek(it -> System.out.println(it.getName()))
                .toList();

        // EFECTO COLATERAL
        Assertions.assertEquals(
                "customer1 modified!", // PRIMER CLIENTE, MODIFICADO
                customerList.get(0).getName()
        );

        Assertions.assertEquals(
                "customer2 modified!", // SEGUNDO CLIENTE, MODIFICADO
                customerList.get(1).getName()
        );

        // RESULTADO
        Assertions.assertEquals(
                "customer1 modified!", // PRIMER CLIENTE, MODIFICADO
                result.get(0).getName()
        );

        Assertions.assertEquals(
                "customer2 modified!", // SEGUNDO CLIENTE, MODIFICADO
                result.get(1).getName()
        );
    }

    @DisplayName("limit: Procesar con un límite de n elementos")
    @Test
    void limit() {
        List<Integer> processed = getIntegerList()
                .stream()
                .skip(4)
                .limit(3)
                .collect(Collectors.toList());

        Assertions.assertEquals(
                processed,
                List.of(5,6,7)
        );
    }

    @DisplayName("distinct: Procesar los elementos distintos, sin repetición")
    @Test
    void distinct() {
        List<Integer> processed = getIntegerList()
                .stream()
                .skip(2)        // 3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(10) // 3,4,5,6,7,8,7,6,5,4
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .collect(Collectors.toList());

        Assertions.assertEquals(
                processed,
                List.of(3,4,5,6,7,8)
        );
    }

    @DisplayName("filter: Procesar los elementos que cumplan el criterio del filtro")
    @Test
    void filter() {
        List<Integer> processed = getIntegerList()
                .stream()
                .skip(2)        // 3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(10) // 3,4,5,6,7,8,7,6,5,4
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .filter(it -> it >= 5)       // 5,6,7,8 - Utiliza el equals en este caso
                .collect(Collectors.toList());

        Assertions.assertEquals(
                List.of(5,6,7,8),
                processed
        );
    }

    @DisplayName("map: Transformación de los datos a otro tipo")
    @Test
    void map() {
        List<List<String>> processed = getIntegerList()
                .stream()
                .skip(1)        // 2,3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(12) // 3,4,5,6,7,8,7,6,5,4,3,2
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .filter(it -> it >= 4)       // 4,5,6,7,8 - Utiliza el equals en este caso
                .map(it -> List.of(it.toString()))
                .collect(Collectors.toList());

        Assertions.assertEquals(
                processed,
                List.of(
                        List.of("4"),
                        List.of("5"),
                        List.of("6"),
                        List.of("7"),
                        List.of("8")
                )
        );
    }

    @DisplayName("count: conteo de elementos resultantes")
    @Test
    void count() {
        long processed = getIntegerList()
                .stream()
                .skip(1)        // 2,3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(12) // 3,4,5,6,7,8,7,6,5,4,3,2
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .filter(it -> it >= 4)       // 4,5,6,7,8 - Utiliza el equals en este caso
                .map(it -> List.of(it.toString()))
                .count();

        Assertions.assertEquals(5, processed); // No da 1 listado, sino 5 elementos, porque el count se realizó sobre el list retornado del map.
    }

    @DisplayName("minMax: el valor mínimo y máximo de elementos resultantes. Para objetos se puede usar un comparador")
    @Test
    void minMax() {
        var min = getIntegerList()
                .stream()
                .skip(1)        // 2,3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(12) // 3,4,5,6,7,8,7,6,5,4,3,2
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .filter(it -> it >= 4)
                .min(Comparator.naturalOrder());

        var max = getIntegerList()
                .stream()
                .skip(1)        // 2,3,4,5,6,7,8,7,6,5,4,3,2,1
                .limit(12) // 3,4,5,6,7,8,7,6,5,4,3,2
                .distinct()       // 3,4,5,6,7,8 - Utiliza el equals en este caso
                .filter(it -> it >= 4)
                .max(Comparator.naturalOrder());

        Assertions.assertEquals(4, min.get());
        Assertions.assertEquals(8, max.get());
    }

    @DisplayName("minMax: basado en objetos. Se busca el de menor code.")
    @Test
    void minMaxObject() {
        List<Customer> customerList = List.of(
                Customer.builder().name("customer1").code("10").build(),
                Customer.builder().name("customer2").code("5").build()   // <---- Este es el de menor código.
        );

        var customerWithMinCode = customerList
                .stream()
                //.min((customer1, customer2) -> Integer.valueOf(customer1.getCode()) - Integer.valueOf(customer2.getCode()))
                .min(
                        Comparator.comparing(
                                (cust1) -> Integer.valueOf(cust1.getCode())
                        )
                )
                .orElse(null);

        Assertions.assertEquals("customer2", customerWithMinCode.getName());
        Assertions.assertEquals("5", customerWithMinCode.getCode());
    }

    @DisplayName("allMatch - anyMatch - noneMatch: Verifica si todos, alguno, o ningún elemento coincide con el criterio. Son operaciones cortocircuito.")
    @Test
    void allMatchAnyMatchNoneMatch() {
        List<Integer> numberList = List.of(2, 4, 5, 6, 8);

        boolean allEven = numberList.stream().allMatch(i-> i%2 == 0);
        boolean oneEven = numberList.stream().anyMatch(i-> i%2 == 0);
        boolean noneMultipleOfThree = numberList.stream().noneMatch(i-> i%3 == 0);

        Assertions.assertEquals(false, allEven); // ¿todos pares? No.
        Assertions.assertEquals(true, oneEven); // ¿hay un par? Sí.
        Assertions.assertEquals(false, noneMultipleOfThree); // ¿Ninguno es múltiplo de 3? No, porque sí hay múltiplos de 3.
    }

    @DisplayName("Streams de tipos primitivos. El stream no tiene todos los métodos de Stream, porque no hereda de él, sino de su padre: BaseStream.")
    @Test
    void streamOfPrimitives() {
        int[] arrayInt = {1,2,3,4};
        double[] arrayDouble = {1,2,3};
        long[] arrayLong = {1,2};

        Assertions.assertEquals(4, IntStream.of(arrayInt).count());
        Assertions.assertEquals(3, DoubleStream.of(arrayDouble).count());
        Assertions.assertEquals(2, LongStream.of(arrayLong).count());
    }

    @DisplayName("Streams infinitos. Crea valores contínuamente hasta un límite. El primer valor es el inicial. Mantiene estado, NO usar de forma paralela")
    @Test
    void infiniteStreams(){
        // Usando .iterate()
        // Un productorio de 5 iteraciones, de 2 a infinito..
        int resultado = IntStream.iterate(2, i-> i * 2).limit(5).sum();
        Assertions.assertEquals(2 + 4 + 8 + 16 + 32, resultado);

        // Otra forma es usando .generate()
        boolean noneNull = Stream.generate(Math::random)
                .limit(5)
                .allMatch(it -> it != null);

        Assertions.assertEquals(true, noneNull);
    }

    @DisplayName("Rangos. Creación de un rango desde incluyente, hasta excluyente")
    @Test
    void ranges(){
        // [10; 15)
        int resultado = IntStream.range(10, 15).sum();
        Assertions.assertEquals(10 + 11 + 12 + 13 + 14, resultado);
    }
}
