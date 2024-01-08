import java.util.List;
import java.util.Scanner;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class EntryPoint {

    public static void main(String[] args) {
        // configurez ici votre école :
        // - Instantiation de vos voitures, clients, responsables...
        // - Le programme est déjà pré écrit, il ne reste qu'à compléter les TODO

        System.out.println("/_\\ Bienvenue sur LocaLux car manager!");

        // la Console permet de faciliter la récupération d'une saisie de l'utilisateur dans la console
        Console console = new Console();
        int functionToRun = -1;
        do {
            System.out.println("Qu'est-ce que tu veux faire?");
            System.out.println("1 - Lister les voitures disponibles");
            System.out.println("2 - Effectuer une réservation");
            System.out.println("3 - J'ai fini");

            functionToRun = console.captureInt(1, 4);
            // contrôle de la saisie
            switch (functionToRun) {
                case 1:
                    // TODO FS1 : Lister les voitures disponibles
                    System.out.println("Voici la liste des voitures disponibles");
                    List<Voiture> voituresDisponibles = Voiture.getVoiture();
                    for (int i = 0; i < voituresDisponibles.size(); i++) {
                        Voiture voiture = voituresDisponibles.get(i);
                        System.out.println((i + 1) + ". " + voiture.getMarque() + " " + voiture.getModele());
                    }
                    break;
                case 2:
                    // TODO FP1 : réserver une voiture
                    System.out.println("A quelle date souhaitez-vous réserver votre voiture?");
                    String dateReservation = console.captureString();

                    // Générer une réservation avec un nom aléatoire et une date fixe (à remplacer par votre logique)
                    Reservation reservation = new Reservation(NamesGenerator.generateNames(), dateReservation);

                    // Récupérer les détails du client (nom complet)
                    NamesGenerator.Names client = NamesGenerator.generateNames();
                    String prenom = client.getFirstName();
                    String nom = client.getLastName();

                    // Vérifier si une réservation existe déjà pour cette date
                    if (!Reservation.reservationDejaExistante(Reservation.getReservations(), reservation.getDateReservation())) {
                        // Ajouter la réservation à la liste
                        Reservation.getReservations().add(reservation);

                        // Afficher les détails de la réservation
                        System.out.println("Réservation effectuée avec succès");
                        System.out.println("Nom et prénom du client : " + prenom + " " + nom);
                        System.out.println("Date de réservation : " + reservation.getDateReservation());
                    } else {
                        System.err.println("Une réservation existe déjà pour cette date");
                    }

                    System.out.println("###################################################");
                    System.out.println("Quelle voiture souhaitez-vous réserver?");

                    List<Voiture> voitures = Voiture.getVoiture();

                    for (int i = 0; i < voitures.size(); i++) {
                        Voiture voiture = voitures.get(i);
                        System.out.println((i + 1) + " - " + voiture.getMarque() + " " + voiture.getModele());
                    }

                    int choixVoiture = console.captureInt(1, voitures.size());

                    Voiture voitureChoisie = voitures.get(choixVoiture - 1);

                    System.out.println("Vous avez choisi la voiture : " + voitureChoisie.getMarque() + " " + voitureChoisie.getModele());

                case 3:
                    System.out.println("A la prochaine!");
                default:
                    System.err.println("Saisie invalide... tu dois choisir entre 1 et 3");
            }
            System.out.println("###################################################");

        } while (functionToRun != 3);

    }
}
