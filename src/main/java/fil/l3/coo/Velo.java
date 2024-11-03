package fil.l3.coo;
public class Velo extends DeuxRoues {
    public Velo ( float prix_location , Boolean hors_service , float caution ){
        super();
        this.prix_location = prix_location ;
        this.hors_service = hors_service ; 
        this.caution = caution ;    
        this.louee = false ;
    }

    @Override
    public void Louer(){
        this.nb_location++;
        this.louee = true ;
    }




}
