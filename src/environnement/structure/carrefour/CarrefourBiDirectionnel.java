package environnement.structure.carrefour;

/**
 * Created by clément on 23/11/2014.
 */

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;
import environnement.structure.Route;

/**
 *      Carrefour pour lequel une voiture entrant sur le carrefour "choisir" entre deux directions
 *    différentes:
 *
 *
 *     ← rExtS ← mExtS ← mExtE ← rExtE ←
 *                ↓        ↑
 *     → rIntE → mIntE → mIntS → rIntS →
 *                ↓        ↑
 *             rPerpS   rPerpE
 *                ↓       ↑

 */
public class CarrefourBiDirectionnel {
    private Maillon maillonExtEntrant;
    private Maillon maillonExtSortant;
    private Maillon maillonIntEntrant;
    private Maillon maillonIntSortant;

    public CarrefourBiDirectionnel(Route routeExterieurEntrante, Route routeExterieurSortante,
                                   Route routeInterieurEntrante, Route routeInterieurSortante,
                                   Route routePerpEntrante,      Route routePerpSortante,
                                   boolean hasFeux, int numBiDir) {
        maillonExtEntrant = new MaillonCarrefour("biDir[" + numBiDir + "]:maillonExtEntrant",hasFeux);
        maillonExtSortant = new MaillonCarrefour("biDir[" + numBiDir + "]:maillonExtSortant",hasFeux);
        maillonIntEntrant = new MaillonCarrefour("biDir[" + numBiDir + "]:maillonIntEntrant",hasFeux);
         maillonIntSortant = new MaillonCarrefour("biDir[" + numBiDir + "]:maillonIntSortant",hasFeux);

         maillonExtEntrant.addNextMaillon(maillonExtSortant);
        maillonExtSortant.addNextMaillon(maillonIntEntrant);
        maillonIntEntrant.addNextMaillon(maillonIntSortant);
        maillonIntSortant.addNextMaillon(maillonExtEntrant);

        routeExterieurEntrante.linkLastMaillon(maillonExtEntrant);
        maillonExtSortant.addNextMaillon(routeExterieurSortante.getFirstMaillon());
        routeInterieurEntrante.linkLastMaillon(maillonIntEntrant);
        maillonIntSortant.addNextMaillon(routeInterieurSortante.getFirstMaillon());
        routePerpEntrante.linkLastMaillon(maillonIntSortant);
        maillonIntEntrant.addNextMaillon(routePerpSortante.getFirstMaillon());
    }

    public MaillonCarrefour getMaillonExtEntrant() {
        return (MaillonCarrefour) maillonExtEntrant;
    }

    public MaillonCarrefour getMaillonExtSortant() {
        return (MaillonCarrefour) maillonExtSortant;
    }

    public MaillonCarrefour getMaillonIntEntrant() {
        return (MaillonCarrefour) maillonIntEntrant;
    }

    public MaillonCarrefour getMaillonIntSortant() {
        return (MaillonCarrefour) maillonIntSortant;
    }
}
