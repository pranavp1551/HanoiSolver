/**
 * 
 */
package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class Disk extends Shape implements Comparable<Disk> {
    
    /**
     * Constructor that creates a new disk of desired width
     * and random color
     * @param width
     *             Desired with of disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        int a = randomGenerator.nextInt(256);
        int b = randomGenerator.nextInt(256);
        int c = randomGenerator.nextInt(256);
        Color cl = new Color(a, b, c);
        this.setBackgroundColor(cl);
    }
    
    /**
     * Compares widths of two disks
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        else {
            if (this.getWidth() < otherDisk.getWidth()) {
                return -1;
            }
            else if (this.getWidth() > otherDisk.getWidth()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    
    /**
     * Prints disk width
     * @return
     *        String with disk widths
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getWidth());
        return sb.toString();
    }
    
    /**
     * Checks if two disk widths are equal
     * @param otherDisk
     *                 Checks otherDisk width
     * @return
     *        true or false if widths are equal or not
     */
    public boolean equals(Object otherDisk) {
        if (otherDisk != null) {
            if (otherDisk instanceof Disk) {
                Disk d = (Disk)otherDisk;
                return (this.getWidth() == d.getWidth());
            }
            return false;
            
        }
        return false;
    }

}