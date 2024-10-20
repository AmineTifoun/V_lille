package fil.l3.coo.ExceptionsControlled;
public class NotInService extends Exception {
    public NotInService(int id){
        super("The bike with ID ="+id+" is not available .");
    }
}
