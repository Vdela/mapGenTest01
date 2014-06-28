/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgentest01;

import mapgentest01.map.HeightTab;
import mapgentest01.affichage.MapWindow;

/**
 *
 * @author Vincent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Génération tableau final
        HeightTab heightTab = new HeightTab(800, 600);
        heightTab.generateNoise();
        heightTab.applyWater(0f);
        // Affichage tableau final
        MapWindow mapWindow = new MapWindow(heightTab);
        mapWindow.setVisible(true);
        
    }
}
