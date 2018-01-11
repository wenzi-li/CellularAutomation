package cellularAutomation;

import javax.swing.*;

import java.awt.*;

/**
 * 窗口；
 * 画出网格；
 * 画出存活的细胞；
 */
public class View extends JPanel {

	private static final long serialVersionUID = -5258995676212660595L;
    private int SIZE = 20;   //每个细胞即格子的大小；
    private Field aField;  
    private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSIZE() {
		return SIZE;
	}

	public void setSIZE(int sIZE) {
		SIZE = sIZE;
	}



	public View(Field aField) {
        this.aField = aField; 
    }

    public void paintComponent(Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Font f = g.getFont();
        g.setFont(new Font("造字工房朗倩粗体", Font.PLAIN, 20));
        g.drawString(time, getPreferredSize().width - 30, getPreferredSize().height-5);
        g.setFont(f);
        for (int i = 0; i < aField.getHEIGHT(); i++) {
            for (int j = 0; j < aField.getWIDTH(); j++) {
                Cell cell = aField.get(i, j);
                if (cell != null) {
                    cell.draw(g2, j * SIZE, i * SIZE, SIZE);
                }
            }
        }
    }

    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000,
        		700);
    }

}
