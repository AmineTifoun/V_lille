package fil.l3.coo.StateController.DeuxRoueState;

import fil.l3.coo.DeuxRoues;

public interface DeuxRoueState {
    public void Louer(DeuxRoues s) throws Exception ;
    public DeuxRoues Retirer(DeuxRoues s) throws Exception ;
}