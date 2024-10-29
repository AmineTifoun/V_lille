package fil.l3.coo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class V_lilleTest {
    @Test
    void testOfUnicity(){
        V_lille v1 = V_lille.getInstance();
        V_lille v2 = V_lille.getInstance();
        assertEquals(v1, v2);
    }
    


    
}
