package environnement.structure;

/**
 * Created by clément on 23/11/2014.
 */

import environnement.maillon.Maillon;
import environnement.signalisation.AFactoryFeu;
import environnement.signalisation.FactoryFeu;
import environnement.signalisation.FeuCarrefourBiDirectionnel;
import environnement.signalisation.FeuCarrefourTriDirectionnel;
import environnement.structure.carrefour.*;

import java.util.Random;

/**
 *
 *      u0 ← u0 ← r0  ← b3 ← b3 ← r7  ← u3 ← u3
 *      ↓                 ↓    ↑                 ↑
 *      u0   u0 → r9  → b3 → b3 → r10 → u3    u3
 *      ↓    ↑           ↓     ↑           ↓     ↑
 *      r1   r8          r16   r17         r11   r6
 *      ↓    ↑           ↓     ↑           ↓     ↑
 *      b0 ← b0 ← r23 ← t0    t0 ← r18 ← b2 ← b2
 *      ↓    ↑           ↓     ↑           ↓     ↑
 *      b0 → b0 → r22 → t0 → t0 → r19 → b2 → b2
 *      ↓    ↑           ↓     ↑           ↓     ↑
 *      r2   r15         r21   r20         r12   r5
 *      ↓    ↑           ↓     ↑           ↓     ↑
 *      u1   u1 ← r14 ← b1 ← b1 ← r13 ← u2    u2
 *      ↓                 ↓     ↑                 ↑
 *      u1 → u1 → r3  → b1 → b1 → r4  → u2 → u2
 *
 *
 */
public class Map {
    private static int NB_ROUTES = 24;
    private static int LONGUEUR_ROUTES = 5;
    private static int NB_CARREFOUR_UNIDIR = 4;
    private static int NB_CARREFOUR_BIDIR = 4;
    private static int NB_CARREFOUR_TRIDIR = 1;
    private static int NB_FEUX_TROIESVOIES = 4;
    private static int NB_FEUX_QUATREVOIES = 1;

    private Route[] r = new Route[NB_ROUTES];;
    private CarrefourUniDirectionnel[] u = new CarrefourUniDirectionnel[NB_CARREFOUR_UNIDIR];
    private CarrefourBiDirectionnel[] b = new CarrefourBiDirectionnel[NB_CARREFOUR_BIDIR];
    private CarrefourTriDirectionnel[] t = new CarrefourTriDirectionnel[NB_CARREFOUR_TRIDIR];

    private FeuCarrefourBiDirectionnel[] fb = new FeuCarrefourBiDirectionnel[NB_FEUX_TROIESVOIES];
    private FeuCarrefourTriDirectionnel[] ft = new FeuCarrefourTriDirectionnel[NB_FEUX_QUATREVOIES];

    public Map() {

        this.creationRoute();

        this.creationCarrefour();

        this.creationFeux();

        this.startFeux();

    }

    public void creationRoute(){

        AFactoryRoute factoryRoute = FactoryRoute.getInstance();

        for (int i = 0; i < NB_ROUTES; i++) {
            r[i] = factoryRoute.createRoute(LONGUEUR_ROUTES, i);
        }

    }

    public void creationCarrefour()
    {
        AFactoryCarrefour factoryCarrefour = FactoryCarrefour.getInstance();

        u[0] = factoryCarrefour.createCarrefourUniDirectionnel(r[8], r[9], r[0], r[1], 0);
        u[1] = factoryCarrefour.createCarrefourUniDirectionnel(r[14], r[15], r[2], r[3], 1);
        u[2] = factoryCarrefour.createCarrefourUniDirectionnel(r[12], r[13], r[4], r[5], 2);
        u[3] = factoryCarrefour.createCarrefourUniDirectionnel(r[10], r[11], r[6], r[7], 3);

        b[0] = factoryCarrefour.createCarrefourBiDirectionnel(r[1], r[2], r[15], r[8], r[23], r[22], false, 0);
        b[1] = factoryCarrefour.createCarrefourBiDirectionnel(r[3], r[4], r[13], r[14], r[21], r[20], false, 1);
        b[2] = factoryCarrefour.createCarrefourBiDirectionnel(r[5], r[6], r[11], r[12], r[19], r[18], false, 2);
        b[3] = factoryCarrefour.createCarrefourBiDirectionnel(r[7], r[0], r[9], r[10], r[17], r[16], false, 3);

        t[0] = factoryCarrefour.createCarrefourTriDirectionnel(r[16], r[17], r[18], r[19], r[20], r[21], r[22], r[23],
                true, 0);


       /* u[0] = new CarrefourUniDirectionnel(r[8], r[9], r[0], r[1], 0);
        u[1] = new CarrefourUniDirectionnel(r[14], r[15], r[2], r[3], 1);
        u[2] = new CarrefourUniDirectionnel(r[12], r[13], r[4], r[5], 2);
        u[3] = new CarrefourUniDirectionnel(r[10], r[11], r[6], r[7], 3);*/

        /*b[0] = new CarrefourBiDirectionnel(r[1], r[2], r[15], r[8], r[23], r[22], false, 0);
        b[1] = new CarrefourBiDirectionnel(r[3], r[4], r[13], r[14], r[21], r[20], false, 1);
        b[2] = new CarrefourBiDirectionnel(r[5], r[6], r[11], r[12], r[19], r[18], false, 2);
        b[3] = new CarrefourBiDirectionnel(r[7], r[0], r[9], r[10], r[17], r[16], false, 3);*/

        /*t[0] = new CarrefourTriDirectionnel(r[16], r[17], r[18], r[19], r[20], r[21], r[22], r[23],
                true, 0);*/
    }

    public void creationFeux()
    {
        AFactoryFeu factoryFeu = FactoryFeu.getInstance();

        ft[0] = factoryFeu.createFeuCarrefourTriDirectionnel(t[0], 5000);

        fb[0] = factoryFeu.createFeuCarrefourBiDirectionnel(b[0], 10000);
        fb[1] = factoryFeu.createFeuCarrefourBiDirectionnel(b[1], 7000);
        fb[2] = factoryFeu.createFeuCarrefourBiDirectionnel(b[2], 8000);
        fb[3] = factoryFeu.createFeuCarrefourBiDirectionnel(b[3], 10000);
    }

    public Route getRouteAleatoire() {
        Random randomRoute = new Random();

        return r[randomRoute.nextInt(NB_ROUTES)];
    }

    public Maillon getMaillonAleatoireFromRouteAleatoire() {
        Random randomRoute = new Random();

        return r[randomRoute.nextInt(NB_ROUTES)].getMaillonAleatoire();
    }

    public void startFeux() {
        for (int i = 0; i < fb.length; i++) {
            fb[i].startFeux();
        }

        for (int i = 0; i < ft.length; i++) {
            ft[i].startFeux();
        }
    }

    public void stopFeux() throws InterruptedException {
        for (int i = 0; i < fb.length; i++) {
            fb[i].stopFeux();
        }

        for (int i = 0; i < ft.length; i++) {
            ft[i].stopFeux();
        }
    }
}




