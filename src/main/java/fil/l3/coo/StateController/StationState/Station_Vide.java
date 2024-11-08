package fil.l3.coo.StateController.StationState;
import fil.l3.coo.*;
import fil.l3.coo.ExceptionsControlled.*;
import java.util.*;

public class Station_Vide implements StationState{
    private List<Emplacement> places ;

    public Station_Vide(List<Emplacement> places){
        this.places = places ;
    }
    public Locations Retirer(Station s) throws Exception {
        throw new StationVide() ;
    }

    public Locations Retirer(int id_prod ,Station s) throws Exception{
        throw new StationVide();
    }
    public List<Emplacement> placesAvailbale(){
        return this.places ;
    }

    public void Louer(Client c , Station s) throws Exception{
        throw new StationVide();
    }

    @Override
    public void Deposer( Locations l , Station s ) throws Exception{
        List <Emplacement> dispo = this.placesAvailbale() ;
        if( dispo.size()==0){
            throw new NotPlacesAvailable();
        }else{
        Emplacement e = dispo.get(0);
        e.Deposer(l);
        s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+l.getId_prod()+"A ETE DEPOSE A LA STATION : "+s.getId_station());
        s.setPlaces_restantes(s.getPlaces_restantes()-1);
        s.SetState((StationState)new Station_EnCours(this.places));
        }
    }
 


    
}
