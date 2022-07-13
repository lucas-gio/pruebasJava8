[![Java CI with Maven](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml/badge.svg)](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8/badge)](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8)

<p>
    <a href="https://github.com/lucas-gio/pruebasJava8/">English</a> | 
    <a href="https://github.com/lucas-gio/pruebasJava8/tree/main/lang/pt/README.md">Português</a> | 
   <a href="#">Español</a> 
</p>

# Prácticas de java 8

Varias prácticas en java 8 utilizando pruebas de Junit.

# Temas

## Operaciones intermedias y terminales

[IntermediateAndTerminalOperationsTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/IntermediateAndTerminalOperationsTests.java)
Contiene las siguientes prácticas:

* [foreachTest](#): Realiza un 10% de descuento por cada item, y compara con una multiplicación manual.
* [mapTest](#): .map() y .collect() Recolecta cada código de items de la venta y verifica el resultado con cada código de item esperado.
* [filterTest](#): .filter() Filtra la lista de items, sólo los mayores a $300 y menores a $2000 y verifica los con los códigos esperados.

## Streams

[StreamCreationTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/StreamCreationTests.java) incluye:

* [streamArrayBased](#): Stream.of() Crea el stream basado en array y verifica que no sea null, además de verificar su conteo.
* [listArrayBased](#): Arrays.asList() Crea el stream basado en una lista y verifica que no sea null además de verificar su tamaño.
* [collectionStreamBased](#): Collection.stream() Crea el stream basado en una colección (Set) y verifica que no sea null, además de verificar su tamaño.
* [separatedElementsStreamBased](#): Stream.of() Crea el stream basado en objetos vararg, verifica que no sea null, su tamaño esperado, y los elementos que debería tener.