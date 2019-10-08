/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author geter
 */
public class Spaceship extends Invader {
    
    private int bounces = 0;
    private double direction;
    private double lastDirection;
    
    public Spaceship() {
        
        direction = 0.0;
        lastDirection = 180.00;
        
        try {
            Image image;
            image = new Image( new FileInputStream("spritesheet.jpg"));
            this.setImage(image);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
        //location of the top-left corner and the width and the height.
        Rectangle2D viewportRect = new Rectangle2D(169, 177, 40, 20);

        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        ;

        //Give an initial location to the CmdCenter
        this.setX(0);
        this.setY(0);
        
        this.setRandomPointValue();
        this.setSpeed(5.0);
        
        
        

    }
    
    public void move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()) );
        this.setX(newX);
        this.setY(newY);

        if (0>= this.getX()) {
            this.setX(0);
        }
        else if (this.getX() > 560) {
            this.setX(560);
        }
    }
    
    public void checkBounds() {
        double currentX = this.getX();
       
        if (currentX == 530.00 && direction == 0) {
            changeDirection();
            bounces += 1;
            turnVisible();
        }
        
        if (currentX == 0.00 && direction == 180.00) {
            changeDirection();
            bounces += 1;
            turnVisible();
        }
       
    }
    
    public void turnVisible() {
        if (bounces % 5 == 0) {
            setVisible(true);
        }
    }
    
    public void setRandomPointValue() {
        pointValue = (int)(Math. random()*3 + 1) * 100;
    }
    
    public void changeDirection() {
        
        double holder1 = direction;
        double holder2 = lastDirection;
        
        setDirection(lastDirection);
        
        lastDirection = holder1;
        direction = holder2;
        this.setVisible(true);
    }
    
    
   
    
}
