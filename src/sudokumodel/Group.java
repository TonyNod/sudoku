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
	
	
	
	
}
