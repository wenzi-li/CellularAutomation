package cellularAutomation;
/**
 * 初识化一个“滑翔者”模型；
 * @author wenzi
 *
 */
public class Glider {

	public Glider(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }

		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell [][] cell  = new Cell[field.getHEIGHT()][field.getWIDTH()];
	            cell[i][j]= field.get(i,j);
	            if ((i==15&&j==25) || (i==16&&j==26) || (i==17&&j==24)
	            		 || (i==17&&j==25) || (i==17&&j==26)) {
	                cell[i][j].reborn();
	            }
	        }
	    }
	}
}
