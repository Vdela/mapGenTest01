package mapgentest01.map;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JPanel;

public class HeightTab {

    private Cell tab[][];
    private int sizeX;
    private int sizeY;

    public HeightTab(int sizeX, int sizeY) {
        // On remplit une matrice de Cell, appelée tab, aux dimensions données
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        tab = new Cell[this.sizeX][this.sizeY];
    }

    public void generateNoise() {
        int i, j;
        Random r = new Random();
        float height;

        for (i = 0; i < sizeX; i++) {
            for (j = 0; j < sizeY; j++) {
                height = r.nextFloat() % 1;
                tab[i][j] = new Cell(height);
            }
        }
    }

    public void generate() {
        int i, j;
        int x, y;
        float height;
        Random r = new Random();
        int sommet;

        for (i = 0; i < sizeX; i++) {
            for (j = 0; j < sizeY; j++) {
                tab[i][j] = new Cell();
            }
        }

        for (i = 0; i < ((sizeX * sizeY) / 1000) + 3; i++) {
            x = (Math.abs(r.nextInt())) % sizeX;
            y = (Math.abs(r.nextInt())) % sizeY;
            System.out.println("x : " + x);
            System.out.println("y : " + y);
            tab[x][y] = new Cell((float) (r.nextFloat() + 0.8) % 1);
        }

    }

    public void applyWater(float seaLevel) {
        int i, j;

        for (i = 0; i < sizeX; i++) {
            for (j = 0; j < sizeY; j++) {
                if (tab[i][j].getHeight() <= seaLevel) {
                    tab[i][j].setWater(true);
                } else {
                    tab[i][j].setWater(false);
                }
            }
        }
    }

    public BufferedImage convertToImage() {
        BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);

        int x, y;
        for (x = 0; x < sizeX; x++) {
            for (y = 0; y < sizeY; y++) {
                
                int greyHeight = (int) ((this.getCell(x, y).getHeight()) * 255);
                Color color = new Color(greyHeight, greyHeight, greyHeight);
                int rgb = color.getRGB();
                        
                if (this.getCell(x, y).isWater()) {
                    bufferedImage.setRGB(x, y, Color.BLUE.getRGB());
                } else {
                    bufferedImage.setRGB(x, y, rgb);
                }
            }
        }

        return bufferedImage;

    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Cell getCell(int x, int y) {
        return tab[x][y];
    }
}
