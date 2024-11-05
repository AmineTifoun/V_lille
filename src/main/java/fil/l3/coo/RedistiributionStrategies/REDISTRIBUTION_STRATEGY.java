package fil.l3.coo.RedistiributionStrategies;
import fil.l3.coo.* ;
import java.util.*;

public interface REDISTRIBUTION_STRATEGY {
    void REDISTRIBUTION(List<Station> source , List<Station> dest) throws Exception ;
}
