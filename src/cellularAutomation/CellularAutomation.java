package cellularAutomation;

import java.awt.BorderLayout;


import javax.swing.*;

/**
 *细胞自动机测试；
 */
public class CellularAutomation {
	
    public static void main(String[] args) {
    	
    	long startTime = System.currentTimeMillis();           //记录程序开始时间；
        Field field = new Field(250,140);                      //创建网格；
        JFrame frame = new JFrame();
        View view = new View(field);                           //游戏视图；
        MyMenu menu = new MyMenu(view);                        //加载下方的功能键；
        new DefaultGrid(field);                                //记载网格；
        frame.add(menu, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cellular Automation");
        frame.setIconImage(new ImageIcon("src/images/cells_128px.png").getImage());
        frame.setLocation(300,50);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
        
        /*
         * 循环重画窗口，显示动态画面；
         */
        for (int i = 0; i < 10000; i++) {
            long endTime = System.currentTimeMillis();               //记录程序当前时间；
            view.setTime("" + (endTime - startTime)/1000 + "s");     //打印游戏时长；
            new GameLogic(field);                                    //加载游戏画面；
            
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
    				menu.setStopOrStart(1);
    				break;
    			case "Exploder":
    				new Exploder(field);
    				menu.setStopOrStart(1);
    				break;
    			case "10 Cell Row":
    				new TenCellRow(field);
    				menu.setStopOrStart(1);
    				break;
    			case "Gosper Glider Gun":
    				new GosperGliderGun(field);
    				menu.setStopOrStart(1);
    				break;
    			case "RandomCells":
    				new Random(field);
    				//menu.setStopOrStart(1);
    				break;
    			}
            	
            }else {
				view.repaint();
				try {
			         Thread.sleep(1000 - menu.getSpeed());
			          } catch (InterruptedException e) {
			                e.printStackTrace();
			          }
			} 
        } 
    }  
}
