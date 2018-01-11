package cellularAutomation;

import java.awt.BorderLayout;


import javax.swing.*;

/**
 *细胞自动机测试；
 */
public class CellularAutomation {
	
    public static void main(String[] args) {
    	//记录程序开始时间
    	long startTime = System.currentTimeMillis();
    	//创建网格
        Field field = new Field(250,140);

        JFrame frame = new JFrame();
        View view = new View(field);
        MyMenu menu = new MyMenu(view);
        
        new DefaultGrid(field);
 
        frame.add(menu, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cellular Automation");
        frame.setLocation(300,50);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
        

        for (int i = 0; i < 10000; i++) {

        	
            long endTime = System.currentTimeMillis();
            view.setTime("" + (endTime - startTime)/1000 + "s");

            int [][] num = new int [field.getHEIGHT()][field.getWIDTH()];        //每个细胞周围存活的细胞数；
            Cell [][] cell = new Cell [field.getHEIGHT()][field.getWIDTH()];     //每个细胞;

            for (int x = 0; x < field.getHEIGHT(); x++) {
                for (int y = 0; y < field.getWIDTH(); y++) {
                    int numOfLive = 0;
                    cell[x][y] = field.get(x,y);
                    Cell[] neighbour = field.getNeighbour(x,y);
                    for (Cell cell1 : neighbour) {
                        if ( cell1.isAlive()) {
                            numOfLive++;
                        }
                    }
                    num[x][y] = numOfLive;
                }
            }

            for (int x = 0; x < field.getHEIGHT(); x++) {
                for (int y = 0; y < field.getWIDTH(); y++) {

                    if (cell[x][y].isAlive()) {
                        if (num[x][y] < 2 || num[x][y] > 3) {
                            cell[x][y].die();
                            
                        }else{
                            
                        }
                    } else if (num[x][y] == 3) {
                        cell[x][y].reborn();
                       
                    }
                    
                }
            }
 
            
         //System.out.println(menu.getComboValue());
					
  
            //点击clear按钮；
            if (menu.getClear() == 0) {
            	field.clear();
            	
            }else {
            	
            }
            
            //点击stop按钮；
            if (menu.getStopOrStart() == 0) {
                /**
    	    	 * 组合框选择不同模型；
    	    	 */
    	        switch (menu.getComboValue()) {
    			case "Glider":
    				
    				new Glider(field);
    				menu.setStopOrStart(1);
    				
    				break;
    			case "Small Exploder":
    				new SmallExploder(field);
    				
    				break;
    			case "Exploder":
    				new Exploder(field);
    				
    				break;
    			case "10 Cell Row":
    				new TenCellRow(field);
    				
    				break;
    			case "Gosper Glider Gun":
    				new GosperGliderGun(field);
    				
    				break;
    			case "RandomCells":
    				new Random(field);
    				
    				break;
    			}
            	
            }else {
				frame.repaint();
				try {
			         Thread.sleep(1000 - menu.getSpeed());
			          } catch (InterruptedException e) {
			                e.printStackTrace();
			          }
			} 
        }
        
    }  
}
