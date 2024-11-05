package fil.l3.coo;

import java.util.ArrayList;
import java.util.*;

public class main {
    public static void main(String[] args) {
        V_lille v = V_lille.getInstance();
        Station qs = new Station(10);
        for(int o = 0 ; o< 10 ; o++){
            try{
            qs.Deposer(new Velo(10,false,100));
            }catch(Exception e){

            }
        }
        Station vide = new Station(10);
        if(! vide.StationVide()){
            System.out.println(vide);
        }
        List<Station> li = new ArrayList<Station>();
        li.add(vide);
        try{
        List<Station> q = new ArrayList<>();
        List<Station> q1 = new ArrayList<>();
        q.add(qs); q1.add(vide);
        v.REDISTRIBUTION_METHODE_CLASSIQUE(q, q1);
        System.out.println(qs.getPlaces_restantes());
        }catch(Exception e){}
    }
}
    