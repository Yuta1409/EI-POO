import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation extends Client {

    private NamesGenerator.Names client;
    private String reservationDate;

    public Reservation(String nom, String prenom, String reservationDate) {
        super(nom, prenom);
        this.reservationDate = reservationDate;
    }

    // getter et setter
    public NamesGenerator.Names getClient() {
        return client;
    }
    public void setClient(NamesGenerator.Names client) {
        this.client = client;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getDateReservation() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", reservationDate='" + reservationDate + '\'' +
                '}';
    }

    protected static List<Reservation> reservations = new ArrayList<>();

    protected static List<Reservation> getReservations() {
        return reservations;
    }

    protected static boolean reservationDejaExistante(List<Reservation> reservations, String dateReservation) {
        // Vérifier s'il existe déjà une réservation pour la date donnée
        return reservations.stream()
                .anyMatch(reservation -> reservation.getDateReservation().equals(dateReservation));
    }

}
