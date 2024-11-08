package fil.l3.coo;
import fil.l3.coo.StateController.DeuxRoueState.*;
import fil.l3.coo.AccesController.AccesForReparation;
import fil.l3.coo.AccesController.AccesProviderForLocations;
import fil.l3.coo.NotificationController.GestionnaireNotif;

public abstract class DeuxRoues implements Locations , AccesForReparation , AccesProviderForLocations  {
    protected int Id_prod ; 
    protected float caution ; 
    protected float prix_location;
    protected int nb_location =0; 
    protected boolean hors_service ;
    protected GestionnaireNotif notifier ;
    protected boolean louee ;
    protected DeuxRoueState state ;  
    protected boolean depose ;
    protected final int limite_location = 5 ; 
    private static int  locations_created = 0 ;

    public DeuxRoues(){
        this.Id_prod = locations_created ;
        this.depose = false ; 
        this.louee = false ; 
        this.notifier = new GestionnaireNotif(); 
        IncrementeLocationId();
    }

    private static void IncrementeLocationId(){
        locations_created++;
    }


    @Override
    public int compareTo( Locations l){
        return this.Id_prod - l.getId_prod();
    }
    @Override
    public int getId_prod() {
        return Id_prod;
    }


    
    @Override
    public void Louer() throws Exception{
        this.state.Louer(this);
    }

    public int getNb_location() {
        return nb_location;
    }

    public void setNb_location(int nb_location) {
        this.nb_location = nb_location;
    }

    public boolean isLouee() {
        return louee;
    }

    public void setLouee(boolean louee) {
        this.louee = louee;
    }

    @Override
    public Boolean estVole(){
        /*if(1==1){
            return true ;
        }*/
        return false ;
    }

    @Override
    public float getPrixLocation(){
        return this.prix_location;
    }

    @Override
    public boolean isDepose(){
        return this.depose ;
    }

    @Override
    public void setDeposer( boolean f){
        this.depose = f ;
    }
    @Override
    public boolean getEtatService(){
        return this.hors_service;
    }

    @Override
    public int  get_NbLocation(){
        return nb_location;
    }

    @Override
    public void set_NbLocation( int nb){
        this.nb_location = nb ;
    }

    @Override
    public void ChangeStateService(){
        this.hors_service = !this.hors_service ;
    }

    @Override
    public void setEtatSerice(){
        this.ChangeStateService();
        if( this.hors_service){
            this.state = new HorsService();
            }
        else{
            this.state = new OnService();
        }
    }
    

    @Override
    public float getCaution (){
        return this.caution ;
    }

    protected GestionnaireNotif getNotifier(){
        return this.notifier ; 
    }

    public int getIdDeuxRoues(){
        return this.Id_prod ;
    }

    public boolean isHors_service() {
        return this.hors_service;
    }

    public void askForIntervention()throws Exception{
        if ( this.nb_location > this.limite_location){
            this.hors_service=true ; 
            this.state = new HorsService();
            this.notifier.call_for_intervention(this);
        }
    } 

    public Locations Retier() throws Exception{
        return this.state.Retirer(this) ;
    }
    


}
