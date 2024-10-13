
public abstract class Personnel implements Intervention {
    private int ID_personnel ; 
    private String nom ; 
    private String prenom ; 
    private static int ID_actual =0;

    public Personnel( String Nom  , String Prenom){
            this.ID_personnel = ID_actual;
            this.nom = Nom ; 
            this.prenom = Prenom ;
    }

    public void Interagir( Locations v){

    }

    

}
