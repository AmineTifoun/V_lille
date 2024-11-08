package fil.l3.coo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {
    private V_lille v =V_lille.getInstance();
    private Locations velo = new MockVelo(false, 10, 100);
    private Station s = new Station(15);

    @Test
    void testNotifDepot() throws Exception {
        int size = v.getNotifications().size();
        s.Deposer(velo);
        // Vérifie la notification après dépôt
        assertEquals(size+1, v.getNotifications().size());
    }

    @Test
    void testNotifRetrait() throws Exception{
        s.Deposer(velo);
        int size = v.getNotifications().size();
        s.Retirer(velo.getId_prod());
        assertEquals(size+1, v.getNotifications().size());
    }
    

    @Test 
    void testNotifLouer() throws Exception{
        s.Deposer(velo);
        int size = v.getNotifications().size();
        Client c = new MockClient(400);
        s.Louer(c);
        assertEquals(size+1, v.getNotifications().size());

    }


    /*@Test
    void TestAskForREDISTRIBUTION() throws Exception{
        this.DistributeVeloInStation();
        int taille = this.v.getNotifications().size();
        /*this.v.REDISTRIBUTION(null, null);();*/
        /*assertTrue(taille< this.v.getNotifications().size());
    }*/

    private void DistributeVeloInStation()throws Exception{
        if( !v.isInitialized()){
            v.Distribution();
        }
        
     }

    
    @Test
    public void testerLaDemandeDinterventionDeuxRoues() throws Exception{
        /* Apres un certain nombre de locations, le velo devient hors service !! donc une demande d'intervention est faite  */
        for ( int i =0 ; i<=6  ; i++){
            this.velo.Louer();
            this.velo.askForIntervention();
        }
        assertEquals(this.v.popNotification(), "The Product with [ id = "+ velo.getId_prod()+"] is Seeking for Intervention IMMEDIALTLY !");
    }
    
}
