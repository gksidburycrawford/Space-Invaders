/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.awt.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JLabel;

/**
 *
 * @author geter
 */
public class StatusPane extends HBox {
    
    private Label Score;
    private Label leftAlive;
    private int numPoints;
    private int numAliens;
    
    
    public StatusPane() {
        numPoints = 0;
        numAliens = 55;
        Score = new Label("Total Points: " +  getNumPoints() + "      ");
        leftAlive = new Label("Aliens Left: " + getNumAliens());
        Score.setTextFill(javafx.scene.paint.Color.WHITE);
        leftAlive.setTextFill(javafx.scene.paint.Color.GREEN);
        this.getChildren().addAll(Score,leftAlive);
   
    }

    /**
     * @return the numPoints
     */
    public int getNumPoints() {
        return numPoints;
    }
    
    public void updatePoints() {
        this.getChildren().remove(Score);
        this.getChildren().remove(leftAlive);
        Score = new Label("Total Points: " + getNumPoints() + "      ");
        Score.setTextFill(javafx.scene.paint.Color.WHITE);
        leftAlive = new Label("Aliens Left: " + getNumAliens());
        leftAlive.setTextFill(javafx.scene.paint.Color.GREEN);
        
        this.getChildren().addAll(Score,leftAlive);
    }
    
    public void resetPoints() {
        numPoints = 0;
        numAliens = 55;
        this.getChildren().remove(Score);
        this.getChildren().remove(leftAlive);
        
        Score = new Label("Total Points: " + numPoints + "      ");
        Score.setTextFill(javafx.scene.paint.Color.WHITE);
        leftAlive = new Label("Aliens Left: " + numAliens);
        leftAlive.setTextFill(javafx.scene.paint.Color.GREEN);
        this.getChildren().addAll(Score,leftAlive);
    }

    /**
     * @param numPoints the numPoints to set
     */
    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    /**
     * @return the numAliens
     */
    public int getNumAliens() {
        return numAliens;
    }

    /**
     * @param numAliens the numAliens to set
     */
    public void setNumAliens(int numAliens) {
        this.numAliens = numAliens;
    }
    
}
