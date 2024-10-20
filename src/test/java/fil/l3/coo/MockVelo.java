package fil.l3.coo ;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




public class MockVelo extends Velo{
    private boolean etat ;
    public MockVelo(boolean etat , float prix_location , float caution){
        super(prix_location , false , caution);
        this.etat = etat ;

    }

    @Override
    public boolean getEtatService(){
        return etat ; 
    }
}
