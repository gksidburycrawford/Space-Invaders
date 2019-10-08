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
public class CmdCenter extends GameObject {
   // ActionPane actionPane = new ActionPane();
    
    private Projectile projectile;
    private ActionPane actionPane;
    
    

    
    
    public CmdCenter(ActionPane aPane) {
        actionPane = aPane;
        projectile = new Projectile(actionPane);
        this.setParentWidth(actionPane.getPrefWidth());
        this.setSpeed(30);
        
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
        Rectangle2D viewportRect = new Rectangle2D(217, 177, 30, 20);

        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(actionPane.getPrefWidth());
        
        setParentHeight(actionPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(250);
        this.setY(560);
        
        aPane.getChildren().add(this);

    }
    
    public void move() {
        
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()) );
        this.setX(newX);
        this.setY(newY);

        if (0 >= this.getX()) {
            this.setX(0);
        }
        else if (this.getX() > 550) {
            this.setX(550);
        }
    }
    
    
        
      

    /**
     * @return the projectile
     */
    public Projectile getProjectile() {
        return projectile;
    }

    /**
     * @param projectile the projectile to set
     */
    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }
    
    public void fireProjectile() {
            getProjectile().setVisible(true);
            getProjectile().setX(this.getX());
            getProjectile().setY(this.getY());
            getProjectile().setSpeed(20.0);
            getProjectile().move();
    }
    
    

    }
        
              
        
