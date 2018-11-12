package sudokumodel;

public class GroupColumn extends Group{

	public GroupColumn(int columnNumber, Sudoku model) {
		super(columnNumber);
		for(int i = 0 ; i < this.cells.length; i ++){
			this.cells[i] = model.getCell(columnNumber,i);
			this.cells[i].setColumn(this);
		}
		
	}
	

}
