package environnement.structure.carrefour;

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;
import environnement.structure.Route;

/**
 * Created by clément on 23/11/2014.
 */

/**
 *      Carrefour à 4 voies:
 *
 *             rUE   rUS
 *              ↓     ↑
 *      rLS ← mHG ← mHD ← rRE
 *             ↓     ↑
 *     rLE → mBG → mBD → rRS
 *            ↓      ↑
 *           rDS    rDE
 *
 */

public class CarrefourTriDirectionnel {
    private Maillon maillonHautGauche;
    private Maillon maillonHautDroit;
    private Maillon maillonBasGauche;
    private Maillon maillonBasDroit;

    public CarrefourTriDirectionnel(Route routeUpEntrante,    Route routeUpSortante,
                                    Route routeRightEntrante, Route routeRightSortante,
                                    Route routeDownEntrante,  Route routeDownSortante,
                                    Route routeLeftEntrante,  Route routeLeftSortante,
                                    boolean hasFeux, int numTriDir) {
        maillonHautGauche = new MaillonCarrefour("triDir[" + numTriDir + "]:maillonHautGauche",hasFeux);
        maillonHautDroit = new MaillonCarrefour("triDir[" + numTriDir + "]:maillonHautDroit",hasFeux);
        maillonBasGauche = new MaillonCarrefour("triDir[" + numTriDir + "]:maillonBasGauche",hasFeux);
        maillonBasDroit = new MaillonCarrefour("triDir[" + numTriDir + "]:maillonBasDroit",hasFeux);

        maillonHautGauche.addNextMaillon(maillonBasGauche);
        maillonBasGauche.addNextMaillon(maillonBasDroit);
        maillonBasDroit.addNextMaillon(maillonHautDroit);
        maillonHautDroit.addNextMaillon(maillonHautGauche);

        routeUpEntrante.linkLastMaillon(maillonHautGauche);
        routeRightEntrante.linkLastMaillon(maillonHautDroit);
        routeDownEntrante.linkLastMaillon(maillonBasDroit);
        routeLeftEntrante.linkLastMaillon(maillonBasGauche);

        maillonHautGauche.addNextMaillon(routeLeftSortante.getFirstMaillon());
        maillonHautDroit.addNextMaillon(routeUpSortante.getFirstMaillon());
        maillonBasDroit.addNextMaillon(routeRightSortante.getFirstMaillon());
        maillonBasGauche.addNextMaillon(routeDownSortante.getFirstMaillon());
    }

    public MaillonCarrefour getMaillonHautGauche() {
        return (MaillonCarrefour) maillonHautGauche;
    }

    public MaillonCarrefour getMaillonHautDroit() {
        return (MaillonCarrefour) maillonHautDroit;
    }

    public MaillonCarrefour getMaillonBasGauche() {
        return (MaillonCarrefour) maillonBasGauche;
    }

    public MaillonCarrefour getMaillonBasDroit() {
        return (MaillonCarrefour) maillonBasDroit;
    }
}
