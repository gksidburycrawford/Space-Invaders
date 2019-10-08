/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import java.awt.event.ActionListener;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author geter
 */
public class GamePane extends BorderPane  {
    
    private ActionPane aPane;
    private CmdCenter cmdCenter;
    private Spaceship spaceShip;
    private Projectile projectile;
    private TheHord theHord;
    private ControlPane control;
    private StatusPane status;
    GameUtility util;
    CmdCenterHandler cch;
    
    private long previous = 0;
    boolean shipCollision = false;
    boolean alienCollision = false;
    boolean cmdCenterCollision = false;
    private boolean isWaiting = false;
    private long spawnTime;
    private Random generator = new Random();
    private int timesHordDied = 0;
    
    
  

    
    public GamePane() {
        
        
        super();
        aPane = new ActionPane();
        control = new ControlPane();
        status = new StatusPane();
        spaceShip = aPane.getSpaceShip();
        cmdCenter = aPane.getCmdCenter();
        theHord = aPane.getTheHord();
        theHord.initTheHord();
        cch = new CmdCenterHandler();
        projectile = new Projectile(getaPane());
        aPane.getChildren().add(spaceShip);
        this.setTop(status);
        this.setCenter(aPane);
        this.setBottom(control);
        this.getChildren().add(theHord.getActionPane());
        cmdCenter.setProjectile(projectile);
        cmdCenter.setOnKeyPressed(cch);
        
        new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                cmdCenter.requestFocus();
                for (int i = 0; i < 5; i++) {
                    for (int o = 0; o < 11; o++) {
                        collisionTest(cmdCenter.getProjectile(),theHord.getAlien(i,o));
                       
                    }
                }
                
                if (theHord.isDead()) {
                    timesHordDied += 1;
                    resetTheHord();
                    for (int i = 0; i < timesHordDied; i ++) {
                        theHord.moveDown();
                    }
                }
                
                theHord.move();
                if (!isWaiting) {
                    spawnTime = (long)(now + (generator.nextInt(20) + 5) * Math.pow(18, 9));
                    isWaiting = true;
                }
                
                if (isWaiting && now >= spawnTime) {
                    getSpaceShip().setVisible(true);
                    int directionChooser = generator.nextInt(20);
                    int direction;
                    switch (directionChooser) {
                        case 1:
                            spaceShip.setDirection(180);
                            spaceShip.setX(550);
                            break;
                        default:
                            spaceShip.setDirection(0.0);
                            spaceShip.setX(0.0);
                            break;
                    }
                    
                    isWaiting = false;
                }
                
                if((now - previous >= 25000000L) && spaceShip.isVisible()) {
                    collisionTest(cmdCenter.getProjectile(),spaceShip);
                    spaceShip.move();
                    spaceShip.checkBounds();
                    previous = now;
                }
                
                
            }
            
        }.start();
        
        control.getResetTheGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e) {
                resetTheHord();
                status.resetPoints();
               
            }
        });
        
        control.getExitTheGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e) {
                System.exit(0);
            }
        });
 
    }
    
    public void resetTheHord() {
        getChildren().remove(theHord.getActionPane());
         theHord.initTheHord();
         getChildren().add((theHord.getActionPane()));
    }
    
    public void addGameObject(GameObject go) {
        this.getChildren().add(go);
    }
    
    public void collisionTest(Projectile prj, Invader ship) {
       boolean isTrue = util.detectCollision(cmdCenter.getProjectile(),ship);
       if(isTrue) {
           prj.setVisible(false);
           ship.setVisible(false);
           prj.setSpeed(0);
           prj.setX(cmdCenter.getX());
           prj.setY(cmdCenter.getY());
           theHord.setNumLiving(theHord.getNumLiving() - 1);
           status.setNumPoints(status.getNumPoints() + ship.getPointValue());
           status.setNumAliens(theHord.getNumLiving());
           status.updatePoints();
           this.setTop(status);
       }
    }


    
    public class CmdCenterHandler implements EventHandler<KeyEvent> {
    
        @Override
        public void handle(KeyEvent e) {
            cmdCenter.setOnKeyPressed(this);
            if(null != e.getCode()) switch (e.getCode()) {
                case LEFT:
                    cmdCenter.setDirection(180);
                    cmdCenter.move();
                    break;
                case RIGHT:
                    cmdCenter.setDirection(0);
                    cmdCenter.move();
                    break;
                case SPACE:
                    
                    cmdCenter.getProjectile().setDirection(270.00);
                    cmdCenter.fireProjectile();
                default:
                    break;
            }
            
        }
        
        
        
        
    };

    /**
     * @return the aPane
     */
    public ActionPane getaPane() {
        return aPane;
    }

    /**
     * @param aPane the aPane to set
     */
    public void setaPane(ActionPane aPane) {
        this.aPane = aPane;
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
    
   
        
        
}
    
    
   
