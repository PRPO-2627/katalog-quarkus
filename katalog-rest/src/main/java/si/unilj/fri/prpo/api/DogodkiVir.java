package si.unilj.fri.prpo.api;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import si.unilj.fri.prpo.api.model.Dogodek;
import si.unilj.fri.prpo.api.model.Lokacija;
import si.unilj.fri.prpo.cdi.DogodekStoritev;

@ApplicationScoped
public class DogodkiVir implements DogodkiApi {

    private final DogodekStoritev storitev;

    @Inject
    DogodkiVir(DogodekStoritev storitev) {
        this.storitev = storitev;
    }

    @Override
    public Dogodek createDogodek(@Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za dodajanje dogodka!");
        return vDto(storitev.ustvariDogodek(vDomeno(dogodek)));
    }

    @Override
    public void deleteDogodek(String id) {
        System.out.println("Poklicana je bila metoda za odstranitev dogodka!");
        storitev.odstraniDogodek(id);
    }

    @Override
    public Dogodek getDogodekById(String id) {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka po ID!");
        return vDto(storitev.pridobiDogodek(id));
    }

    @Override
    public List<Dogodek> getDogodki() {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka!");
        return storitev.pridobiDogodke().stream().map(DogodkiVir::vDto).toList();
    }

    @Override
    public Dogodek updateDogodek(String id, @Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za posodobitev dogodka po ID!");
        return vDto(storitev.posodobiDogodek(id, vDomeno(dogodek)));
    }

    private static si.unilj.fri.prpo.cdi.model.Dogodek vDomeno(Dogodek dogodek) {
        Lokacija lokacija = dogodek.getLokacija();
        return new si.unilj.fri.prpo.cdi.model.Dogodek(
                dogodek.getId(), dogodek.getIme(), dogodek.getCena(), dogodek.getDatum(),
                new si.unilj.fri.prpo.cdi.model.Lokacija(lokacija.getIme(), lokacija.getNaslov()));
    }

    private static Dogodek vDto(si.unilj.fri.prpo.cdi.model.Dogodek dogodek) {
        return new Dogodek()
                .id(dogodek.id())
                .ime(dogodek.ime())
                .cena(dogodek.cena())
                .datum(dogodek.datum())
                .lokacija(new Lokacija().ime(dogodek.lokacija().ime()).naslov(dogodek.lokacija().naslov()));
    }
}
