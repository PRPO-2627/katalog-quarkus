package si.unilj.fri.prpo.api;

public class DogodekNiNajdenException extends RuntimeException {

    public DogodekNiNajdenException(String id) {
        super("Dogodek ni bil najden: " + id);
    }
}
