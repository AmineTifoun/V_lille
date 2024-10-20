package fil.l3.coo;
import java.util.* ;


public class Station {
    private Set<Emplacment> places ; 
    private int nb_palces ;
    private int places_restantes ;


    public Station( int nb_places ){
        this.places = new TreeSet<Emplacment>();
        this.nb_palces = nb_places;
        this.places_restantes =nb_places;
       }

    public void Deposer( Locations l){
        this.places_restantes --;
    }

    public Locations Retirer ( Locations l){
        this.places_restantes++ ;
        return l ;
    }

    public void DeposerLot ( List<Locations> l){
        this.places_restantes = this.places_restantes- l.size();
    }

    public List<Locations> RetirerLot( List<Locations> l){
        this.places_restantes = this.places_restantes + l.size();
        List<Locations> m = new ArrayList<>();
        return m ;
    }
    
    
}
