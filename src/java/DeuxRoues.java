public abstract class DeuxRoues implements Location {
    protected int Id_prod ; 
    protected float prix_location;
    protected int nb_location ; 
    protected Boolean hors_service ;
    private static int  locations_created = 0 ;

    public DeuxRoues(){
        this.Id_prod = locations_created ;
        IncrementeLocationId();
    }

    private static IncrementeLocationId(){
        locations_created++;
    }

    @Override
    public void Louer(Client C){
        /* The body must be filled */
    }


    @Override
    public Boolean estVole(){
        if(1==1){
            return true ;
        }
        return false ;
    }

    @Override
    public float getPrixLocation(){
        return this.prix_location;
    }

    @Override
    public Boolean getEtatService(){
        return this.hors_service;
    }

    @Override
    public int get_NbLocation(){
        return nb_location;
    }

    @Override
    public void set_NbLocation( int nb ){
        this.nb_location = nb ;
    }


    @Override
    public void ChangeStateService(){
        this.hors_service = !this.hors_service ;
    }




}
