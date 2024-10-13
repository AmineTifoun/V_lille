public class Velo extends DeuxRoues {
    public Velo ( float prix_location , Boolean hors_service , int nb_location ){
        super();
        this.prix_location = prix_location ;
        this.hors_service = hors_service ; 
        this.nb_location = nb_location ;
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

    @Override
    public Boolean estVole(){
        if(1==1){
            return true ;
        }
        return false ;
    }
}
