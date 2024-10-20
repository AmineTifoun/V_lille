package fil.l3.coo.ExceptionsControlled;
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException (int id_client){
        super("The Client :"+id_client+"does not have enough sold !");
    }
}
