package cellularAutomation;

public class GosperGliderGun {

	public GosperGliderGun(Field field) {
		
		for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                field.place(i, j, new Cell());
            }
        }

		for (int i = 0; i < field.getHEIGHT(); i++) {
	        for (int j = 0; j < field.getWIDTH(); j++) {
	            Cell [][] cell  = new Cell[field.getHEIGHT()][field.getWIDTH()];
	            cell[i][j]= field.get(i,j);
	            if ((i==15&&j==10) || (i==15&&j==11) || (i==16&&j==10)
	            		 || (i==16&&j==11) || (i==15&&j==19) || (i==15&&j==20)
	            		 || (i==16&&j==18) || (i==16&&j==20) || (i==17&&j==18)
	            		 || (i==17&&j==19) || (i==17&&j==26) || (i==17&&j==27)
	            		 || (i==18&&j==26) || (i==18&&j==28) || (i==19&&j==26)
	            		 || (i==15&&j==32) || (i==15&&j==33) || (i==14&&j==32)
	            		 || (i==14&&j==34) || (i==13&&j==33) || (i==13&&j==34)
	            		 || (i==14&&j==44) || (i==14&&j==45) || (i==13&&j==44)
	            		 || (i==13&&j==45) || (i==20&&j==45) || (i==20&&j==46)
	            		 || (i==21&&j==45) || (i==21&&j==47) || (i==22&&j==45)
	            		 || (i==25&&j==34) || (i==25&&j==35) || (i==25&&j==36)
	            		 || (i==26&&j==34) || (i==27&&j==35)) {
	                cell[i][j].reborn();
	            }
	        }
	    }
		
	}
}
