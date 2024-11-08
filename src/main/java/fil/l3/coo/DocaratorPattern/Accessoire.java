package fil.l3.coo.DocaratorPattern;

import fil.l3.coo.Locations;

public class Accessoire /*implements Locations*/  {
    private Locations  v ; 

    Accessoire(Locations v){
        this.v = v  ;
    }


  
    public void Louer() throws Exception{
        this.v.Louer();
    }

    
}
