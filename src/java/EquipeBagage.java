public class EquipeBagage implements Locations {
    public EquipeBagage ( DeuxRoues v){
        this.v = v ;
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
