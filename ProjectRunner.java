
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
