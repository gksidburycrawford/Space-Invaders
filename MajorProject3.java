/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author geter
 */
public class MajorProject3 extends Application {
    
    private long previous = 0;
    boolean shipCollision = false;
    boolean alienCollision = false;
    boolean cmdCenterCollision = false;
    private boolean isWaiting = false;
    private long spawnTime;
    private Random generator = new Random();
    
    @Override
    public void start(Stage primaryStage) {
       
        // added test code
  //      TheHord theHord = new TheHord();
    //    ActionPane pane = theHord.getActionPane();
        GamePane root = new GamePane();
        root.setStyle("-fx-background-color: BLACK");
        
        Scene scene = new Scene(root, 570, 600);
   //     root.getChildren().add(pane);
        
        primaryStage.setTitle("Space Invaders!");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getCmdCenter().requestFocus();
        
        
        
        /*
        
        new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                root.getCmdCenter().getProjectile().move();
                
                
                if (!isWaiting) {
                    spawnTime = (long)(now + (generator.nextInt(20) + 5) * Math.pow(18, 9));
                    isWaiting = true;
                }
                
                if (isWaiting && now >= spawnTime) {
                    root.getSpaceShip().setVisible(true);
                    int directionChooser = generator.nextInt(20);
                    int direction;
                    switch (directionChooser) {
                        case 1:
                            root.getSpaceShip().setDirection(180);
                            root.getSpaceShip().setX(550);
                            break;
                        default:
                            root.getSpaceShip().setDirection(0.0);
                            root.getSpaceShip().setX(0.0);
                            break;
                    }
                    
                    isWaiting = false;
                }
                
                if((now - previous >= 25000000L) && root.getSpaceShip().isVisible()) {
                    root.getSpaceShip().move();
                    previous = now;
                }
                
                
            }
            
        }.start();
        
        */
        

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
