package vehicule;

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;
import environnement.maillon.MaillonRoute;
import environnement.maillon.MaillonStationEssence;
//import junit.framework.Assert;    Bug : pb library ?// TODO on peut le retirer car inutile ??

import java.util.Random;

/**
 * Created by clément on 24/11/2014.
 */
public class Vehicule extends Thread {
    private Maillon position;
    private int vitesse;
    private String identifiant; //Pour la représentation
    private int essence;

    public Vehicule(Maillon maillon, int vitesse, String identifiant) {
        position = maillon;
        position.vehiculeIn();
        this.vitesse = this.vitesseAleatoire();
        this.identifiant = identifiant;
        this.essence = 15;
    }

    public void avancer() {

        Maillon nextPosition = position.getNextMaillon(),
        tmp = position;



        if(!(nextPosition.getClass() == MaillonCarrefour.class)) {

            if(!(nextPosition.getClass()== MaillonStationEssence.class) || this.essence > 8) {

                nextPosition.attenteMaillonLibre(this);
            }
            else{

                    nextPosition.attenteMaillonLibre(this);

                    this.augmentationCarburant();
            }
        } else {

            if(((MaillonCarrefour) nextPosition).hasFeux() && position.getClass()!= MaillonCarrefour.class){

                ((MaillonCarrefour) nextPosition).attenteMaillonLibreEtAccessible(this);
            }
            else{

                nextPosition.attenteMaillonLibre(this);
            }

        }

        position = nextPosition;

        tmp.vehiculeOut();

        System.out.println(identifiant + " => " + position.getIdentifiant()+" essence :"+this.getEssence()+" vitesse:"+this.getVitesse());
    }

    public void run()
    {
        try {
            System.out.println(identifiant +
                               ": Debut Du Parcours sur: " + position.getIdentifiant());
            while(!isInterrupted()) {
                avancer();
                sleep(vitesse);
            }
        } catch (InterruptedException e) {
            position.vehiculeOut();
            System.out.println(identifiant + ": Fin Du Parcours!");
        }
    }

    public Maillon getPosition() {
        return position;
    }

    public void consommationEssence()
    {
        essence--;
    }

    public void augmentationCarburant()
    {
        System.out.println(""+this.getIdentifiant()+" fait le plein");
        this.essence+= 10;
    }

    public int getEssence() {
        return essence;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public int vitesseAleatoire()
    {
        Random r = new Random();

         return r.nextInt(3000-1000+1)+1000;

    }

    public int getVitesse() {
        return vitesse;
    }
}
