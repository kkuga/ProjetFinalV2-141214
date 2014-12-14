package vehicule;

import environnement.maillon.Maillon;

/**
 * Created by philprat on 10/12/2014.
 */
public abstract class AFactoryVehicule {

    public abstract Vehicule createVehicule(Maillon maillon, int vitesse, String identifiant);
}
