package fil.l3.coo;
import fil.l3.coo.ExceptionsControlled.NotEnoughMoneyException;
import fil.l3.coo.ExceptionsControlled.NotInService;

public class Client {
    private int ID_client = 0 ; 
    private String Nom ; 
    private String Prenom ;
    private Locations vehicule ;
    private float money ;
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
                this.vehicule.Louer();
            }

        }else{
            throw new NotInService(v.getIdDeuxRoues());
        }
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
