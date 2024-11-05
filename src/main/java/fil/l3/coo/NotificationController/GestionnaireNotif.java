package fil.l3.coo.NotificationController;

import fil.l3.coo.V_lille;
import fil.l3.coo.AccesController.AccesForReparation;

public class GestionnaireNotif {
    /* L'abonnée a cette notification est V Lille mais suite a un probleme de recusrion interminable j'ai du appelé getInstance dans la metode notifiy */

    public void notify( String event  , String content  ){
        V_lille.getInstance().update("Un evenement de :"+event+" a été declanché . \t [ Voir Contenu ] \n "+ content);
    }

    public void call_for_intervention(AccesForReparation i) throws Exception{
        V_lille.getInstance().askForIntervention(i);
    }
    
}
