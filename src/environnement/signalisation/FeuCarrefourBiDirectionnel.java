package environnement.signalisation;

import environnement.maillon.MaillonCarrefour;
import environnement.structure.carrefour.CarrefourBiDirectionnel;

/**
 * Created by clément on 25/11/2014.
 */

/*
 *     ← rExtS ← mExtS ← mExtE ← rExtE ←
 *                ↓        ↑
 *     → rIntE → mIntE → mIntS → rIntS →
 *                ↓        ↑
 *             rPerpS   rPerpE
 *                ↓       ↑
 */

public class FeuCarrefourBiDirectionnel extends FeuCarrefour implements IFeuCarrefour{

    private Feu feuOppose;

    public FeuCarrefourBiDirectionnel(CarrefourBiDirectionnel carrefour, int dureeFeu) {
        feuSynchro1 = new Feu((MaillonCarrefour) carrefour.getMaillonExtEntrant(), dureeFeu, true);
        feuSynchro2 = new Feu((MaillonCarrefour) carrefour.getMaillonIntEntrant(), dureeFeu, true);
        feuOppose = new Feu((MaillonCarrefour) carrefour.getMaillonIntSortant(), dureeFeu, false);
    }

    @Override
    public void startFeux() {
        feuSynchro1.start();
        feuSynchro2.start();
        feuOppose.start();
    }
    
    @Override
    public void stopFeux() throws InterruptedException {
        feuSynchro1.interrupt();
        feuSynchro2.interrupt();
        feuOppose.interrupt();

        feuSynchro1.join();
        feuSynchro2.join();
        feuOppose.join();
    }

}
