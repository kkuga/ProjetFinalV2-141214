package vehicule;

import environnement.maillon.Maillon;

/**
 * Created by philprat on 10/12/2014.
 */
public class FactoryVehicule extends AFactoryVehicule {

    private static FactoryVehicule factoryVehicule;

    private FactoryVehicule(){

    }

    public static FactoryVehicule getInstance(){

        if(factoryVehicule == null)
        {
            return new FactoryVehicule();
        }

        return factoryVehicule;
    }

    @Override
    public Vehicule createVehicule(Maillon maillon, int vitesse, String identifiant) {

        return new Vehicule(maillon, vitesse, identifiant);
    }
}
