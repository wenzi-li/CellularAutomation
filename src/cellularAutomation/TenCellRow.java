package cellularAutomation;

public class TenCellRow {

	public TenCellRow(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }

		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell [][] cell  = new Cell[field.getHEIGHT()][field.getWIDTH()];
	            cell[i][j]= field.get(i,j);
	            if ((i==15&&j==23) || (i==15&&j==24) || (i==15&&j==25)
	            		 || (i==15&&j==26) || (i==15&&j==27) || (i==15&&j==28)
	            		 || (i==15&&j==29) || (i==15&&j==30) || (i==15&&j==31)
	            		 || (i==15&&j==32)) {
	                cell[i][j].reborn();
	            }
	        }
	    }
		
	}
}
