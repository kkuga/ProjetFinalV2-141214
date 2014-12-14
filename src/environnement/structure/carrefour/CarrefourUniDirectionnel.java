package environnement.structure.carrefour;

/**
 * Created by clément on 23/11/2014.
 */

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;
import environnement.structure.Route;

/**
 *      Carrefour pour lequel une voiture entrant sur le carrefour ressortira par une seule route:
 *
 *   ← rExtE ← mExt3 ← mExt2
 *                        ↑
 *   → rIntE → mInt   mExt1
 *               ↓       ↑
 *             rIntS  rExtE
 *              ↓       ↑
 *
 */
public class CarrefourUniDirectionnel {
    private Maillon maillonInt;
    private Maillon maillonExt1;
    private Maillon maillonExt2;
    private Maillon maillonExt3;

    public CarrefourUniDirectionnel(Route routeInterieurEntrante, Route routeInterieurSortante,
                                    Route routeExterieurEntrante, Route routeExterieurSortante,
                                    int numUniDir) {
        maillonInt = new MaillonCarrefour("carrUniDir[" + numUniDir + "]:maillonInterieur",false);
        maillonExt1 = new MaillonCarrefour("carrUniDir[" + numUniDir + "]:maillonExterieur1",false);
        maillonExt2 = new MaillonCarrefour("carrUniDir[" + numUniDir + "]:maillonExterieur2", false);
        maillonExt3 = new MaillonCarrefour("carrUniDir[" + numUniDir + "]:maillonExterieur3", false);

        routeInterieurEntrante.linkLastMaillon(maillonInt);
        maillonInt.addNextMaillon(routeInterieurSortante.getFirstMaillon());

        routeExterieurEntrante.linkLastMaillon(maillonExt1);
        maillonExt1.addNextMaillon(maillonExt2);
        maillonExt2.addNextMaillon(maillonExt3);
        maillonExt3.addNextMaillon(routeExterieurSortante.getFirstMaillon());
    }
}

