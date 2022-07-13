[![Java CI with Maven](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml/badge.svg)](https://github.com/lucas-gio/pruebasJava8/actions/workflows/maven.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8/badge)](https://www.codefactor.io/repository/github/lucas-gio/pruebasjava8)

<p>
<a href="https://github.com/lucas-gio/pruebasJava8/">English</a> | 
  <a href="#">Português</a> | 
   <a href="https://github.com/lucas-gio/pruebasJava8/tree/main/lang/es/README.md/">Español</a> 
</p>

# Práticas de Java 8

Várias práticas de java 8 utilizando testes Junit.

# Tópicos

## Operações intermédias e terminais

[IntermediateAndTerminalOperationsTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/IntermediateAndTerminalOperationsTests.java)
Contém as seguintes práticas:

* [foreachTest](#): Faz um desconto de 10% para cada item, e compara com uma multiplicação manual.
* [mapTest](#): .map() y .collect() Coleta cada código de item da venda e verifica o resultado em relação a cada código
  de item esperado.
* [filterTest](#): .filter() Filtra a lista de itens, somente aqueles acima de $300 e abaixo de $2000 e verifica em
  relação aos códigos esperados.

## Streams

[StreamCreationTests](https://github.com/lucas-gio/pruebasJava8/blob/main/src/test/java/practices/StreamCreationTests.java) incluindo:

* [streamArrayBased](#): Stream.of() isto Cria o fluxo baseado no array e verifica que ele não é nulo, além de verificar
  sua contagem.
* [listArrayBased](#): Arrays.asList() Cria o fluxo com base em uma lista e verifica que não é nulo além de verificar seu
  tamanho.
* [collectionStreamBased](#): Collection.stream() Cria o fluxo baseado em uma coleção (Set) e verifica que não é nulo,
  além de verificar seu tamanho.
* [separatedElementsStreamBased](#): Stream.of() Cria o fluxo baseado em objetos vararg, verifica se não é nulo, seu
  tamanho esperado, e os elementos que deve ter.