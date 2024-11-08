package fil.l3.coo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import fil.l3.coo.ExceptionsControlled.NotInService; 




public class DeuxRouesTest {
    @Test
    public void testRetirOk() throws Exception{
        Velo v = new Velo(10, false, 100);
        assertEquals(v, v.Retier());
    }

    @Test
    public void testRetirerNotOk() throws Exception{
        Velo v = new Velo(10, true, 100);
        assertThrows(NotInService.class, ()->{
            v.Retier() ;
        });

    }
    
}
