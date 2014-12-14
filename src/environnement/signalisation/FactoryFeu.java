package environnement.signalisation;

import environnement.structure.carrefour.CarrefourBiDirectionnel;
import environnement.structure.carrefour.CarrefourTriDirectionnel;

/**
 * Created by philprat on 10/12/2014.
 */
public class FactoryFeu extends AFactoryFeu {

    private static FactoryFeu factoryFeu;

    private FactoryFeu(){

    }

    public static FactoryFeu getInstance()
    {
        if(factoryFeu == null)
        {
            return new FactoryFeu();
        }

        return factoryFeu;
    }

    @Override
    public FeuCarrefourBiDirectionnel createFeuCarrefourBiDirectionnel(CarrefourBiDirectionnel carrefour, int dureeFeu) {
        return new FeuCarrefourBiDirectionnel(carrefour, dureeFeu);
    }

    @Override
    public FeuCarrefourTriDirectionnel createFeuCarrefourTriDirectionnel(CarrefourTriDirectionnel carrefour, int dureeFeu) {
        return new FeuCarrefourTriDirectionnel(carrefour,dureeFeu);
    }
}
