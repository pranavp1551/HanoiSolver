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
 * @author Pranav Poodari
 * @version 10.18.2022
 *
 */
public class Tower extends LinkedStack<Disk> {
    
    private Position position;
    
    /**
     * Stores position
     * @param position
     *                Position of tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
        
    }
    
    /**
     * Returns position
     * @return position
     */
    public Position position() {
        return position;
    }
    
    /**
     * Adds new disk if it is smaller than the disk below it
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        
        if (this.isEmpty()) {
            super.push(disk);
        }
        else if (disk.compareTo(this.peek()) == -1) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
            
        }
    }

}
