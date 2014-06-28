package mapgentest01.affichage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import mapgentest01.map.HeightTab;

public class ImageMapPanel extends JPanel {

    private BufferedImage bufferedImage;

    public ImageMapPanel(HeightTab heightTab) {
        try {
            bufferedImage = heightTab.convertToImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
        
//        Pour exporter l'image (repertoire source du projet)
        File outputfile = new File("image.gif");
        try {
            ImageIO.write(bufferedImage, "gif", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageMapPanel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}