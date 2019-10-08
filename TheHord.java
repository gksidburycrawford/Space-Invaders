/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;



/**
 *
 * @author geter
 */
public class TheHord  {
    
    private Alien[][] aliens;
    private double direction;
    private double lastDirection;
    private int numLiving;
    GameUtility util;
    private boolean atEdge;
    private ActionPane actionPane;
    private Image alienSprites;
    private int moveCounter;
    
    
    public TheHord() {
        
        moveCounter = 0;
        direction = 0.00;
        lastDirection = 180.00;
        
        /*
        actionPane = new ActionPane();
        actionPane.setPrefSize(250,100);
        actionPane.getChildren().remove(actionPane.getCmdCenter());
        */
        try {
            alienSprites = new Image( new FileInputStream("spritesheet.jpg"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
  //      initTheHord();
        /*
        aliens = new Alien[5][11];
        
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                aliens[i][o] = new Alien(getActionPane(), getAlienSprites(),1);
                aliens[i][o].setY((i * 40) + 40); // the extra 40 pixels leaves room for the Spaceship to fly.
                aliens[i][o].setX((o * 32));
                
                // just test code
                
            }
        }
        */
           
        new AnimationTimer() {
            @Override
            public void handle(long now) {
              
                     //   move();
            }
        }.start();
    }
     
    
    public void changeDirection() {
        
        double holder1 = direction;
        double holder2 = lastDirection;
        
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                
                aliens[i][o].setDirection(lastDirection);
               
            }
            
        }
       lastDirection = holder1;
       direction = holder2;
    }
    
    
    public void initTheHord() {
        int alienType = 0;
        actionPane = new ActionPane();
        actionPane.setPrefSize(250,100);
        actionPane.getChildren().remove(actionPane.getCmdCenter());
        aliens = new Alien[5][11];
        
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                if (i <= 1) {
                    alienType = 4;
                }
                if (i > 1 &&  i < 3) {
                    alienType = 2;
                }
                
                if (i == 4) {
                    alienType = 1;
                }
                aliens[i][o] = new Alien(getActionPane(), getAlienSprites(),alienType);
                aliens[i][o].setY((i * 40) + 40); // the extra 40 pixels leaves room for the Spaceship to fly.
                aliens[i][o].setX((o * 32));
                
                
                // just test code
                
            }
        }
        numLiving = 55;
        
    }
    
    public void resetTheHord() {
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                aliens[i][o] = new Alien(getActionPane(), getAlienSprites(),1);
                aliens[i][o].setY((i * 40) + 40); // the extra 40 pixels leaves room for the Spaceship to fly.
                aliens[i][o].setX((o * 32));
                aliens[i][o].setVisible(true);
            }
        }
    }
    
    public void moveDown() {
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                aliens[i][o].setY(aliens[i][o].getY() + 10);
            }
        }
    }  
    
    public boolean isDead() {
        if (numLiving == 0) {
            return true;
        }
        return false;
    }
    
    public void checkBounds() {

        
        
        if ((aliens[4][10].getX() == 550) && (aliens[4][10].getDirection() == 0.0)) {
            changeDirection();
            moveDown();
            System.out.println("moved");
            
        }
        
        if ((aliens[0][0].getX() == 2) && (aliens[0][0].getDirection() == 180.00)) {
            changeDirection();
            moveDown();
        
        }
    }
    
    public void move() {
        checkBounds();
        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 11; o++) {
                aliens[i][o].move();
                toggle();
            }
            
        }
        moveCounter += 1;
   
    }
    
    public void toggle() {
        if (moveCounter % 50 == 0) {
            for (int i = 0; i < 5; i++) {
                for (int o = 0; o < 11; o++) {
                    aliens[i][o].ToggleImage();
                
                }
            }
        }
    }
    
    
    
    public Alien getAlien(int row, int col) {
    
        return aliens[row][col];
    
    }

    /**
     * @return the aliens
     */
    public Alien[][] getAliens() {
        return aliens;
    }

    /**
     * @param aliens the aliens to set
     */
    public void setAliens(Alien[][] aliens) {
        this.aliens = aliens;
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * @return the lastDirection
     */
    public double getLastDirection() {
        return lastDirection;
    }

    /**
     * @param lastDirection the lastDirection to set
     */
    public void setLastDirection(double lastDirection) {
        this.lastDirection = lastDirection;
    }

    /**
     * @return the numLiving
     */
    public int getNumLiving() {
        return numLiving;
    }

    /**
     * @param numLiving the numLiving to set
     */
    public void setNumLiving(int numLiving) {
        this.numLiving = numLiving;
    }

    /**
     * @return the atEdge
     */
    public boolean isAtEdge() {
        return atEdge;
    }

    /**
     * @param atEdge the atEdge to set
     */
    public void setAtEdge(boolean atEdge) {
        this.atEdge = atEdge;
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

    /**
     * @return the alienSprites
     */
    public Image getAlienSprites() {
        return alienSprites;
    }

    /**
     * @param alienSprites the alienSprites to set
     */
    public void setAlienSprites(Image alienSprites) {
        this.alienSprites = alienSprites;
    }
    
}
