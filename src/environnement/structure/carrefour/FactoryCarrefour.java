package environnement.structure.carrefour;

import environnement.structure.Route;

/**
 * Created by philprat on 10/12/2014.
 */
public class FactoryCarrefour extends AFactoryCarrefour {

    private static FactoryCarrefour factoryCarrefour;

    private FactoryCarrefour(){

    }

    public static FactoryCarrefour getInstance()
    {
        if(factoryCarrefour == null)
        {
            return new FactoryCarrefour();
        }

        return factoryCarrefour;
    }


    @Override
    public CarrefourBiDirectionnel createCarrefourBiDirectionnel(Route routeExterieurEntrante,Route routeExterieurSortante,
                                                           Route routeInterieurEntrante,Route routeInterieurSortante,
                                                           Route routePerpEntrante,Route routePerpSortante,
                                                           boolean hasFeux, int numBiDir) {

        return new CarrefourBiDirectionnel(routeExterieurEntrante, routeExterieurSortante,
                routeInterieurEntrante,routeInterieurSortante,
                routePerpEntrante, routePerpSortante,
                hasFeux,numBiDir);
    }

    @Override
    public CarrefourTriDirectionnel createCarrefourTriDirectionnel(Route routeUpEntrante, Route routeUpSortante,
                                                             Route routeRightEntrante, Route routeRightSortante,
                                                             Route routeDownEntrante, Route routeDownSortante,
                                                             Route routeLeftEntrante, Route routeLeftSortante,
                                                             boolean hasFeux, int numTriDir) {

        return new CarrefourTriDirectionnel(routeUpEntrante, routeUpSortante,
                routeRightEntrante, routeRightSortante,
                routeDownEntrante, routeDownSortante,
                routeLeftEntrante, routeLeftSortante,
                hasFeux, numTriDir);
    }

    @Override
    public CarrefourUniDirectionnel createCarrefourUniDirectionnel(Route routeInterieurEntrante, Route routeInterieurSortante,
                                                             Route routeExterieurEntrante,Route routeExterieurSortante,
                                                             int numUniDir) {

        return new CarrefourUniDirectionnel(routeInterieurEntrante, routeInterieurSortante,
                routeExterieurEntrante, routeExterieurSortante,
                numUniDir);
    }


}
