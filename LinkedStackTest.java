
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * 
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class LinkedStackTest extends TestCase {
    
    private LinkedStack n;
    
    /**
     * Sets up
     */
    public void setUp() {
        n = new LinkedStack();
    }
    
    /**
     * Tests size method
     */
    public void testSize() {
        assertEquals(0, n.size(), 0);
        n.push("A");
        assertEquals(1, n.size(), 0);
    }
    
    /**
     * Test clear methods
     */
    public void testClear() {
        n.push("A");
        n.clear();
        assertEquals(0, n.size(), 0);
    }
    
    /**
     * Tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(n.isEmpty());
        n.push("A");
        assertFalse(n.isEmpty());
    }
    
    /**
     * Tests peek method
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            n.peek();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
            assertNotNull(thrown);
            assertTrue(thrown instanceof EmptyStackException);
        }
        n.push("A");
        assertEquals("A", n.peek());
    }
    
    /**
     * Tests pop method
     */
    public void testPop() {
        Exception thrown = null;
        try {
            n.pop();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
            assertNotNull(thrown);
            assertTrue(thrown instanceof EmptyStackException);
        }
        n.push("A");
        assertEquals("A", n.pop());
        assertEquals(0, n.size(), 0);
    }
    
    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("[]", n.toString());
        n.push("A");
        n.push("B");
        n.push("C");
        assertEquals("[C, B, A]", n.toString());
        
    }
    

}
