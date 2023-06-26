
package towerofhanoi;

import java.util.Observable;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 *
 */
public class HanoiSolver extends Observable {
    
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * Constructor that stores numDisks and initializes the towers
     * @param numDisks 
     *                Number of disks that the game will use
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Returns number of disks
     * @return numDisks
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * Returns the corresponding tower
     * @param pos
     *           Position of tower
     * @return Tower corresponding to position
     *        
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }
    
    /**
     * Prints tower sizes
     * @return
     *        String representation of the disks on each tower
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(left.toString());
        sb.append(middle.toString());
        sb.append(right.toString());
        return sb.toString();
    }
    
    
    /**
     * Moves disk from one tower to another
     * @param source
     *              Initial tower
     * @param destination
     *                   Final tower
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        this.setChanged();
        this.notifyObservers(destination.position());
    }

    /**
     * Initial recursive call
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
        
    }
    
    /**
     * Solves Hanoi Tower problem using recursion
     * @param currentDisks
     *                    Number of disks on startPole
     * @param startPole
     *                 Initial tower
     * @param tempPole
     *                Temporary tower to get to endPole
     * @param endPole
     *               Final tower that disk will end on
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole) {

        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
        
    }

}
