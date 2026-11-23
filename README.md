# Katalog – Quarkus

Minimalen večmodulni projekt Maven, ki prikazuje REST API, izdelan z ogrodjem
Quarkus. Modul `katalog-rest` vsebuje REST vmesnik, modul `katalog-cdi` pa
CDI storitev za upravljanje dogodkov v pomnilniku.

## Zahteve

- Java 25 ali novejša
- Maven 3.9 ali novejši

## Gradnja

```shell
mvn clean package
```

## Zagon

```shell
mvn -pl katalog-rest -am compile io.quarkus:quarkus-maven-plugin:3.40.1.1:dev
```

Aplikacija posluša na naslovu `http://localhost:8080`. Preglej končne točke na `http://localhost:8080/api/v1/q/swagger-ui/`
