/**
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor 
// will I accept the actions of those who do.
// -- Pranav Poodari (pranavp1551)
 */
package towerofhanoi;

import student.TestCase;

/**
 * 
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class TowerTest extends TestCase {
    
    private Tower t;
    
    /**
     * Sets up
     */
    public void setUp() {
        t = new Tower(Position.MIDDLE);
    }
    
    
    /**
     * Tests position method
     */
    public void testPosition() {
        assertEquals(Position.MIDDLE, t.position());
    }
    
    /**
     * Tests push method
     */
    public void testPush() {
        Exception thrown = null;
        try {
            t.push(null);
        }
        catch (IllegalArgumentException exception) {
            thrown = exception;
            assertNotNull(thrown);
            assertTrue(thrown instanceof IllegalArgumentException);
        }
        Disk d = new Disk(10);
        t.push(d);
        assertEquals(1, t.size(), 0);
        Disk e = new Disk(9);
        t.push(e);
        assertEquals(2, t.size(), 0);
        Disk f = new Disk(11);
        Exception thrown1 = null;
        try {
            t.push(f);
        }
        catch (IllegalStateException exception) {
            thrown1 = exception;
            assertNotNull(thrown1);
            assertTrue(thrown1 instanceof IllegalStateException);
        }

    }
    
    
}

