package environnement.signalisation;

import environnement.structure.carrefour.CarrefourBiDirectionnel;
import environnement.structure.carrefour.CarrefourTriDirectionnel;

/**
 * Created by philprat on 10/12/2014.
 */
public abstract class AFactoryFeu {

    public abstract FeuCarrefourBiDirectionnel createFeuCarrefourBiDirectionnel(CarrefourBiDirectionnel carrefour, int dureeFeu);

    public abstract FeuCarrefourTriDirectionnel createFeuCarrefourTriDirectionnel(CarrefourTriDirectionnel carrefour, int dureeFeu);
}
