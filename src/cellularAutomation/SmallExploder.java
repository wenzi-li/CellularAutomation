package cellularAutomation;
/**
 * 初始化一个Small Exploder 模型；
 * @author wenzi
 *
 */
public class SmallExploder {

	public SmallExploder(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }

		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell [][] cell  = new Cell[field.getHEIGHT()][field.getWIDTH()];
	            cell[i][j]= field.get(i,j);
	            if ((i==15&&j==25) || (i==16&&j==24) || (i==16&&j==25)
	            		 || (i==16&&j==26) || (i==17&&j==24) || (i==17&&j==26)
	            		 || (i==18&&j==25)) {
	                cell[i][j].reborn();
	            }
	        }
	    }
		
	}
}
