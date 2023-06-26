
package towerofhanoi;

import student.TestCase;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 *
 */
public class DiskTest extends TestCase {
    
    private Disk d;
    
    /**
     * Sets up
     */
    public void setUp() {
        d = new Disk(10);
    }
    /**
     * Tests compareTo method
     */
    public void testCompareTo() {
        Exception thrown = null;
        try {
            d.compareTo(null);
        }
        catch (IllegalArgumentException exception) {
            thrown = exception;
            assertNotNull(thrown);
            assertTrue(thrown instanceof IllegalArgumentException);
        }
        Disk f = new Disk(9);
        Disk g = new Disk(11);
        Disk h = new Disk(10);
        assertEquals(1, d.compareTo(f), 0);
        assertEquals(-1, d.compareTo(g), 0);
        assertEquals(0, d.compareTo(h), 0);
    }
    
    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("10", d.toString());
    }
    
    /**
     * Test equals method
     */
    public void testEquals() {
        Disk f = new Disk(9);
        Disk g = new Disk(10);
        assertFalse(d.equals(f));
        assertTrue(d.equals(g));
        assertFalse(d.equals(null));
    }

}
