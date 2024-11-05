package fil.l3.coo.NotificationController;

import fil.l3.coo.AccesController.AccesForReparation;

public interface Subscriber {
    void update(String s);
    public void askForIntervention(AccesForReparation i)throws Exception ;

}
