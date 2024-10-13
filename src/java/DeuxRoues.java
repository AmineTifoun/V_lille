public abstract class DeuxRoues {
    protected int Id_prod ; 
    protected float prix_location;
    protected inr nb_location ; 
    protected Boolean hors_service ;
    private static int  locations_created = 0 ;

    public DeuxRoues(){
        this.Id_prod = locations_created ;
        IncrementeLocationId();
    }

    private static IncrementeLocationId(){
        locations_created++;
    }
}
