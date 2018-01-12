package cellularAutomation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyMenu extends JPanel {
	private static final long serialVersionUID = -5258995676212660595L;
	private View v;
	private JPanel panel;
	private int speed;     //sleep时长；
	private int stopOrStart =0 ;   //开始和暂停，1表示开始，0表示暂停；
	private int clear =1 ;   //开始和暂停，0表示清屏；
	private String comboValue = null ;   //组合框内的字符；

	public String getComboValue() {
		return comboValue;
	}


	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
	}


	public int getClear() {
		return clear;
	}


	public void setClear(int clear) {
		this.clear = clear;
	}


	public int getStopOrStart() {
		return stopOrStart;
	}


	public void setStopOrStart(int stopOrStart) {
		this.stopOrStart = stopOrStart;
	}

	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public MyMenu(View v) {
		this.v = v;

		setLayout(new BorderLayout());
        panel = new JPanel();
        addComboBox();
        Action clearAction1 = new buttonAction1("Clear", 0);
        Action startAction = new buttonAction("Start",1);
        Action stopAction = new buttonAction("Stop",0);
        InputMap buttonMap1 = panel.getInputMap(JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonMap1.put(KeyStroke.getKeyStroke("ctrl C"), "Clear");
        buttonMap1.put(KeyStroke.getKeyStroke("ctrl S"), "Start");
        buttonMap1.put(KeyStroke.getKeyStroke("ctrl P"), "Stop");
        
        ActionMap buttonMap2 = panel.getActionMap();
        buttonMap2.put("Clear", clearAction1);
        buttonMap2.put("Start", startAction);
        buttonMap2.put("Stop", stopAction);

        addButton(clearAction1);
        addButton(startAction);
        addButton(stopAction);
        addSlider1("src/images/speed_32px.png",0,1000,500);
        addSlider2("src/images/resize_32px.png",5,30,20);
        addLabel();
        add(panel, BorderLayout.SOUTH);
        
	}
	
	
	private void addLabel() {
		JLabel textLabel = new JLabel();
		textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textLabel.setText("时间");
		textLabel.repaint();
		panel.add(textLabel);
	}
	

	//运动速度滑动条；
	private void addSlider1 (String path,int x, int y, int z) {
		   
    	JSlider slider = new JSlider(x, y, z);
    	ImageIcon icon = new ImageIcon(path);
    	JLabel label = new JLabel(icon);
    	panel.add(label);
    	panel.add(slider);
    	slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setSpeed(slider.getValue());
			}
		});
    }
	
	//网格大小滑动条；
	private void addSlider2 (String path,int x, int y, int z) {
		   
    	JSlider slider = new JSlider(x, y, z);
    	ImageIcon icon = new ImageIcon(path);
    	JLabel label = new JLabel(icon);
    	panel.add(label);
    	panel.add(slider);
    	slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				v.setSIZE(slider.getValue()) ;
				v.setLocation(-slider.getValue(), -slider.getValue());
			}
		});
    }
	
     //组合框
    private void addComboBox() {
        JComboBox<String> specialCombo= new JComboBox<String>();
        specialCombo.addItemListener(event -> 
        			setComboValue(specialCombo.getItemAt(specialCombo.getSelectedIndex())));
        specialCombo.setBackground(Color.WHITE);
        specialCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        specialCombo.addItem("RandomCells");
        specialCombo.addItem("Glider");
        specialCombo.addItem("Small Exploder");
        specialCombo.addItem("Exploder");
        specialCombo.addItem("10 Cell Row");
        specialCombo.addItem("Gosper Glider Gun");
        panel.add(specialCombo);
    }
    
    //添加清理按钮
    private void addButton(Action action) {
    	JButton button = new JButton(action);
    	button.setBackground(Color.WHITE);
    	button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
    	panel.add(button);
    }

    
    //监听清理按钮；
    public class buttonAction1 extends AbstractAction{
    	/**
    	 * 点击按钮或按下快捷键同时响应动作；
    	 */
    	private static final long serialVersionUID = -5258995676212660595L;
    	
    	public buttonAction1 (String name, int c) {
    		putValue(Action.NAME, name);
    		putValue(Action.SHORT_DESCRIPTION, name.toLowerCase());
    		putValue("clear", c);
    	}
    	
    	public void actionPerformed(ActionEvent event) {
    		int c =(int) getValue("clear");
    		setClear(c);
    	}
    }
    
    
    
    
    //监听开始、暂停按钮；
    public class buttonAction extends AbstractAction{
    	/**
    	 * 点击按钮或按下快捷键同时响应动作；
    	 */
    	private static final long serialVersionUID = -5258995676212660595L;
    	public buttonAction (String name, int s) {
    		putValue(Action.NAME, name);
    		putValue(Action.SHORT_DESCRIPTION, name.toLowerCase());
    		putValue("stopOrStart", s);
    	}
    	
    	public void actionPerformed(ActionEvent event) {
    		int s =(int) getValue("stopOrStart");
    		setStopOrStart(s);
    		
    	}
    }
    
}
