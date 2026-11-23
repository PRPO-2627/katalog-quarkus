package si.unilj.fri.prpo.cdi.model;

import java.time.OffsetDateTime;

public record Dogodek(String id, String ime, Double cena, OffsetDateTime datum, Lokacija lokacija) {
}
