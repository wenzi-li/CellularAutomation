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
        
        new Random(field);
        
        switch (menu.getComboValue()) {
		case "Glider":
			//frame.repaint();
			new Glider(field);
			break;
		case "Small Exploder":
			//frame.repaint();
			new SmallExploder(field);
			break;
		case "Exploder":
			//frame.repaint();
			new Exploder(field);
			break;
		case "10 Cell Row":
			//frame.repaint();
			new TenCellRow(field);
			break;
		case " Gosper Glider Gun":
			//frame.repaint();
			new GosperGliderGun(field);
			break;

		default: new Random(field);
			break;
		}
        
        
        frame.add(menu, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cellular Automation");
        frame.setLocation(300,50);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
        
        
        
        

        for (int i = 0; i < 1000; i++) {
            if (i == 0)
                System.out.print("\n初始化状态\n\n");
            else
                System.out.printf("\n第%02d次迭代\n\n",i);


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
                    System.out.printf("[%02d][%02d]号-->", x, y);
                    System.out.print((cell[x][y].isAlive() ? "健康" : "死亡") + "-->");
                    System.out.print("周围存活数量：" + num[x][y] + " -->下一轮状态-->");
                    if (cell[x][y].isAlive()) {
                        if (num[x][y] < 2 || num[x][y] > 3) {
                            cell[x][y].die();
                            System.out.print("死亡");
                        }else
                            System.out.print("健康");
                    } else if (num[x][y] == 3) {
                        cell[x][y].reborn();
                        System.out.print("重生");
                    }
                    System.out.println();
                    
                }
            }
 
            //点击clear按钮；
            if (menu.getClear() == 0) {
            	field.clear();

                switch (menu.getComboValue()) {
        		case "Glider":
       			new Thread(new Runnable() {
						@Override
						public void run() {
						new Glider(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		case "Small Exploder":
        			new Thread(new Runnable() {
						@Override
						public void run() {
							new SmallExploder(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		case "Exploder":
        			new Thread(new Runnable() {
						@Override
						public void run() {
							new Exploder(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		case "10 Cell Row":
        			new Thread(new Runnable() {
						@Override
						public void run() {
							new TenCellRow(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		case " Gosper Glider Gun":
        			new Thread(new Runnable() {
						@Override
						public void run() {
							new GosperGliderGun(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		default: 
	        		new Thread(new Runnable() {
						@Override
						public void run() {
							new Random(field);
							menu.setClear(1);
						}
					}).start();
        			break;
        		}
            	
            }else {
            	
            }
            
            //点击stop按钮；
            if (menu.getStopOrStart() == 0) {
            	
            }else {
            	 frame.repaint();
			} 
            try {
                Thread.sleep(2000 - menu.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
}
