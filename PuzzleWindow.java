
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 */
public class PuzzleWindow implements Observer {
    
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int WIDTH_FACTOR = 30;
    public static final int DISK_GAP = 15;
    public static final int DISK_HEIGHT = 20;
    
    /**
     * Sets up window where the game is played/solved
     * @param game
     *            New HanoiSolver which has disks added to it
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower Of Hanoi");
        left = new Shape(300, 500, 15, 200, Color.BLACK);
        right = new Shape(900, 500, 15, 200, Color.BLACK);
        middle = new Shape(600, 500, 15, 200, Color.BLACK);
        
        for (int i = game.disks(); i >= 1; i--) {
            Disk d = new Disk(i * WIDTH_FACTOR);
            window.addShape(d);
            game.getTower(Position.LEFT).push(d);
            this.moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(right);
        window.addShape(middle);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");

    }
    
    /**
     * 
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Links solve button to solve method
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Updates window with every move
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position p = (Position)arg;
            moveDisk(p);
            sleep();
        }
    }
    
    /**
     * Moves disk from pole to another and updates window with said move
     * @param position
     */
    private void moveDisk(Position position) {
        Disk currentDisk;
        Shape currentPole;
        Tower t = game.getTower(position);
        currentDisk = t.peek();
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else {
            currentPole = middle;
        }
        currentDisk.setY(currentPole.getY() + currentPole.getHeight() - 
            (currentDisk.getHeight()*t.size()));
        currentDisk.setX(currentPole.getX() + currentPole.getWidth()/2 - 
            currentDisk.getWidth()/2);

    }
    
    

}
