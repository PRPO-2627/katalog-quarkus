# Katalog – Quarkus

Minimalen večmodulni projekt Maven, ki prikazuje REST API, izdelan z ogrodjem
Quarkus. Korenski projekt je pripravljen za dodatne module; trenutno vsebuje
modul `katalog-rest`.

## Zahteve

- Java 25 ali novejša
- Maven 3.9 ali novejši

## Gradnja

```shell
mvn clean package
```

## Zagon

```shell
mvn -pl katalog-rest quarkus:dev
```

Aplikacija posluša na naslovu `http://localhost:8080`. Preizkusite obe končni
točki:

```shell
curl http://localhost:8080/v1/katalog
curl -X POST http://localhost:8080/v1/katalog \
  -H 'Content-Type: application/json' \
  -d '{"name":"example"}'
```