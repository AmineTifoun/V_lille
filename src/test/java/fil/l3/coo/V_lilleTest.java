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
        DistributeVeloInStation();
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


     public void DistributeVeloInStation()throws Exception{
        if( ! v.isInitialized()){
            v.Distribution();
        }
     }


    @Test
    void testRedistribution()throws Exception{
        DistributeVeloInStation();
        List<Station> vide = new ArrayList<Station>();
        vide.add(new Station(1)) ;
        Station source = v.getStations().get(0);
        System.out.println("nb place restante :"+source.getPlaces_restantes());
        int nb_place_restance = source.getPlaces_restantes();
        v.redistribution(source, vide);/*Methode to test */
        System.out.println("nb place restante :"+source.getPlaces_restantes());
        assertEquals(nb_place_restance+1, source.getPlaces_restantes());
        assertFalse(vide.get(0).StationVide());
    }


    @Test 
    void testNeedToRestribute()throws Exception {
        DistributeVeloInStation();
        List<List<Station>> s = v.NeedToDistribute(2);
        assertTrue(s.size()==2);
        for( int i = 0 ; i< s.size() ; i++ ){
            Iterator<Station> s1 = s.get(i).iterator() ;
            while(s1.hasNext()){
                Station e = s1.next();
                if( i == 0){
                    assertTrue(e.isStationPleine());
                }
                if( i == 1 ){
                    assertTrue(e.StationVide());
                }
            }
        }
    }

    @Test
    void TestREDISTRIBUTION_METHODE_CLASSIQUE()throws Exception{
        DistributeVeloInStation();
        v.REDISTRIBUTION_METHODE_CLASSIQUE();   
        assertTrue(AllNotEmpty());
    }
    
    /* Methode de test pour TestREDISTRIBUTION_METHODE_CLASSIQUE */
    private boolean AllNotEmpty(){
        boolean a = true ;
        for( Station e : v.getStations()){
            a = a && (!e.StationVide());
        }
        return a ;
    }

 
}
