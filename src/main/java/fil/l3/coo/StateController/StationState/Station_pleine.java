package fil.l3.coo.StateController.StationState;
import java.util.Iterator;
import java.util.List;

import fil.l3.coo.*;
import fil.l3.coo.ExceptionsControlled.*;;

public class Station_pleine implements StationState {
    private List<Emplacement> places ;

    Station_pleine(List<Emplacement> liste){
        this.places = liste;
    }
    public void Deposer( Locations l , Station s) throws Exception {
        throw new StationPleine();
    }; 

    public Locations Retirer(Station s) throws Exception {
        Emplacement v = places.get(0);
        Locations m = v.Retirer();
        s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+m.getId_prod()+"A ETE RETIRE A LA STATION : "+s.getId_station());
        s.setPlaces_restantes(s.getPlaces_restantes()+1);
        s.SetState((StationState)new Station_EnCours(this.places));
        return m ;
    }
    public List<Emplacement> placesAvailbale(){
        return null ;
    } ;

    public void Louer(Client c , Station s) throws Exception{
        for( Emplacement e : this.places){
            if( e.isOccupe() && !e.getLocations().getEtatService()){
                Locations s1 = e.Retirer();
                c.Louer(s1);
                s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+s1.getId_prod()+"A ETE LOUER AU CLIENT  : "+c.getID_client());
                s.setPlaces_restantes(s.getPlaces_restantes()+1);
                s.SetState((StationState)new Station_EnCours(this.places));
                break ;
             }
        }
    };


public Locations Retirer( int id_prod , Station s) throws Exception{
            Iterator<Emplacement> l = s.getPlaces().iterator();
            while( l.hasNext()){
                Emplacement element = l.next();
                if(element.isOccupe() && element.getLocations().getId_prod() == id_prod){
                    s.setPlaces_restantes(s.getPlaces_restantes()+1);;
                    Locations v = element.Retirer();
                    s.getNotifier().notify("RETRAIT ", "\t LA LAOCATION : "+v.getId_prod()+"A ETE RETIRE A LA STATION : "+s.getId_station());
                    s.SetState((StationState)new Station_EnCours(this.places));
                    return v  ;
                }
            }
            throw new IdNotFound();
    }
    
}
