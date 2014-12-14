package environnement.signalisation;

/**
 * Created by philprat on 27/11/2014.
 */
public interface IFeuCarrefour {

    void startFeux();

    void stopFeux() throws InterruptedException;
}
