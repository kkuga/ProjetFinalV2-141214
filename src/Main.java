import environnement.structure.AFactoryRoute;
import environnement.structure.Map;
import vehicule.AFactoryVehicule;
import vehicule.FactoryVehicule;
import vehicule.Vehicule;

import java.util.Scanner;

/**
 * Created by clément on 23/11/2014.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Map map = new Map();

        AFactoryVehicule factoryVehicule = FactoryVehicule.getInstance();

        Vehicule v1 = factoryVehicule.createVehicule(map.getRouteAleatoire().getLastMaillon(), 2000, "Peugeot");
        Vehicule v2 = factoryVehicule.createVehicule(map.getRouteAleatoire().getFirstMaillon(), 2000, "Citroen");

        Scanner sc = new Scanner(System.in);

        v1.start();
        v2.start();

        sc.next();

        v1.interrupt();
        v2.interrupt();

        v1.join();
        v2.join();

        map.stopFeux();
    }
}
