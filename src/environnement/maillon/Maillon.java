package environnement.maillon;

import vehicule.Vehicule;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by clément on 23/11/2014.
 */
public class Maillon {

    private boolean isEmpty;
    private ArrayList<Maillon> nextMaillons;
    private String identifiant;  // Pour la représentation

    public Maillon(String identifiant) {

        isEmpty = true;
        nextMaillons = new ArrayList<Maillon>();
        this.identifiant = identifiant;
    }

    public void addNextMaillon(Maillon maillon) {
        nextMaillons.add(maillon);
    }

    public Maillon getNextMaillon() {
        Random random = new Random();
        return nextMaillons.get(random.nextInt(nextMaillons.size()));
    }

    public synchronized void attenteMaillonLibre(Vehicule vehicule) {
        while(!this.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        this.vehiculeIn();
        vehicule.consommationEssence();

    }

    public void vehiculeIn() {
        isEmpty = false;
    }

    public synchronized void vehiculeOut() {
        isEmpty = true;
        notifyAll();
    }



    public boolean isEmpty() {
        return isEmpty;
    }

    public String getIdentifiant() {
        return identifiant;
    }
}
