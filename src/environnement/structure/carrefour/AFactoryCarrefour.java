package environnement.structure.carrefour;
import  environnement.structure.Route;

/**
 * Created by philprat on 10/12/2014.
 */
public abstract class AFactoryCarrefour {

    public abstract CarrefourBiDirectionnel createCarrefourBiDirectionnel(Route routeExterieurEntrante, Route routeExterieurSortante,
                                            Route routeInterieurEntrante, Route routeInterieurSortante,
                                            Route routePerpEntrante,      Route routePerpSortante,
                                            boolean hasFeux, int numBiDir);

    public abstract CarrefourTriDirectionnel createCarrefourTriDirectionnel(Route routeUpEntrante,    Route routeUpSortante,
                                             Route routeRightEntrante, Route routeRightSortante,
                                             Route routeDownEntrante,  Route routeDownSortante,
                                             Route routeLeftEntrante,  Route routeLeftSortante,
                                             boolean hasFeux, int numTriDir);

    public abstract CarrefourUniDirectionnel createCarrefourUniDirectionnel(Route routeInterieurEntrante, Route routeInterieurSortante,
                                             Route routeExterieurEntrante, Route routeExterieurSortante,
                                             int numUniDir);
}
