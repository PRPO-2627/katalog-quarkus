package si.unilj.fri.prpo.cdi;

import java.util.List;

import si.unilj.fri.prpo.cdi.model.Dogodek;

public interface DogodekStoritev {

    Dogodek ustvariDogodek(Dogodek dogodek);

    void odstraniDogodek(String id);

    Dogodek pridobiDogodek(String id);

    List<Dogodek> pridobiDogodke();

    Dogodek posodobiDogodek(String id, Dogodek dogodek);
}
