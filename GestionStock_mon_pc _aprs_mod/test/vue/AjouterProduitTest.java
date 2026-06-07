/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import model.Produit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hicham
 */
public class AjouterProduitTest {
    
    public AjouterProduitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getObj method, of class AjouterProduit.
     */
    @Test
    public void testGetObj() {
        System.out.println("getObj");
        int type = 0;
        AjouterProduit expResult = null;
        AjouterProduit result = AjouterProduit.getObj(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObj2 method, of class AjouterProduit.
     */
    @Test
    public void testGetObj2() {
        System.out.println("getObj2");
        Produit p = null;
        AjouterProduit expResult = null;
        AjouterProduit result = AjouterProduit.getObj2(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class AjouterProduit.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        AjouterProduit instance = null;
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resize method, of class AjouterProduit.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        String imgPath = "";
        AjouterProduit instance = null;
        ImageIcon expResult = null;
        ImageIcon result = instance.resize(imgPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyTyped method, of class AjouterProduit.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent ke = null;
        AjouterProduit instance = null;
        instance.keyTyped(ke);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class AjouterProduit.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        AjouterProduit instance = null;
        instance.keyPressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class AjouterProduit.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        AjouterProduit instance = null;
        instance.keyReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
