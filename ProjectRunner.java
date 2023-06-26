/**
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor 
// will I accept the actions of those who do.
// -- Pranav Poodari (pranavp1551)
 */
package towerofhanoi;

/**
 * 
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class ProjectRunner {
    
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        
        int numDisks = 6;
        HanoiSolver hs = new HanoiSolver(numDisks);
        PuzzleWindow pw = new PuzzleWindow(hs);
    }

}
