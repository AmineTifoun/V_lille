package fil.l3.coo;
import fil.l3.coo.AccesController.AccesProvidertoStation;
import fil.l3.coo.ExceptionsControlled.NotEnoughMoneyException;
import fil.l3.coo.ExceptionsControlled.NotInService;
import java.time.LocalDateTime;
import java.time.Duration;



public class Client {
    private int ID_client = 0 ; 
    private String Nom ; 
    private String Prenom ;
    private Locations vehicule ;
    private float money ;
    private LocalDateTime debut   ;
    private LocalDateTime fin ; 
    private static int actual_id = 0 ;

    public Client ( String Nom , String Prenom , float money ){
        this.ID_client = actual_id+1 ;
        this.Nom=Nom;
        this.Prenom = Prenom ;
        this.money = money ;
        incrementNbInstance();
    }

    private static void incrementNbInstance(){
        actual_id++;
    }

    public void Louer( Locations v) throws Exception {
        if( !v.getEtatService()){
            if( this.money < v.getCaution()){
                throw new NotEnoughMoneyException(ID_client);
            }else{
                this.money = this.money - v.getCaution();
                this.vehicule = v ; 
                this.debut = LocalDateTime.now() ;
                this.vehicule.Louer();
            }

        }else{
            throw new NotInService(v.getIdDeuxRoues());
        }
    }

    
    public void DeposerLocationDansStation(AccesProvidertoStation s )throws Exception{
        this.fin = LocalDateTime.now();
        long time = this.getDuration(); 
        this.Debiter(time);
        s.Deposer(vehicule);
        this.vehicule = null ;
    }


    public Long getDuration(){
        Duration duration = Duration.between(debut, fin);
        return duration.toMinutes();
    }

    public void Debiter(long time){
        float adebiter = time * this.vehicule.getPrixLocation();
        this.money = this.money-adebiter+this.vehicule.getCaution();
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public static int getActual_id() {
        return actual_id;
    }

    public int getID_client() {
        return ID_client;
    }

    public void setID_client(int iD_client) {
        ID_client = iD_client;
    }

    public Locations getVehicule() {
        return vehicule;
    }

    public void setVehicule(Locations vehicule) {
        this.vehicule = vehicule;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    
}
