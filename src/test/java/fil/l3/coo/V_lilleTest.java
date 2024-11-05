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
    void testRedistributionOK()throws Exception{
        DistributeVeloInStation();
        List<Station> vide = new ArrayList<Station>();
        vide.add(new Station(10)) ;//*List de station Vide */
        vide.add(new Station(10));
        Station source = new Station(10);
        for( int i =1 ; i<= 10 ; i++){
            System.out.println("nb place restante :"+source.getPlaces_restantes());
            source.Deposer(new Velo(10, false , 100));
        }
        int nb_place_restance = source.getPlaces_restantes();
        System.out.println("nb place restante :"+source.getPlaces_restantes());
        v.redistribution(source, vide);/*Methode to test */
        System.out.println("nb place restante :"+source.getPlaces_restantes());
        assertFalse(vide.get(0).StationVide());
        assertEquals(vide.get(0).getPlaces_restantes() , source.getPlaces_restantes());
        
    }

    /*Rajouter test NonOK de Redestribution */


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
        Station pleine = new Station(10);
        for( int i = 0 ; i <10 ; i++ ){
            System.out.println("nb place restante :"+pleine.getPlaces_restantes());
            pleine.Deposer(new Velo(10,false,100));
        }
        System.out.println(pleine.getPlaces_restantes());
        Station vide = new Station(10);
        List<Station> s = new ArrayList<Station>();
        s.add(pleine);
        List<Station> s1 = new ArrayList<Station>();
        s1.add(vide);
        v.REDISTRIBUTION_METHODE_CLASSIQUE(s , s1);  
        System.out.println(pleine.getPlaces_restantes()); 
        assertTrue(pleine.getPlaces_restantes() == vide.getPlaces_restantes());
    }
 
}
