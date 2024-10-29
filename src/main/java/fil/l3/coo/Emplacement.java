package fil.l3.coo ;

import fil.l3.coo.ExceptionsControlled.PlacementProbleme;

public class Emplacement implements Comparable<Emplacement> {
    private Locations v  ; 
    private boolean occupe ; 

    public Emplacement(){
        this.occupe = false ; 
        this.v = null;
    }


    @Override
    public int compareTo(Emplacement other) {
        return Integer.compare(System.identityHashCode(this), System.identityHashCode(other));
    }    

    public void Deposer(Locations v) throws Exception{
        if(! this.occupe){
            this.v = v;
            this.occupe = true ;

        }else{
            throw new PlacementProbleme();
        }
    }


    public Locations Retirer() throws Exception{
        if(this.occupe){
            Locations e = this.v ;
            this.v = null;
            this.occupe = false ;
            return e ;
        }else{
            throw new PlacementProbleme();
        }
    }



    public boolean isOccupe(){
        return this.occupe ;
        }

    public Locations getLocations(){
        return this.v ;
    }

    
}
