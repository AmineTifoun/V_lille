import java.util.*;

public class V_lille { /* SINGLOTENT  */
    private static V_lille unique_agence = null; 
    Set<Station> stations ;
    private static int periode = 48; /* periode de 48h */
    Set <Intervention> personnel ;
    Set <Client> Clients ;


    private V_lille (){ 
        this.stations = new TreeSet<Station>();
        this.Intervention = new TreeSet<Intervention>();
        this.Clients = new TreeSet<Client>();
    }


    public static V_lille getInstance(){
        if( unique_agence == null){
            unique_agence = new  V_lille();
        }
        return unique_agence ;
    }
}
