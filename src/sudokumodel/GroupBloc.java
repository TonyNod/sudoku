package sudokumodel;

public class GroupBloc extends Group{

	public GroupBloc(int blocNumber, Sudoku model) {
		super(blocNumber);
		int b = blocNumber%3 * 3;
		int a = blocNumber;
		System.out.println("blocNumber = " +blocNumber+" a = "+a+" b = "+b);
		for(int i = a ; i < a+3; i ++){
			for(int j = b ; j < b+3; j ++){
				System.out.println("i = " + i + " j = "+j);
			this.cells[i] = model.getCell(i,j);
			this.cells[i].setBloc(this);
		}
		}
		
		
	}
	
	
}
