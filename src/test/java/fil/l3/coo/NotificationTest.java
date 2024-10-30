package fil.l3.coo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ExceptionUtils;

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

    
}
