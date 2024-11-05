package fil.l3.coo.StateController.StationState;

import java.util.List;

import fil.l3.coo.*;

public interface StationState {
    public void Deposer( Locations l , Station s) throws Exception ; 
    public Locations Retirer(Station s) throws Exception ;
    public List<Emplacement> placesAvailbale() ;
    public void Louer(Client c , Station s) throws Exception;
    public Locations Retirer(int id_prod , Station s) throws Exception ;

}
