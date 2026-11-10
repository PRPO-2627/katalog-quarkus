package si.unilj.fri.prpo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;
import si.unilj.fri.prpo.api.model.Dogodek;

@ApplicationScoped
public class DogodkiVir implements DogodkiApi {
    private final Map<String, Dogodek> dogodki = new ConcurrentHashMap<>();

    @Override
    public Dogodek createDogodek(@Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za dodajanje dogodka!");
        dogodek.setId(UUID.randomUUID().toString());
        dogodki.put(dogodek.getId(), dogodek);
        return dogodek;
    }

    @Override
    public void deleteDogodek(String id) {
        System.out.println("Poklicana je bila metoda za odstranitev dogodka!");
        if (dogodki.remove(id) == null) {
            throw new NotFoundException("Dogodek ni bil najden.");
        }
    }

    @Override
    public Dogodek getDogodekById(String id) {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka po ID!");
        Dogodek dogodek = dogodki.get(id);
        if (dogodek == null) {
            throw new NotFoundException("Dogodek ni bil najden.");
        }
        return dogodek;
    }

    @Override
    public List<Dogodek> getDogodki() {
        System.out.println("Poklicana je bila metoda za pridobitev dogodka!");
        return new ArrayList<>(dogodki.values());
    }

    @Override
    public Dogodek updateDogodek(String id, @Valid @NotNull Dogodek dogodek) {
        System.out.println("Poklicana je bila metoda za posodobitev dogodka po ID!");

        if (!dogodki.containsKey(id)) {
            throw new NotFoundException("Dogodek ni bil najden.");
        }
        dogodek.setId(id);
        dogodki.put(id, dogodek);
        return dogodek;
    }
}


