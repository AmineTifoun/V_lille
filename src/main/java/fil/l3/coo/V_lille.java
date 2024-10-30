package fil.l3.coo;
import java.util.*;

import fil.l3.coo.ExceptionsControlled.StationVide;

public class V_lille implements Subscriber { /* SINGLOTENT  */
    private List<String> notifications  ;
    private static V_lille unique_agence = new V_lille(); 
    private static int periode = 48; /* periode de 48h */
    private List <Intervention> personnel ;
    private List <Client> Clients ;
    private List <Station> Stations ; 
    private List <Locations> vehicules ; 


    private V_lille () { 
        this.personnel = new ArrayList<Intervention>();
        this.Clients = new ArrayList<Client>();
        this.notifications = new ArrayList<String>();
        this.Stations = new ArrayList<Station>();
        this.vehicules = new ArrayList<Locations> ();
        initStation();
        initVelo(); 
        try{
            Distribution();
        } catch(Exception e){
            e.printStackTrace();
        }
    }



   public static V_lille getInstance(){
        return unique_agence ;
    }


    public void update(String s){
        this.notifications.add(s);
    }

    public List<String> getNotifications(){
        return this.notifications ;
    }

    /* public V_lille(String s){} */
    /* ************************** */

    public void AddIntervention(Intervention i){
        this.personnel.add(i);
    }

    public void initStation(){
        Random rand = new Random();
        int nb_stations = rand.nextInt(50)+10;
        List<Station> liste = new ArrayList<>(); 
        for( int i =0  ; i< nb_stations ; i++){
            Station s = new Station(17);
            this.addStation(s);
        }
        
    }

    public void initVelo(){
        Random rand = new Random();
        int nb_velo = rand.nextInt(50)+10;
        for( int i = 0 ; i < nb_velo ; i++){
            this.vehicules.add(new Velo(10 , false , 100));
        }
    }


    public void addStation(Station s){
        this.Stations.add(s);
    }


    public void Distribution() throws Exception{ /* Distribution de tous les velos sur les n stations */
        Iterator<Station> s =this.Stations.iterator();
        Station e = s.next() ;        
        for(Locations v : this.vehicules){
                e.Deposer(v);
                if( s.hasNext() && e.isStationPleine() ){
                    e = s.next();
                }
            
        }
    }

    public void redistribution( Station source  , List<Station> dest) throws Exception{/* Distribue les velo d'une source vers des stations destinataires */
        Iterator<Station> vide = dest.iterator();
        if( vide.hasNext()){
            Station e = vide.next();
            while( ! source.StationVide()){
                Locations m = source.Retirer();
                if(e.isStationPleine()){
                    if( vide.hasNext()){
                        e = vide.next();
                        e.Deposer(m);
                    }else{
                        source.Deposer(m);
                        break ;
                    }
                }else{
                    e.Deposer(m);
                }
            }
        }
    }

    public List<Station> getStations() {
        return Stations;
    }
    
}
