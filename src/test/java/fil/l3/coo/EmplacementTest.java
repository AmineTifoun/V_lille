package fil.l3.coo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmplacementTest {
    private Emplacement s = new Emplacement();
    private Locations v = new Velo(400, false, 700);
        @Test
    void testGetID(){
        Emplacement e = new Emplacement();
        Emplacement e1 = new Emplacement();
        assertEquals(e.getID()+1, e1.getID());
    }

    @Test
    void RetirerOk() throws Exception {
        s.Deposer(v);
        Locations e = s.Retirer();
        assertEquals(v, e);
        assertFalse(s.isOccupe());
        
    }


    @Test
    void DeposerOk()throws Exception {
        s.Deposer(v);
        assertEquals(s.getLocations(),v );
        assertTrue(s.isOccupe());
    }


    
}
