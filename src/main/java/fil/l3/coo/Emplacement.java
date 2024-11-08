package fil.l3.coo ;

import fil.l3.coo.ExceptionsControlled.PlacementProbleme;

public class Emplacement implements Comparable<Emplacement> {
    private Locations v  ; 
    private boolean occupe ; 
    private  int ID  ;
    private static int incrementer = 0 ;
    

    public Emplacement(){
        this.occupe = false ; 
        this.v = null;
        this.ID = incrementer;
        incrementID();
    }

    static void incrementID(){
        incrementer++ ;
    }

    @Override
    public int compareTo(Emplacement other) {
        return Integer.compare(this.getID(), other.getID());
    }
    
    
    public int getID(){
        return this.ID ;
    }

    public void Deposer(Locations v) throws Exception{
        if(! this.occupe){
            this.v = v;
            this.v.setDeposer(true);
            this.occupe = true ;

        }else{
            throw new PlacementProbleme();
        }
    }


    public Locations Retirer() throws Exception{
        if(this.occupe){
            Locations e = this.v.Retier() ;
            e.setDeposer(false);
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
