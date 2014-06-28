package mapgentest01.affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mapgentest01.map.HeightTab;

public class MapWindow extends JFrame {

    private JPanel window;
    private ImageMapPanel imageMapPanel;
    private JButton buttonGenerate;
    private int sizeX, sizeY;

    public MapWindow(final HeightTab heightTab) {

        this.sizeX = heightTab.getSizeX();
        this.sizeY = heightTab.getSizeY();

        this.setTitle("Noise Map");
        this.setSize(sizeX+20, sizeY+70);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window = new JPanel(new BorderLayout());
        this.add(window);

        buttonGenerate = new JButton("Generate");
        buttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightTab.generateNoise();
                displayMap(heightTab);
            }
        });
        
        window.add(buttonGenerate, BorderLayout.SOUTH);

        displayMap(heightTab);

    }

    final public void displayMap(final HeightTab heightTab) {
        if (imageMapPanel != null) window.remove(imageMapPanel);
        imageMapPanel = new ImageMapPanel(heightTab);
        window.add(imageMapPanel, BorderLayout.CENTER);
        revalidate();
    }
}
