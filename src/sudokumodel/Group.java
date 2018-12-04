package sudokumodel;

public class Group {
	
	protected Cell[] cells;
	private int groupNumber;
	/**
	 * @param cells
	 * @param groupNumber
	 */
	public Group( int groupNumber) {
		this.cells = new Cell[9];
		this.groupNumber = groupNumber;
	}
	/**
	 * @return the cells
	 */
	public Cell getCells(int cellNumber){
		return cells[cellNumber];
	}
	/**
	 * @return the groupNumber
	 */
	public int getGroupNumber() {
		return groupNumber;
	}
	
	public boolean checkError(int value){
/*
 		boolean res = false;
		for(int i = 0 ; i < this.cells.length; i++){
			if(value == this.cells[i].getValue())res = true;
		}
		return res;
*/
 		int cpt = 0;
		for(int i = 0 ; i < this.cells.length; i++){
			if(value == this.cells[i].getValue())cpt++;
		}
		return cpt>1;
	}
	
	
	
	
	
}
