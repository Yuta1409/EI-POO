import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voiture {

    private String marque;
    private String modele;

    public Voiture(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;

    }
    private static List<Voiture> voiture = new ArrayList<>(Arrays.asList(
            new Voiture("Renault", "Clio"),
            new Voiture("Ferrari", "F40"),
            new Voiture("Tesla", "S")
    ));

    public static List<Voiture> getVoiture() {
        return voiture;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }


}
