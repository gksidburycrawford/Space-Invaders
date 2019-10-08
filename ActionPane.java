/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author geter
 */
public class ActionPane extends Pane {
    
    private CmdCenter cmdCenter;
    private Spaceship spaceShip;
 //   private Image spriteSheet;
    private TheHord theHord;

    
    
    
    
    
    public ActionPane() {
        

        theHord = new TheHord();
        spaceShip = new Spaceship();
        cmdCenter = new CmdCenter(this);
        
        
        this.setPrefSize(550,600);
        
        this.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
        
    
        
    }

    
    /**
     * @return the cmdCenter
     */
    public CmdCenter getCmdCenter() {
        return cmdCenter;
    }

    /**
     * @param cmdCenter the cmdCenter to set
     */
    public void setCmdCenter(CmdCenter cmdCenter) {
        this.cmdCenter = cmdCenter;
    }

  
    /**
     * @return the spriteSheet
     */
    /*
    public Image getSpriteSheet() {
        return spriteSheet;
    }

    /**
     * @param spriteSheet the spriteSheet to set
     */
    /*
    public void setSpriteSheet(Image spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    /**
     * @return the theHord
     */
    
    /*
    public TheHord getTheHord() {
        return theHord;
    }

    /**
     * @param theHord the theHord to set
     */
    
    /*
    public void setTheHord(TheHord theHord) {
        this.theHord = theHord;
    }

    /**
     * @return the spaceShip
     */
    public Spaceship getSpaceShip() {
        return spaceShip;
    }

    /**
     * @param spaceShip the spaceShip to set
     */
    public void setSpaceShip(Spaceship spaceShip) {
        this.spaceShip = spaceShip;
    }

    /**
     * @return the theHord
     */
    public TheHord getTheHord() {
        return theHord;
    }

    /**
     * @param theHord the theHord to set
     */
    public void setTheHord(TheHord theHord) {
        this.theHord = theHord;
    }
    
}
