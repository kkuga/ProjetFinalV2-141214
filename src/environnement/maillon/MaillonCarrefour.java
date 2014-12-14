package environnement.maillon;

import vehicule.Vehicule;

/**
 * Created by PHILIPPE on 12/12/2014.
 */
public class MaillonCarrefour extends Maillon {

    private final boolean hasFeux;
    private boolean isAccessible;

    public MaillonCarrefour(String identifiant, boolean hasFeux) {

        super(identifiant);
        this.hasFeux = hasFeux;
        this.isAccessible = true;
    }


    public synchronized void attenteMaillonLibreEtAccessible(Vehicule vehicule) {

        while(!this.isEmpty() || !isAccessible) {

            if(!isAccessible) {
                System.out.println("" + vehicule.getIdentifiant() + " bloqué au feu rouge " + vehicule.getPosition().getIdentifiant());

                try {
                    wait();
                }catch (InterruptedException e)
                {
                    System.out.println(e);
                }

                System.out.println("Feu vert vehicule : "+vehicule.getIdentifiant()+" repart");
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        }

        this.vehiculeIn();
        vehicule.consommationEssence();
    }


    public boolean isAccessible() {
        return isAccessible;
    }

    public void inaccessible() {
        isAccessible = false;
    }

    public synchronized void accessible() {
        isAccessible = true;
        notifyAll();
    }

    public boolean hasFeux() {
        return hasFeux;
    }
}
