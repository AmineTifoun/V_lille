package fil.l3.coo;

public interface Locations {
     void Louer();
     float getPrixLocation();
     boolean getEtatService();
     int get_NbLocation();
     void set_NbLocation(int nb);
     void ChangeStateService();
     float getCaution();
     int getIdDeuxRoues();
     Boolean estVole();
}
