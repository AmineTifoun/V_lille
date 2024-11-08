package fil.l3.coo.StateController.DeuxRoueState;

import fil.l3.coo.DeuxRoues;
import fil.l3.coo.ExceptionsControlled.NotInService;

public class HorsService implements DeuxRoueState{
    
    @Override
    public void Louer(DeuxRoues s) throws Exception{
        throw new NotInService(s.getIdDeuxRoues()); 
    }

    @Override
    public DeuxRoues Retirer(DeuxRoues s) throws Exception{
        throw new NotInService(s.getIdDeuxRoues()); 
    }
}
