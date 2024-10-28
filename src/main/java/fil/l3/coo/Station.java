package fil.l3.coo;
import java.util.* ;

import fil.l3.coo.ExceptionsControlled.IdNotFound;
import fil.l3.coo.ExceptionsControlled.NotPlacesAvailable;
import fil.l3.coo.ExceptionsControlled.StationVide;


public class Station {
    private Set<Locations> places ; 
    private int nb_palces ;
    private int places_restantes ;


    public Station( int nb_places ){
        this.places = new TreeSet<Locations>();
        this.nb_palces = nb_places;
        this.places_restantes =nb_places;
       }

    public void Deposer( Locations l) throws Exception{
        if(this.placesAvailbale()){
            this.places.add(l);
            this.places_restantes --;
        }else{
            throw new NotPlacesAvailable(); 
        }
    }

    public Locations Retirer ( int id_prod) throws Exception{
        if( ! this.StationVide()){
            Iterator<Locations> l = getPlaces().iterator();
            boolean end = false ;
            while(! end && l.hasNext()){
                Locations element = l.next();
                if(element.getId_prod() == id_prod){
                    end = true ;
                    l.remove();
                    this.places_restantes ++;
                    return element ;
                 }
            }
            throw new IdNotFound();
        }else{
            throw new StationVide(); 
        }
    }

    public boolean StationVide (){
        return this.places_restantes == nb_palces ;
    }

    public boolean placesAvailbale(){
        return this.places_restantes !=  0 ;
    }

    public void DeposerLot ( List<Locations> l){
        this.places_restantes = this.places_restantes- l.size();
    }

    public List<Locations> RetirerLot( List<Locations> l){
        this.places_restantes = this.places_restantes + l.size();
        List<Locations> m = new ArrayList<>();
        return m ;
    }

    public int getPlaces_restantes() {
        return places_restantes;
    }

    public Set<Locations> getPlaces() {
        return places;
    }

    
    
    
}
