import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    private NamesGenerator.Names client;
    private String nom;
    private String prenom;

    public Client(NamesGenerator.Names client) {
        this.client = client;
    }

    public NamesGenerator.Names getClient() {
        return client;
    }

    //list de client
    private static List<Client> listClients = new ArrayList<>(Arrays.asList(
            new Client(NamesGenerator.generateNames())));

    public static List<Client> getClients() {
        return listClients;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
