[![Java CI with Maven](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml/badge.svg)](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8/badge)](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8)

<p>
  <a href="#">English</a> |
  <a href="https://github.com/lucas-gio/pruebasJava8/tree/main/lang/pt/README.md">Português</a> |
   <a href="https://github.com/lucas-gio/pruebasJava8/tree/main/lang/es/README.md/">Español</a> 
</p>

# Java 8 practices

Various practices in Java 8 using Junit test.

# Topics

## Intermediate and terminal operations

[IntermediateAndTerminalOperationsTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/IntermediateAndTerminalOperationsTests.java)
contains this practices and includes:

* [foreachTest](): Perform an 10% discount for each item, and compares with manual multiply.
* [mapTest](): .map() and .collect() Collect the codes of the sale and verify the result with each expected item code.
* [filterTest](): .filter() Filter the list of items, only greater than $300 and less than $2000 and verify with
  expected codes.

## Streams

[StreamCreationTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/StreamCreationTests.java)
includes:

* [streamArrayBased](): Stream.of() Creates the array based stream and checks not null and the expected count.
* [listArrayBased](): Arrays.asList() Creates the list based stream and checks not null and the expected size.
* [collectionStreamBased](): Collection.stream() Creates the collection (Set) based stream and checks not null and the
  expected size.
* [separatedElementsStreamBased](): Stream.of() Creates the vararg objects based stream and checks not null, the
  expected count, and the expected elements.
