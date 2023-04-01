package practices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;

@DisplayName("Test simples de ejemplo de uso de streams")
class SimpleOptionalTests {
    Optional<String> returnString(){
        return Optional.of("abc");
    }

    Optional<String> returnEmpty(){
        return Optional.empty();
    }

    OptionalInt returnOptionalPrimitiveInt(){
        return OptionalInt.of(5);
    }

    @DisplayName("Optionals se crean con .of()")
    @Test
    void creation() {
        Assertions.assertTrue(
                Optional.of(1) instanceof Optional<Integer>
        );
    }

    @DisplayName("No se puede usar of() con null, para eso usar ofNullable()")
    @Test
    void ofNullable() {
        Assertions.assertThrowsExactly(
                NullPointerException.class,
                ()-> Optional.of(null)
        );

        Assertions.assertSame(
                Optional.ofNullable(null), Optional.empty()
        );
    }

    @DisplayName("Se obtiene el valor interno con get() aunque no es la forma más útil de trabajar")
    @Test
    void getValue() {
        Assertions.assertSame(
                1, Optional.of(1).get()
        );
    }

    @DisplayName("Si hay un valor .isPresent() da true")
    @Test
    void isPresent() {
        Assertions.assertSame(
                true, Optional.of(1).isPresent()
        );

        Assertions.assertSame(
                false, Optional.empty().isPresent()
        );
    }

    /*
    @DisplayName(".ifPresent(()->{}:void) ejecuta una lambda si hay un valor")
    @Test
    void ifPresent() {
        servicio
            .getCustomer("123")
            .ifPresent(customer->
                servicio.savePurchase(customer.code)
            )
    }
     */

    @DisplayName(".orElse() retorna un valor por defecto si el opcional está vacío")
    @Test
    void orElse() {
        Assertions.assertSame(
                "abc", returnString().orElse("noTeniaValor")
        );

        Assertions.assertSame(
                "noTeniaValor", returnEmpty().orElse("noTeniaValor")
        );
    }

    @DisplayName(".orElseGet() en vez de retornar un simple valor, retorna el resultado de una lambda")
    @Test
    void orElseGet() {
        Assertions.assertSame(
                "abc", returnString().orElseGet(()->{ return "noTeniaValor" ;})
        );

        Assertions.assertSame(
                "noTeniaValor", returnEmpty().orElseGet(()->{ return "noTeniaValor" ;})
        );
    }

    @DisplayName(".orElseThrow() en vez de retornar un valor, retorna excepción")
    @Test
    void orElseThrow() {
        Assertions.assertSame(
                "abc", returnString().orElseThrow(()-> new NumberFormatException() )
        );

        Assertions.assertThrowsExactly(
                NumberFormatException.class,
                ()-> returnEmpty().orElseThrow(()-> new NumberFormatException() )
        );
    }

    @DisplayName("Los tipos primitivos también tienen su optional, por ej int tiene OptionalInt")
    @Test
    void optionalInt() {
        Assertions.assertSame(
                5,returnOptionalPrimitiveInt().getAsInt()
        );
    }
}
