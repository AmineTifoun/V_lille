package fil.l3.coo;
import java.util.*;

public class V_lille implements Subscriber { /* SINGLOTENT  */
    private List<String> notifications  ;
    private static V_lille unique_agence = null; 
    private static int periode = 48; /* periode de 48h */
    private List <Intervention> personnel ;
    private List <Client> Clients ;
    private List <Station> Stations ; 


    private V_lille (){ 
        this.personnel = new ArrayList<Intervention>();
        this.Clients = new ArrayList<Client>();
        this.notifications = new ArrayList<String>();
        this.Stations = new ArrayList<Station>();
        /*initStation();*/
        Stations.add(new Station(4));
    }

   public static V_lille getInstance(){
        if( unique_agence == null){
            unique_agence = new  V_lille();
        }
        return unique_agence ;
    }


    public void update(String s){
        this.notifications.add(s);
    }

    public List<String> getNotifications(){
        return this.notifications ;
    }

    /*public V_lille(String s){}
    /************************* */

    public void AddIntervention(Intervention i){
        this.personnel.add(i);
    }

    public void initStation(){
        /*Random rand = new Random();*/ 
        /*int nb_stations = rand.nextInt(50)+10;*/
        List<Station> liste = new ArrayList<>(); 
        for( int i =0  ; i< 10 ; i++){
            Station s = new Station(17);
            this.addStation(s);
        }
        
    }


    public void addStation(Station s){
        this.Stations.add(s);
    }
}
