package practices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Test simples de ejemplo de uso")
class SimpleTests {
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
}
