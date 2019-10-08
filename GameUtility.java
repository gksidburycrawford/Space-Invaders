/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject3;

import javafx.geometry.Bounds;

/**
 *
 * @author geter
 */
public class GameUtility {
    
    private static boolean checkBounds( double val, double min, double max) {
        return (val >= min && val <= max);
        
    }
    
    public static boolean detectCollision(Projectile prj, Invader inv) {
        Bounds sb = inv.getBoundsInParent();
        if(inv.isVisible()) {
            if ((checkBounds(prj.getY(), sb.getMinY(), sb.getMaxY()) &&
                (checkBounds(prj.getX(), sb.getMinX(),sb.getMaxX())))) {
                return true;
            }
           
        }
        return false;
    }
    
    public void collisionTest(Projectile prj, Invader ship) {
       boolean isTrue = detectCollision(prj ,ship);
       if(isTrue) {
           prj.setVisible(false);
           ship.setVisible(false);
       }
    }

    
}
