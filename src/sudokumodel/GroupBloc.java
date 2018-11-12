package sudokumodel;

public class GroupBloc extends Group{

	public GroupBloc(int blocNumber, Sudoku model) {
		super(blocNumber);
		for(int i = 0 ; i < this.cells.length; i ++){
			this.cells[i] = model.getCell(i,blocNumber);
			this.cells[i].setBloc(this);
		}
		
	}
	
	
}
