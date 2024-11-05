package fil.l3.coo;
import java.util.* ;

import fil.l3.coo.AccesController.AccesProvidertoStation;
import fil.l3.coo.ExceptionsControlled.*;
import fil.l3.coo.NotificationController.GestionnaireNotif;
import fil.l3.coo.StateController.StationState.StationState;
import fil.l3.coo.StateController.StationState.Station_Vide;


public class Station implements AccesProvidertoStation{
    private int id_station ;
    private StationState state;
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
        this.state = new Station_Vide(places);
        Incremente_ID();
       }

    static void Incremente_ID(){
        current_id ++ ; 
    }


    @Override
    public void Deposer( Locations l) throws Exception{
            this.state.Deposer(l , this);

    }

    public void SetState( StationState l){
        this.state = l ;
    }

    
    public GestionnaireNotif getNotifier() {
        return notifier;
    }


    public void setPlaces_restantes(int places_restantes) {
        this.places_restantes = places_restantes;
    }

    public int getNb_palces() {
        return nb_palces;
    }

    public static int getCurrent_id() {
        return current_id;
    }



    public Locations Retirer() throws Exception{
            return state.Retirer(this);
    }

    public boolean StationVide (){
        boolean assertion = true ;
        for( Emplacement e : this.places){
            assertion = assertion && ( e.isOccupe() == false);
        };
        return assertion ;
    }

    public List<Emplacement> placesAvailbale(){
        return state.placesAvailbale();
    }

 

    public boolean isStationPleine(){
        return this.places_restantes == 0 ;
    }
    
    public int getPlaces_restantes() {
        return places_restantes;
    }

    public StationState getState() {
        return state;
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
            state.Louer(c, this);
    }
    

  public Locations Retirer ( int id_prod) throws Exception{
            return state.Retirer(id_prod, this);
    }
    /* 
           public void DeposerLot ( List<Locations> l) throws Exception{
        for( int i = 0 ; i< l.size() && ! isStationPleine()  ; i++ ){
            Locations element = l.get(i);
            this.Deposer(element);
        }
    } */

    
    
}
