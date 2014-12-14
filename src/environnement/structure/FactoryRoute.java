package environnement.structure;

/**
 * Created by philprat on 10/12/2014.
 */
public class FactoryRoute extends AFactoryRoute {

    private static FactoryRoute factoryRoute;

    private FactoryRoute(){

    }

    public static FactoryRoute getInstance()
    {
        if(factoryRoute == null)
        {
            return new FactoryRoute();
        }

        return factoryRoute;
    }

    @Override
    public Route createRoute(int longueur, int numRoute) {
        return new Route(longueur, numRoute);
    }
}
