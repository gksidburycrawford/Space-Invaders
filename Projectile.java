/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author geter
 */
public class Projectile extends GameObject {
    
    private ActionPane actionPane;
    
    public Projectile(ActionPane aPane) {
        this.setVisible(false);
        
        try {
            Image image;;
            image = new Image( new FileInputStream("spritesheet.jpg"));
            this.setImage(image);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
        //location of the top-left corner and the width and the height.
        Rectangle2D viewportRect = new Rectangle2D(328,220,7,12);
       // (169, 49, 16, 30)
        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(2.0);
        this.setScaleY(2.0);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(aPane.getPrefWidth());
        
        setParentHeight(aPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(250);
        this.setY(560);
        
        aPane.getChildren().add(this);
        
        
        // just test code
        new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                move();
            }

        }.start();
    }
        
    
    public void move() {
        
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()) );
        this.setX( newX );
        this.setY( newY );
        

        
    }

    /**
     * @return the actionPane
     */
    public ActionPane getActionPane() {
        return actionPane;
    }

    /**
     * @param actionPane the actionPane to set
     */
    public void setActionPane(ActionPane actionPane) {
        this.actionPane = actionPane;
    }
    
}
