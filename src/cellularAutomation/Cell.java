package cellularAutomation;

import java.awt.*;

/**
 * 细胞类；
 * 如果细胞存活，在网格中画出；
 */
public class Cell {

    private boolean alive = false;       //细胞是否存活；

    public boolean isAlive() {
        return alive;
    }

    public void die(){            //细胞死亡；
        alive = false;
    }

    public void reborn(){          //细胞重生；
        alive = true;
    }

    public void draw(Graphics g, int x, int y, int size){
    	Graphics2D g2 = (Graphics2D)g;
    	Color c = g2.getColor();
    	g2.setColor(new Color(130, 130, 130));
        g2.drawRect(x, y, size, size);
        g2.setColor(c);
        if ( isAlive() ){
        	g2.setColor(new Color(67, 67, 67));
        	//g2.drawImage(new ImageIcon("src/cellularAutomation/pacman_24px.png").getImage(), x, y, null);
            g2.fillRect(x+1, y+1, size, size);
        }
    }
}
