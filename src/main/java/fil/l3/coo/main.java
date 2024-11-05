package fil.l3.coo;

import java.util.ArrayList;
import java.util.*;

public class main {
    public static void main(String[] args) {
        V_lille v = V_lille.getInstance();
        Station qs = new Station(0);
        for(int o = 0 ; o< 10 ; o++){
            try{
            System.out.println(o);
            qs.Deposer(new Velo(10,false,100));
            }catch(Exception e){
                e.printStackTrace();;
            }
       
    }
    }}
    