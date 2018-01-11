package cellularAutomation;
/**
 * 加载网格
 * @author wenzi
 *
 */
public class DefaultGrid {

	public DefaultGrid(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }
		
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell cell = field.get(i,j);
	        }
	    }
		
	}
	
}
