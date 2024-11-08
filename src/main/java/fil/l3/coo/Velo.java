package fil.l3.coo;

import fil.l3.coo.StateController.DeuxRoueState.HorsService;
import fil.l3.coo.StateController.DeuxRoueState.OnService;

public class Velo extends DeuxRoues {
    public Velo ( float prix_location , Boolean hors_service , float caution ){
        super();
        this.prix_location = prix_location ;
        this.hors_service = hors_service ; 
        this.caution = caution ;
        if( this.hors_service){
            this.state = new HorsService();
        }else{
            this.state = new OnService();
        }    
    }

}
