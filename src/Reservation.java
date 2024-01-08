import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation{

    private String reservationDate;

    public Reservation(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getDateReservation() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
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
