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
public class Alien extends Invader {
    
    private int alienType;
    private Rectangle2D[] viewportRects = new Rectangle2D[2];
    private int currentImage;
    private ActionPane actionPane;
    
    public Alien(ActionPane actionPane, Image sprite, int aType) {
        setNormalSpeed();
        this.actionPane = actionPane;
        alienType = aType;
        this.setImage(sprite);
        
        setPointValue(alienType * 10);
        
        viewportRects[0] = new Rectangle2D(58, 177, 20, 16);
        viewportRects[1] = new Rectangle2D(85, 177, 20, 16);
        

        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRects[0]);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(actionPane.getPrefWidth());
        
        setParentHeight(actionPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(250);
        this.setY(100);
        
        actionPane.getChildren().add(this);

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
    
    public void setNormalSpeed() {
        this.setSpeed(1.0);
    }
    
    public void ToggleImage() {
        if (currentImage == 0) {
         this.setViewport(viewportRects[1]);
         currentImage = 1;
        } else {
            this.setViewport(viewportRects[0]);
            currentImage = 0;
        }
        
    }

    /**
     * @return the alienType
     */
    public int getAlienType() {
        return alienType;
    }

    /**
     * @param alienType the alienType to set
     */
    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }

    /**
     * @return the viewportRects
     */
    public Rectangle2D[] getViewportRects() {
        return viewportRects;
    }

    /**
     * @param viewportRects the viewportRects to set
     */
    public void setViewportRects(Rectangle2D[] viewportRects) {
        this.viewportRects = viewportRects;
    }

    /**
     * @return the currentImage
     */
    public int getCurrentImage() {
        return currentImage;
    }

    /**
     * @param currentImage the currentImage to set
     */
    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
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
