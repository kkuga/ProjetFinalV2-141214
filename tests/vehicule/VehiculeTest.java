package vehicule;

import environnement.maillon.Maillon;
import environnement.structure.Route;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by kuga on 04/12/2014.
 */

public class VehiculeTest {
    private Vehicule vehiculeTest,vehiculeSuivant;
    private Maillon m1,m2;
    private Route r1;

    //On test si un vehicule est en attente
    @Test
    public void testVehiculeEnAttente(){
        r1=new Route(10,1); //Instanciation d'une route

        vehiculeTest = createVehicule(r1.getFirstMaillon(),2000,"numero2");
        m1=vehiculeTest.getPosition();  // position du vehiculeTest au debut
        vehiculeSuivant = createVehicule(vehiculeTest.getPosition().getNextMaillon(),5000,"numero2");//si on instancie pas vehiculeSuivant , le test nous renvoi une erreur

        vehiculeTest.start(); // on démarre le vehiculeTest

        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(m1, vehiculeTest.getPosition());   //ici , le vehiculeTest essaye d'avancer  (= le vehiculeTest doit être en attente)
    }


    //Creation d'un objet Vehicule
    public Vehicule createVehicule(Maillon maillon, int vitesse, String identifiant)
    {
        Vehicule v1 = new Vehicule(maillon, vitesse, identifiant);
        return v1;
    }
}