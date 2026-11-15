package si.unilj.fri.prpo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import si.unilj.fri.prpo.api.model.Dogodek;

@Startup
@ApplicationScoped
public class DogodkiStoritev {
    private final Map<String, Dogodek> dogodki = new ConcurrentHashMap<>();

    @PostConstruct
    void inicializacija() {
        System.out.println("Storitev DogodkiStoritev je bila ustvarjena!");
    }

    public Dogodek ustvariDogodek(Dogodek dogodek) {
        dogodek.setId(UUID.randomUUID().toString());
        dogodki.put(dogodek.getId(), dogodek);
        return dogodek;
    }

    public void odstraniDogodek(String id) {
        if (dogodki.remove(id) == null) {
            throw new DogodekNiNajdenException(id);
        }
    }

    public Dogodek pridobiDogodek(String id) {
        Dogodek dogodek = dogodki.get(id);
        if (dogodek == null) {
            throw new DogodekNiNajdenException(id);
        }
        return dogodek;
    }

    public List<Dogodek> pridobiDogodke() {
        return new ArrayList<>(dogodki.values());
    }

    public Dogodek posodobiDogodek(String id, Dogodek dogodek) {
        if (!dogodki.containsKey(id)) {
            throw new DogodekNiNajdenException(id);
        }
        dogodek.setId(id);
        dogodki.put(id, dogodek);
        return dogodek;
    }
}
