package fil.l3.coo.ExceptionsControlled;
public class NotInService extends Exception {
    public NotInService(int id){
        super("The Device with ID ="+id+" is not in service .");
    }
}
