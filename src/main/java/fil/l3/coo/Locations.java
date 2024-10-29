package fil.l3.coo;

public interface Locations extends Comparable<Locations> {
     void Louer();
     float getPrixLocation();
     boolean getEtatService();
     int get_NbLocation();
     void set_NbLocation(int nb);
     void ChangeStateService();
     float getCaution();
     int getIdDeuxRoues();
     Boolean estVole();
     int compareTo(Locations other) ;
     int getId_prod();
}
