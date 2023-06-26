
package towerofhanoi;

import student.TestCase;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class HanoiSolverTest extends TestCase {
    
    private HanoiSolver hs;
    private Tower left;
    private Tower right;
    private Tower middle;

    
    /**
     * Sets up
     */
    public void setUp() {
        hs = new HanoiSolver(3);
        right = hs.getTower(Position.RIGHT);
        left = hs.getTower(Position.LEFT);
        middle = hs.getTower(Position.MIDDLE);
    }
    
    /**
     * Tests disk method
     */
    public void testDisks() {
        assertEquals(3, hs.disks(), 0);
    }
    
    /**
     * Tests getTower method
     */
    public void testGetTower() {
        Tower p = hs.getTower(Position.DEFAULT);

        assertEquals(Position.LEFT, left.position());
        assertEquals(Position.RIGHT, right.position());
        assertEquals(Position.MIDDLE, middle.position());
        assertEquals(Position.MIDDLE, p.position());
    }
    
    /**
     * Tests toString method
     */
    public void testToString() {
        Disk a = new Disk(10);
        Disk b = new Disk(9);
        Disk c = new Disk(8);
        right.push(a);
        right.push(b);
        right.push(c);
        left.push(a);
        middle.push(b);
        middle.push(c);
        assertEquals("[8, 9, 10]", right.toString());
        assertEquals("[10]", left.toString());
        assertEquals("[8, 9]", middle.toString());
        assertEquals("[10][8, 9][8, 9, 10]", hs.toString());
    }
    
    /**
     * Tests solve, move, and solveTowers method
     */
    public void testSolve() {
        Disk a = new Disk(10);
        Disk b = new Disk(9);
        Disk c = new Disk(8);
        left.push(a);
        left.push(b);
        left.push(c);
        hs.solve();
        assertEquals(3, right.size(), 0);
        assertEquals(0, middle.size(), 0);
        assertEquals(0, left.size(), 0);
    }

}
