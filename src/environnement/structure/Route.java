package environnement.structure;

import environnement.maillon.Maillon;
import environnement.maillon.MaillonRoute;
import environnement.maillon.MaillonStationEssence;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by clément on 23/11/2014.
 */
public class Route {
    private LinkedList<Maillon> maillons;

    public Route(int longueur, int numRoute) {
        maillons = new LinkedList<Maillon>();

        for (int i = 0; i < longueur; i++) {

            if(i != 2)
            {
                maillons.add(new MaillonRoute("route[" + numRoute + "]:pos[" + i + "]"));
            }
            else {
                maillons.add(new MaillonStationEssence("route[" + numRoute + "]:pos[" + i + "]"));
            }
        }

        for (int i = 0; i < longueur - 1; i++) {
            maillons.get(i).addNextMaillon(maillons.get(i + 1));
        }
    }

    public Maillon getFirstMaillon() {
        return maillons.getFirst();
    }

    public Maillon getLastMaillon() {
        return maillons.getLast();
    }

    public void linkLastMaillon(Maillon maillon) {
        getLastMaillon().addNextMaillon(maillon);
    }

    public Maillon getMaillonAleatoire() {
        Random random = new Random();
        return maillons.get(random.nextInt(maillons.size()));
    }
}