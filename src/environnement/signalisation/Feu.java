package environnement.signalisation;

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;

/**
 * Created by clément on 25/11/2014.
 */
public class Feu extends Thread {

    private MaillonCarrefour maillonCarrefour;
    private int dureeFeu;

    public Feu(MaillonCarrefour maillonCarrefour, int dureeFeu, boolean startAtVert) {
        this.maillonCarrefour = maillonCarrefour;
        this.dureeFeu = dureeFeu;
        if(startAtVert) {
            this.maillonCarrefour.accessible();
        } else {
            this.maillonCarrefour.inaccessible();
        }
    }

    public void changerFeu() {
        if (maillonCarrefour.isAccessible()) {
            maillonCarrefour.inaccessible();
        } else {
            maillonCarrefour.accessible();
        }
    }

    public void run() {
        try {
            while(!isInterrupted()) {
                /*System.out.println(toString());*/
                sleep(dureeFeu);
                changerFeu();
            }
        } catch (InterruptedException e) {

        }
    }

    public String couleurFeu() {
        if(maillonCarrefour.isAccessible()) {
            return "vert";
        }
        return "rouge";
    }

    @Override
    public String toString() {
        return maillonCarrefour.getIdentifiant() + " => FEU " + couleurFeu() + "!" ;
    }
}