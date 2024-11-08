package fil.l3.coo.AccesController;
import fil.l3.coo.Locations;

public interface AccesProviderForLocations {

   public int  getIdDeuxRoues();
   public float  getCaution();
   public boolean getEtatService();
   public void Louer() throws Exception;
   public Locations Retier() throws Exception;
   public float getPrixLocation();

    
}
