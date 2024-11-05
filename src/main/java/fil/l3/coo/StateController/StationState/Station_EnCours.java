package fil.l3.coo.StateController.StationState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fil.l3.coo.*;
import fil.l3.coo.ExceptionsControlled.IdNotFound;
import fil.l3.coo.ExceptionsControlled.NotPlacesAvailable;


public class Station_EnCours implements StationState{
    private List<Emplacement> places ; 

    public Station_EnCours(List<Emplacement> places){
        this.places = places ;
    }


    public void Deposer( Locations l , Station s) throws Exception{
        System.out.println("*******************EN COURS*********************");
        List <Emplacement> dispo = this.placesAvailbale() ;
        System.out.println(dispo);
        Emplacement e = dispo.get(0);
        e.Deposer(l);
        s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+l.getId_prod()+"A ETE DEPOSE A LA STATION : "+s.getId_station());
        s.setPlaces_restantes(s.getPlaces_restantes()-1);
        if(s.isStationPleine()){
            s.SetState((StationState)new Station_pleine(this.places));
        }
    }

       public List<Emplacement> placesAvailbale(){
        List<Emplacement> l = new ArrayList<Emplacement>();
        for( Emplacement e : this.places){
            if( !e.isOccupe()){
                l.add(e);
            }
        }
        return l ; 
    }
    public Locations Retirer(Station s) throws Exception {
        for(Emplacement v : this.places){
            if( v.isOccupe()){
                Locations m = v.Retirer();
                s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+m.getId_prod()+"A ETE RETIRE A LA STATION : "+s.getId_station());
                s.setPlaces_restantes(s.getPlaces_restantes()+1);
                if( s.StationVide())
                 {s.SetState((StationState)new Station_Vide(this.places));}
                return m ;
            }
        }
        throw new Exception("THERE IS A STATION ISSUE");
    }
    
    public void Louer(Client c ,Station s) throws Exception{
        for( Emplacement e : this.places){
            if( e.isOccupe() && !e.getLocations().getEtatService()){
                Locations s1 = e.Retirer();
                c.Louer(s1);
                s.getNotifier().notify("DEPOT ", "\t LA LAOCATION : "+s1.getId_prod()+"A ETE LOUER AU CLIENT  : "+c.getID_client());
                s.setPlaces_restantes(s.getPlaces_restantes()+1);
                if( s.StationVide()){s.SetState((StationState)new Station_Vide(this.places));}
                break ;
             }
        }
    }

    public Locations Retirer( int id_prod , Station s) throws Exception{
            Iterator<Emplacement> l = s.getPlaces().iterator();
            while( l.hasNext()){
                Emplacement element = l.next();
                if(element.isOccupe() && element.getLocations().getId_prod() == id_prod){
                    s.setPlaces_restantes(s.getPlaces_restantes()+1);;
                    Locations v = element.Retirer();
                    s.getNotifier().notify("RETRAIT ", "\t LA LAOCATION : "+v.getId_prod()+"A ETE RETIRE A LA STATION : "+s.getId_station());
                    if( s.StationVide()){s.SetState((StationState)new Station_Vide(this.places));}
                    return v  ;
                }
            }
            throw new IdNotFound();
    }
}


    

