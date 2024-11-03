package fil.l3.coo;

public class main {
    public static void main(String[] args) {
        V_lille v = V_lille.getInstance();
        Velo Velo = new Velo(10, false, 100);
        for( int i =0 ; i< 7 ; i++){
            Velo.Louer();
            System.out.println("1");
        }
        try{
        Velo.askForIntervention();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
    