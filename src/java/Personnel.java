
public abstract class Personnel implements Intervention {
    protected int ID_personnel ; 
    protected String nom ; 
    protected String prenom ; 
    protected static int ID_actual =0;

    public Personnel( String Nom  , String Prenom){
            this.ID_personnel = ID_actual;
            this.nom = Nom ; 
            this.prenom = Prenom ;
            Inc_idactual();
    }

    private static void Inc_idactual(){
        ID_actual++;
    }

    abstract void Interagir( Locations v) ;
}
