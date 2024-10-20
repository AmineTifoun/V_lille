package fil.l3.coo;
public class Accessoire /*implements Locations*/  {
    private Locations  v ; 

    Accessoire(Locations v){
        this.v = v  ;
    }


  
    public void Louer(){
        this.v.Louer();
    }

    
}
