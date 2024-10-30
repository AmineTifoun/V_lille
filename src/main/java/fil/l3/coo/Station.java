package fil.l3.coo;
import java.util.* ;

import fil.l3.coo.ExceptionsControlled.IdNotFound;
import fil.l3.coo.ExceptionsControlled.NotInService;
import fil.l3.coo.ExceptionsControlled.NotPlacesAvailable;
import fil.l3.coo.ExceptionsControlled.StationVide;


public class Station {
    private int id_station ;
    private List<Emplacement> places ; 
    private int nb_palces ;
     private GestionnaireNotif notifier=  new GestionnaireNotif() ;
    private int places_restantes ;
    static int current_id =0 ; 


    public Station( int nb_places ){
        this.places = new ArrayList<Emplacement>();
        for( int i = 1 ; i<= nb_places ; i++){
            Emplacement e = new Emplacement();
            this.places.add( e );
        }
        this.nb_palces = nb_places;
        this.places_restantes =nb_places;
        this.id_station = current_id ; 
        Incremente_ID();
       }

    static void Incremente_ID(){
        current_id ++ ; 
    }
    public void Deposer( Locations l) throws Exception{
        List <Emplacement> dispo = this.placesAvailbale() ;
        if(this.places.size() != 0){
            Emplacement e = dispo.get(0);
            e.Deposer(l);
            this.notifier.notify("DEPOT ", "\t LA LAOCATION : "+l.getId_prod()+"A ETE DEPOSE A LA STATION : "+this.id_station);
            this.places_restantes --;
        }else{
            throw new NotPlacesAvailable(); 
        }
    }

    public Locations Retirer ( int id_prod) throws Exception{
        if( !this.StationVide()){
            Iterator<Emplacement> l = getPlaces().iterator();
            while( l.hasNext()){
                Emplacement element = l.next();
                if(element.isOccupe() && element.getLocations().getId_prod() == id_prod){
                    this.places_restantes ++;
                    Locations v = element.Retirer();
                    this.notifier.notify("RETRAIT ", "\t LA LAOCATION : "+v.getId_prod()+"A ETE RETIRE A LA STATION : "+this.id_station);
                    return v  ;
                 }
            }
            throw new IdNotFound();
        }else{
            throw new StationVide(); 
        }
    }

    public boolean StationVide (){
        boolean assertion = true ;
        for( Emplacement e : this.places){
            assertion = assertion && ( e.isOccupe() == false);
        };
        return assertion ;
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

    public void DeposerLot ( List<Locations> l) throws Exception{
        for( int i = 0 ; i< l.size() && ! isStationPleine()  ; i++ ){
            Locations element = l.get(i);
            this.Deposer(element);
        }
    }

    public boolean isStationPleine(){
        return this.places_restantes == 0 ;
    }
    public List<Locations> RetirerLot( List<Locations> l) throws Exception{
        List<Locations> list = new ArrayList<Locations>();
        for( int i = 0 ; i< l.size() ; i++ ){
            Locations element = l.get(i);
            list.add(this.Retirer(element.getId_prod()));
        }
        return list ; 
       
    }

    public int getPlaces_restantes() {
        return places_restantes;
    }

    public List<Emplacement> getPlaces() {
        return this.places;
    }

    public int getId_station() {
        return id_station;
    }


    public boolean ContainsLocations( Locations v){
        boolean assertion  = false ; 
        for( Emplacement e : this.places){
            if( e.getLocations() != null && e.getLocations().equals(v)){
                assertion = true ;
            }
        }
        return assertion ; 
    }
    
    
    public void Louer(Client c) throws Exception{
        if(! this.StationVide()){
            for( Emplacement e : this.places){
                if( e.isOccupe() && !e.getLocations().isHors_service()){
                    Locations s = e.Retirer();
                    c.Louer(s);
                    this.places_restantes++ ;
                    this.notifier.notify("LOCATION" , "LE VELO: "+s.getId_prod() +" VIENT D'ETRES LOUE au Client : [ Nom = "+c.getNom()+"] - [ Prenom ="+c.getPrenom()+"]");
                }
            }

        }else{
            throw new StationVide();
        }
    }


   

    
    
}
