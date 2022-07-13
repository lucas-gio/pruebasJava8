package practices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Operaciones intermedias y terminales")
public class IntermediateAndTerminalOperationsTests {

    @DisplayName("For each: Se calcula el 5% a de dto. a cada producto de la venta realizada.")
    @Test public void foreachTest(){
        final BigDecimal DISCOUNT = new BigDecimal("0.1");

        // Se genera una venta y a cada elemento se le aplica el descuento.
        Sale testSale = getTestSale();
        testSale.itemList
            .forEach(this::calculateDiscount);

        Sale originalSale = getTestSale();

        // Se verifica luego cada valor modificado de los productos con el valor que deberían tener.
        Assertions.assertEquals(testSale.itemList.get(0).value, originalSale.itemList.get(0).value.multiply(DISCOUNT));
        Assertions.assertEquals(testSale.itemList.get(1).value, originalSale.itemList.get(1).value.multiply(DISCOUNT));
        Assertions.assertEquals(testSale.itemList.get(2).value, originalSale.itemList.get(2).value.multiply(DISCOUNT));
        Assertions.assertEquals(testSale.itemList.get(3).value, originalSale.itemList.get(3).value.multiply(DISCOUNT));
    }

    @DisplayName("Map: De la venta, se obtienen los códigos de los item comprados.")
    @Test public void mapTest(){
        Sale testSale = getTestSale();
        List<String> soldItemCodes = testSale.itemList
                .stream()
                .map(Item::getCode)
                .collect(Collectors.toList());

        Assertions.assertTrue(soldItemCodes.contains(testSale.itemList.get(0).getCode()));
        Assertions.assertTrue(soldItemCodes.contains(testSale.itemList.get(1).getCode()));
        Assertions.assertTrue(soldItemCodes.contains(testSale.itemList.get(2).getCode()));
        Assertions.assertTrue(soldItemCodes.contains(testSale.itemList.get(3).getCode()));
    }

    @DisplayName("filter: De la lista de items, se obtienen los que su valor está entre $300 y $2000")
    @Test public void filterTest(){
        BigDecimal MIN = new BigDecimal(300);
        BigDecimal MAX = new BigDecimal(2000);

        List<String> filteredItemCodeList = getTestItems()
                .stream()
                .filter((Item i)-> i.getValue() != null)
                .filter((Item i)-> i.getValue().compareTo(MIN) > 0)
                .filter((Item i)-> i.getValue().compareTo(MAX) < 0)
                .map(Item::getCode)
                .collect(Collectors.toList());

        Assertions.assertEquals(filteredItemCodeList.size(), 4);
        Assertions.assertTrue(filteredItemCodeList.contains("10"));
        Assertions.assertTrue(filteredItemCodeList.contains("13"));
        Assertions.assertTrue(filteredItemCodeList.contains("14"));
        Assertions.assertTrue(filteredItemCodeList.contains("17"));
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void calculateDiscount (Item item){
        item.value = item.value.multiply(new BigDecimal("0.1"));
    }

    private Sale getTestSale(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(Item.builder().code("1111").name("Atún").value(new BigDecimal(100)).build());
        itemList.add(Item.builder().code("2222").name("Harina").value(new BigDecimal(200)).build());
        itemList.add(Item.builder().code("3333").name("Sandía").value(new BigDecimal(300)).build());
        itemList.add(Item.builder().code("4444").name("Arroz").value(new BigDecimal(400)).build());

        Customer customer = Customer.builder().code("1").name("cliente1").build();

        return Sale.builder().itemList(itemList).customer(customer).build();
    }

    private List<Item> getTestItems(){
        List<Item> itemList = new ArrayList<>();

        itemList.add(Item.builder().code("10").name("Item10").value(new BigDecimal(323)).build());
        itemList.add(Item.builder().code("11").name("Item11").value(new BigDecimal(154)).build());
        itemList.add(Item.builder().code("12").name("Item12").value(new BigDecimal(264)).build());
        itemList.add(Item.builder().code("13").name("Item13").value(new BigDecimal(445)).build());
        itemList.add(Item.builder().code("14").name("Item14").value(new BigDecimal(775)).build());
        itemList.add(Item.builder().code("15").name("Item15").value(new BigDecimal(2633)).build());
        itemList.add(Item.builder().code("16").name("Item16").value(new BigDecimal("23.52")).build());
        itemList.add(Item.builder().code("161").name("Item16").build());
        itemList.add(Item.builder().code("162").name("Item16").build());
        itemList.add(Item.builder().code("17").name("Item17").value(new BigDecimal("1002.52")).build());
        itemList.add(Item.builder().code("18").name("Item18").value(new BigDecimal(235)).build());
        itemList.add(Item.builder().code("19").name("Item19").value(new BigDecimal(32)).build());
        itemList.add(Item.builder().code("20").name("Item20").value(new BigDecimal(15532)).build());
        itemList.add(Item.builder().code("21").name("Item21").value(new BigDecimal(2351)).build());

        return itemList;
    }
}
