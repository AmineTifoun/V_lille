package fil.l3.coo ;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fil.l3.coo.ExceptionsControlled.NotEnoughMoneyException;
import fil.l3.coo.ExceptionsControlled.NotInService;



public class ClientTest {
    @Test
    public void testLouerOK(){
        Client c = new Client ( "Tifoun" ,  "Mohamed" , 10000 );
        Velo v = new Velo ( 5 , false  , 200 );
        try{
            int nb_location = v.get_NbLocation();
            c.Louer(v);
            assertEquals(9800,(short) c.getMoney() );
            assertEquals(1 , v.get_NbLocation()- nb_location );
            assertEquals(c.getVehicule(), v);
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
    

    @Test
    public void DepotTest() throws Exception{
        Locations l = new Velo(10 , false , 100);
        Client c = new MockClient(400);
        c.Louer(l);/* ALREADY TESTED */
        assertEquals(300, c.getMoney());
        Station s = new Station(1);
        Thread.sleep(60000); // 1 minutes in milliseconds
        c.DeposerLocationDansStation(s);
        assertEquals(390,c.getMoney());
        assertEquals(null, c.getVehicule());

    }

}