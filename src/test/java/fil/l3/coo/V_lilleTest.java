package fil.l3.coo;
import java.util.* ;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class V_lilleTest {
    private V_lille v = V_lille.getInstance();
    @Test
    void testOfUnicity(){
        V_lille v1 = V_lille.getInstance();
        V_lille v2 = V_lille.getInstance();
        assertEquals(v1, v2);
    }

    @Test 
     void TestMethodeDistribution()throws Exception{
        /* La methode Distribution est appelé dans le const de V_Lille */
        assertTrue(isLoaded());
     }

     /* Methode à utiliser dans le test */
     public boolean isLoaded(){
        List<Station> s = v.getStations();
        boolean loaded = false ;
        for( Station e : s){
            loaded = loaded ||(!e.StationVide()); 
        }
        return loaded ;
     }
     /************************************** */


    @Test
    void testRedistribution()throws Exception{
        List<Station> vide = new ArrayList<Station>();
        vide.add(new Station(1)) ;
        Station source = v.getStations().get(0);
        int nb_place_restance = source.getPlaces_restantes();
        v.redistribution(source, vide);
        assertTrue(vide.get(0).isStationPleine());
        assertEquals(nb_place_restance+1, source.getPlaces_restantes());
    }

}
