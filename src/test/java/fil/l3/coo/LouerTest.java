package fil.l3.coo ;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fil.l3.coo.ExceptionsControlled.NotEnoughMoneyException;
import fil.l3.coo.ExceptionsControlled.NotInService;



public class LouerTest {
    @Test
    public void testLouerOK(){
        Client c = new Client ( "Tifoun" ,  "Mohamed" , 10000 );
        Velo v = new Velo ( 5 , false  , 200 );
        try{
            int nb_location = v.get_NbLocation();
            c.Louer(v);
            assertEquals(9800,(short) c.getMoney() );
            assertEquals(1 , v.get_NbLocation()- nb_location );
        }catch( Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLouerBikeNotAvailable(){
        Client c = new Client ( "Tifoun" ,  "Mohamed" , 10000 );
        Velo v = new MockVelo(true , 50 , 500);
        assertThrows(NotInService.class, ()->{
            c.Louer(v);
        });
    }

    @Test
    public void testLouerNotEnoughMoney(){
        Client c = new MockClient(0);
        Velo v = new MockVelo(false, 10, 500) ; 
        assertThrows(NotEnoughMoneyException.class, ()->{
            c.Louer(v);
        });
    }
    
}