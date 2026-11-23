package si.unilj.fri.prpo.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import si.unilj.fri.prpo.cdi.izjeme.DogodekNiNajdenException;
import si.unilj.fri.prpo.cdi.model.Dogodek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
class DogodekStoritevVPomnilniku implements DogodekStoritev {

    private final Map<String, Dogodek> dogodki = new ConcurrentHashMap<>();

    @Override
    public Dogodek ustvariDogodek(Dogodek dogodek) {
        String id = UUID.randomUUID().toString();
        Dogodek novDogodek = zIdentifikatorjem(id, dogodek);
        dogodki.put(id, novDogodek);
        return novDogodek;
    }

    @Override
    public void odstraniDogodek(String id) {
        if (dogodki.remove(id) == null) {
            throw new DogodekNiNajdenException(id);
        }
    }

    @Override
    public Dogodek pridobiDogodek(String id) {
        Dogodek dogodek = dogodki.get(id);
        if (dogodek == null) {
            throw new DogodekNiNajdenException(id);
        }
        return dogodek;
    }

    @Override
    public List<Dogodek> pridobiDogodke() {
        return new ArrayList<>(dogodki.values());
    }

    @Override
    public Dogodek posodobiDogodek(String id, Dogodek dogodek) {
        Dogodek posodobljenDogodek = zIdentifikatorjem(id, dogodek);
        if (dogodki.replace(id, posodobljenDogodek) == null) {
            throw new DogodekNiNajdenException(id);
        }
        return posodobljenDogodek;
    }

    private static Dogodek zIdentifikatorjem(String id, Dogodek dogodek) {
        return new Dogodek(id, dogodek.ime(), dogodek.cena(), dogodek.datum(), dogodek.lokacija());
    }
}
