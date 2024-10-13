import java.util.* ;


public class Station {
    private Set<Emplacement> places ; 
    private int nb_palces ;
    private int places_restantes ;


    public Station( int nb_places ){
        this.places = new TreeSet<Emplacement>();
        this.nb_palces = nb_places;
        this.places_restantes =nb_places;
       }

    public void Deposer( Locations l){
        this.places_restantes --;
    }

    public Locations Retirer ( Locations l){
        this.places_restantes++ ;
        return Locations ;
    }

    public void DeposerLot ( List<Locations> l){
        this.places_restantes = this.places_restante- l.size();
    }

    public List<Locations> RetirerLot( List<Locations> l){
        this.places_restantes = this.places_restantes + l.size();
    }
    
    
}
