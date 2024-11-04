package fil.l3.coo;
import java.util.*;

import fil.l3.coo.ExceptionsControlled.StationVide;

public class V_lille implements Subscriber { /* SINGLOTENT  */
    private List<String> notifications  ;
    private static V_lille unique_agence = new V_lille(); 
    private final int periode = 1 ;/* 5 minutes */
    private List <Intervention> personnel ;
    private final double rapport = 0.5 ; /*Rapport de remplissage minimal dans une station remplie */
    private List <Client> Clients ;
    private boolean initialized = false ;
    private List <Station> Stations ; 
    private List <Locations> vehicules ; 

    private V_lille () { 
        this.personnel = new ArrayList<Intervention>();
        this.Clients = new ArrayList<Client>();
        this.notifications = new ArrayList<String>();
        this.Stations = new ArrayList<Station>();
        this.vehicules = new ArrayList<Locations> ();
        initStation();
        initVelo();
        initPersonnel();
    }



    public static V_lille getInstance(){
            return unique_agence ;
        }

    

    public void update(String s){
        this.notifications.add(s);
    }

    public List<String> getNotifications(){
        return this.notifications ;
    }


    public void AddIntervention(Intervention i){
        this.personnel.add(i);
    }

    public void initStation(){
        Random rand = new Random();
        int nb_stations = /*rand.nextInt(30)+5;*/10 ;
        List<Station> liste = new ArrayList<>(); 
        for( int i =0  ; i< nb_stations ; i++){
            Station s = new Station(/*rand.nextInt(11)+*/10);
            this.addStation(s);
        }
        
    }

    public void initVelo(){
        Random rand = new Random();
        int nb_velo = /*rand.nextInt(50)+100*/50;
        for( int i = 0 ; i < nb_velo ; i++){
            this.vehicules.add(new Velo(10 , false , 100));
        }
    }

    public void initPersonnel(){
        Random rand = new Random();
        int effectif = rand.nextInt(30) +5;
        for( int i = 0 ; i < effectif ; i++){
            Personnel p = new Reparateur("Amine", "Tifoun");
            this.personnel.add(p);
        }
    }

    public void addStation(Station s){
        this.Stations.add(s);
    }


    public boolean isInitialized() {
        return initialized;
    }



    public void Distribution() throws Exception{ /* Distribution de tous les velos sur les n stations */

        Iterator<Station> s =this.Stations.iterator();
        Station e = s.next() ;        
        for(Locations v : this.vehicules){
                e.Deposer(v);
                if( s.hasNext() && e.isStationPleine() ){
                    e = s.next();
                }
            
        }
        this.initialized = true ;
    }

    public List<Station> redistribution(Station source, List<Station> dest) throws Exception {
        Iterator<Station> vide = dest.iterator();
        
        double rapport = (double) source.getPlaces_restantes() / source.getNb_palces(); 
        
        if (!vide.hasNext()) {
            throw new StationVide();
        }
    
        Station e = vide.next();
    
        while (!source.StationVide() && (rapport < this.rapport)) {
            Locations m = source.Retirer();
    
            if (((e.getPlaces_restantes()/e.getNb_palces())<=0.5)) {/* On rempli jusqu'a 50% */
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
        }
        return dest.subList(dest.indexOf(e), dest.size());            
    }
    

    public List<Station> getStations() {
        return Stations;
    }


    public void REDISTRIBUTION_METHODE_CLASSIQUE() throws Exception{
        List<List<Station>> s = NeedToDistribute(2);/* Sort les stations au quel il faut intervenir pour redistribuer */
        if( s.size()== 2){
            List<Station> Pleines = s.get(0);
            List<Station> Vides = s.get(1);
            for ( Station v : Pleines){
                Vides = redistribution(v, Vides);
                if( Vides == null){
                    break ;
                }
            }
        }
    }   

    public  List<Station> StationARedistribuer(char etatStation){  /* p pour chercher les pleines et v pour chercher les vide */ 
        List<Station> s = new ArrayList<Station>();
       for( Station v : this.Stations){
            if( (etatStation =='p'&& v.isStationPleine()) || (etatStation =='v' && v.StationVide())){
                s.add(v);
            }
       }
       return s ; 
    } 


    public List<List<Station>> NeedToDistribute(int numberOfTime) throws Exception {/* POSITION 0 LES STATIONS PLEINES POSITION 1 LES STATIONS VIDES */
        List<List<Station>> s = new ArrayList<>();
        for (int i = 0; i < numberOfTime; i++) {
            Thread.sleep(this.periode * 60000); 
            s.add(new ArrayList<>(this.StationARedistribuer('p'))); 
            s.add(new ArrayList<>(this.StationARedistribuer('v')));
        }
        s.set(0, Intersection(s.get(0), s.get(2)));
        s.set(1, Intersection(s.get(1), s.get(3)));
        s.subList(2, s.size()).clear(); 
        return s;
    }
    
    private List<Station> Intersection(List<Station> s1, List<Station> s2) {
        List<Station> result = new ArrayList<>(s1);
        result.retainAll(s2);
        return result;
    }

    private Intervention popPersonnel(){
        return this.personnel.remove(this.personnel.size()-1);
    }


    public String popNotification(){
        return this.getNotifications().get(this.getNotifications().size()-1);
    }

    public void askForIntervention(AccesForReparation i)throws Exception{
        /* Logique d'intervention */
        this.notifications.add("The Product with [ id = "+ i.getId_prod()+"] is Seeking for Intervention IMMEDIALTLY !");
        Intervention p = popPersonnel();
        p.Interagir(this.periode);
        i.setEtatSerice();
    }


    public void setStations(List<Station> s){
        this.Stations = s ;
    }

    public void setVelo(){
    
    }
    
}
