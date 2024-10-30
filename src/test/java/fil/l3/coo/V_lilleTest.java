package fil.l3.coo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fil.l3.coo.ExceptionsControlled.NotPlacesAvailable;

public class V_lilleTest {
    private V_lille v = V_lille.getInstance();
    @Test
    void testOfUnicity(){
        V_lille v1 = V_lille.getInstance();
        V_lille v2 = V_lille.getInstance();
        assertEquals(v1, v2);
    }
    

    


    
}
