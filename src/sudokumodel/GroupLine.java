package sudokumodel;

public class GroupLine extends Group{

	public GroupLine(int lineNumber, Sudoku model) {
		super(lineNumber);
		for(int i = 0 ; i < this.cells.length; i ++){
			this.cells[i] = model.getCell(i, lineNumber);
			this.cells[i].setLine(this);
		}
		
	}
	

}
