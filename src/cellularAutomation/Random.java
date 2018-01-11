package cellularAutomation;
/**
 * 随机初始化;
 * 随机创建n个cells;
 * @author wenzi
 *
 */
public class Random {
	
	public Random(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }
		
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell cell = field.get(i,j);
	            if (Math.random() < 0.1) {
	                cell.reborn();
	            }
	        }
	    }
	}
}
