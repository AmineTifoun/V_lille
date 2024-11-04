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
        System.out.println(qs.getPlaces_restantes());
        Station vide = new Station(1);
        if(! vide.StationVide()){
            System.out.println(vide);
        }
        List<Station> li = new ArrayList<Station>();
        li.add(vide);
        try{
        v.redistribution(qs,li);
        }catch(Exception e){}
        System.out.println(qs.getPlaces_restantes());
    }
}
    