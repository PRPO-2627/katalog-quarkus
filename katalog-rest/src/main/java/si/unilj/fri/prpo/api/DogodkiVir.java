package si.unilj.fri.prpo.api;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;
import si.unilj.fri.prpo.api.model.Dogodek;

@ApplicationScoped
public class DogodkiVir implements DogodkiApi {

    @Inject
    DogodkiStoritev dogodkiStoritev;

    @Override
    public Dogodek createDogodek(@Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za dodajanje dogodka!");
        return dogodkiStoritev.ustvariDogodek(dogodek);
    }

    @Override
    public void deleteDogodek(String id) {
        System.out.println("Poklicana je bila metoda za odstranitev dogodka!");
        try {
            dogodkiStoritev.odstraniDogodek(id);
        } catch (DogodekNiNajdenException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public Dogodek getDogodekById(String id) {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka po ID!");
        try {
            return dogodkiStoritev.pridobiDogodek(id);
        } catch (DogodekNiNajdenException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<Dogodek> getDogodki() {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka!");
        return dogodkiStoritev.pridobiDogodke();
    }

    @Override
    public Dogodek updateDogodek(String id, @Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za posodobitev dogodka po ID!");
        try {
            return dogodkiStoritev.posodobiDogodek(id, dogodek);
        } catch (DogodekNiNajdenException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
