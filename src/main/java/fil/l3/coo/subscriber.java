package fil.l3.coo;

public interface Subscriber {
    void update(String s) ;
    void askForIntervention(AccesForReparation i ) throws Exception;
}
