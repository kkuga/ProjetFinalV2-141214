package environnement.maillon;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by kuga on 04/12/2014.
 */
public class MaillonTest {
    private Maillon maillonTest,maillonSuivant;


    //On test si la position suivante du maillonTest
    @Test
    public void testNextMaillon(){
        maillonTest = createMaillon(true,false,"numero1");
        maillonSuivant = createMaillon(false,false,"numero2");
        maillonTest.addNextMaillon(maillonSuivant);
        assertEquals(maillonSuivant,maillonTest.getNextMaillon());
    }


    //Creation de l'objet Maillon
    public Maillon createMaillon(boolean hasFeux, boolean isMaillonCarrefour, String identifiant ){
        Maillon m1=new Maillon(identifiant);
        return m1;
    }


}