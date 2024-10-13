public class Client {
    private int ID_client = 0 ; 
    private String Nom ; 
    private String Prenom ;
    private Locations vehicule ;
    private static int actual_id = 0 ;

    public Client ( String Nom , String Prenom){
        this.ID_client = actual_id+1 ;
        this.Nom=Nom;
        this.Prenom = Prenom ;
        incrementNbInstance();
    }

    private static void incrementNbInstance(){
        actual_id++;
    }

    public void Louer( Locations v){
        this.vehicule = v ; 
        this.vehicule.Louer();
    }
    
}
