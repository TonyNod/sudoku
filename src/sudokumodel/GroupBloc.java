package sudokumodel;

public class GroupBloc extends Group{

	public GroupBloc(int blocNumber, Sudoku model) {
		super(blocNumber);
		int a = blocNumber%3 * 3;
		int b = blocNumber/3 * 3;
		int compt = 0;
		for(int i = a ; i < a+3; i ++){
			for(int j = b ; j < b+3; j ++){
				this.cells[compt] = model.getCell(i,j);
				this.cells[compt].setBloc(this);
				compt++;
			}
		}
	}	
}
