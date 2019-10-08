/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author geter
 */
public class ControlPane extends HBox {
    
    private Button resetTheGame;
    private Button startTheGame;
    private Button exitTheGame;
    
    public ControlPane() {
        resetTheGame = new Button ("Reset");
        startTheGame = new Button ("Start");
        exitTheGame = new Button ("Exit");
        
        
        this.getChildren().addAll(startTheGame,resetTheGame,exitTheGame);
    }

    /**
     * @return the resetTheGame
     */
    public Button getResetTheGame() {
        return resetTheGame;
    }

    /**
     * @param resetTheGame the resetTheGame to set
     */
    public void setResetTheGame(Button resetTheGame) {
        this.resetTheGame = resetTheGame;
    }

    /**
     * @return the startTheGame
     */
    public Button getStartTheGame() {
        return startTheGame;
    }

    /**
     * @param startTheGame the startTheGame to set
     */
    public void setStartTheGame(Button startTheGame) {
        this.startTheGame = startTheGame;
    }

    /**
     * @return the exitTheGame
     */
    public Button getExitTheGame() {
        return exitTheGame;
    }

    /**
     * @param exitTheGame the exitTheGame to set
     */
    public void setExitTheGame(Button exitTheGame) {
        this.exitTheGame = exitTheGame;
    }
    
}
