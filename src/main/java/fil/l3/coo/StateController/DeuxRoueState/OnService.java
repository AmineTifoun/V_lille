package fil.l3.coo.StateController.DeuxRoueState;

import fil.l3.coo.DeuxRoues;

public class OnService implements DeuxRoueState {
    
    @Override
    public void Louer(DeuxRoues s) throws Exception{
        s.setNb_location(s.getNb_location()+1);
        s.setLouee(true); ; 
    }

    @Override
    public DeuxRoues Retirer(DeuxRoues s) throws Exception{
        return s ; 
    }
}
