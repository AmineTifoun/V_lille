package fil.l3.coo.RedistiributionStrategies;

import java.util.*;
import fil.l3.coo.Locations;
import fil.l3.coo.Station;
import fil.l3.coo.ExceptionsControlled.StationVide;

public class HALF_RATIO_REDISTRIBUTION implements REDISTRIBUTION_STRATEGY {
    private double ratio ;/* GENERALEMENT MIS A 50% */


    public HALF_RATIO_REDISTRIBUTION(double Ratio){
        this.ratio = Ratio ;
    }


    @Override
    public void REDISTRIBUTION(List<Station> source , List<Station> dest) throws Exception {
        this.REDISTRIBUTION_METHODE_CLASSIQUE(source, dest);
    }





    public List<Station> redistribution_ratio(Station source, List<Station> dest) throws Exception {
        Iterator<Station> vide = dest.iterator();
        double rapport = (double) source.getPlaces_restantes() / source.getNb_palces(); 
        System.out.println("rapport ="+rapport);
        if (!vide.hasNext()) {
            throw new StationVide();
        }
        Station e = vide.next();
        double taux_vide = (double)(e.getPlaces_restantes()/e.getNb_palces());
        System.out.println("rapport a ne pas depasser est :" + this.ratio);
        while (!source.StationVide() && (rapport < this.ratio)) {
            System.out.println("rapport ="+rapport);
            System.out.println("etat station : "+source.StationVide());
            Locations m = source.Retirer();
            System.out.println("taux de remplissage de la vide :"+(taux_vide));
            if (((taux_vide)<= this.ratio)) {/* On rempli jusqu'a 50% */
                if (vide.hasNext()) {
                    e = vide.next();
                } else {
                    source.Deposer(m);
                    break;
                }
            }
            
            // Déposer le vélo dans la station actuelle
            e.Deposer(m);
    
            // Recalculer le rapport pour voir si la condition est toujours satisfaite
            rapport = (double) source.getPlaces_restantes() / source.getNb_palces();
            taux_vide = (double) e.getPlaces_restantes() / e.getNb_palces();
        }
        return dest.subList(dest.indexOf(e), dest.size());            
    }
    




    public void REDISTRIBUTION_METHODE_CLASSIQUE(List<Station> remplies , List<Station> vide ) throws Exception{
        
        if( remplies != null && vide != null){
            List<Station> Pleines = remplies;
            List<Station> Vides = vide;
            for ( Station v : Pleines){
                Vides = redistribution_ratio(v, Vides);
                System.out.println(Vides);
                if( Vides == null){
                    break ;
                }
            }
        }
    }   
    
}
