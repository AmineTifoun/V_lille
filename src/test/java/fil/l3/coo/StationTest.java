package fil.l3.coo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fil.l3.coo.ExceptionsControlled.IdNotFound;
import fil.l3.coo.ExceptionsControlled.NotPlacesAvailable;
import fil.l3.coo.ExceptionsControlled.StationVide;

public class StationTest {
    private static final int  Nb_place_notOk =0 ;
    private static final int  Nb_place_Ok =10 ;
    private MockVelo v = new MockVelo(false, Nb_place_notOk, Nb_place_Ok) ; 

    @Test  
    public void TestAjoutOK() throws Exception{
        Station s = new Station(Nb_place_Ok);
        s.Deposer(v);
        assertEquals(s.getPlaces_restantes(), Nb_place_Ok-1);
        assertTrue(s.getPlaces().contains(v));
    }


    @Test
    public void TestAJOUTNotOK(){
        Station s = new Station(Nb_place_notOk);  
        assertThrows(NotPlacesAvailable.class,()->{
            s.Deposer(v); 
        });
        assertEquals(s.getPlaces_restantes(),Nb_place_notOk);
        assertFalse(s.getPlaces().contains(v));
    }


    @Test 
    void RetiterOk()throws Exception{
        Station s = new Station(Nb_place_Ok);
        int nb_place_before = s.getPlaces_restantes();
        s.Deposer(v);
        Locations l  = s.Retirer(v.getId_prod());
        assertEquals(nb_place_before, s.getPlaces_restantes());
        assertFalse(s.getPlaces().contains(l));
    }

    @Test
    void RetirerNotOK(){
        Station s = new Station(Nb_place_Ok);
        assertThrows(StationVide.class, ()->{
            s.Retirer(145);
        });
        assertThrows(IdNotFound.class, ()->{
            s.Deposer(v);
            s.Retirer(v.getId_prod()+1);
        });
    }



    
}
    