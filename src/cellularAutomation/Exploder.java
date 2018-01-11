package cellularAutomation;

public class Exploder {

	public Exploder(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }

		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell [][] cell  = new Cell[field.getHEIGHT()][field.getWIDTH()];
	            cell[i][j]= field.get(i,j);
	            if ((i==15&&j==25) || (i==15&&j==27) || (i==15&&j==29)
	            		 || (i==16&&j==25) || (i==16&&j==29) || (i==17&&j==25)
	            		 || (i==17&&j==29) || (i==18&&j==25) || (i==18&&j==29)
	            		 || (i==19&&j==25) || (i==19&&j==27) || (i==19&&j==29)) {
	                cell[i][j].reborn();
	            }
	        }
	    }
		
	}
}
