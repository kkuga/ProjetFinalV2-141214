package environnement.signalisation;

import environnement.maillon.Maillon;
import environnement.maillon.MaillonCarrefour;
import environnement.structure.Route;
import environnement.structure.carrefour.CarrefourBiDirectionnel;
import org.testng.annotations.Test;

/**
 * Created by kuga on 04/12/2014.
 */

import static org.testng.Assert.*;

public class FeuTest {
    private Route r1=new Route(10,1);
    private Route r2=new Route(10,2);
    private Route r3=new Route(10,3);
    private Route r4=new Route(10,4);
    private Route r5=new Route(10,5);
    private Route r6=new Route(10,6);


    private Maillon m1;
    private CarrefourBiDirectionnel c1;

    @Test
    public void testFeuPasseAuVert(){
        m1=r1.getFirstMaillon();
        Feu feuTest = creationFeu((MaillonCarrefour) m1,2000,false);
        feuTest.changerFeu();// le feu passe au vert
        assertEquals("vert", feuTest.couleurFeu());//le feu doit etre au vert
    }

    @Test
    public void testFeuSynchro(){
        c1 = new CarrefourBiDirectionnel(r1,r2,r3,r4,r5,r6,true,1);
        FeuCarrefourBiDirectionnel f1 = creationFeuBidirectionnel(c1,2000);

        f1.startFeux();
        assertTrue(c1.getMaillonExtEntrant().isAccessible());
        assertTrue(c1.getMaillonIntEntrant().isAccessible());
        assertFalse(c1.getMaillonIntSortant().isAccessible());
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        assertFalse(c1.getMaillonExtEntrant().isAccessible());
        assertFalse(c1.getMaillonIntEntrant().isAccessible());
        assertTrue(c1.getMaillonIntSortant().isAccessible());

    }

    public Feu creationFeu(MaillonCarrefour m1,int dureeFeu,boolean startAtVert){
        Feu f1 = new Feu(m1,dureeFeu,startAtVert);
        return f1;
    }

    public FeuCarrefourBiDirectionnel creationFeuBidirectionnel(CarrefourBiDirectionnel carrefour, int dureeFeu)
    {
        FeuCarrefourBiDirectionnel f1 = new FeuCarrefourBiDirectionnel(carrefour,dureeFeu);
        return f1;
    }


}