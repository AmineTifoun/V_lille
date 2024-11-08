package fil.l3.coo;
public class Reparateur extends Personnel{
    public Reparateur(String Nom , String Prenom){
        super(Nom , Prenom);
    }

    public void Interagir(int periode_of_intervention) throws Exception{
        this.Reparer(periode_of_intervention);
    }

    public void Reparer(int periode)throws Exception{
        System.out.println("\t \t ************ REPARATION EN COURS ******** \t \t ");
        Thread.sleep(periode*60000);/*  simulation */
    }
    
}
