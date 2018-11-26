package sudokumodel;

import java.util.ArrayList;

public class Cell implements CellValue {
	
	private int value;
	private boolean initialValue;
	private boolean[] candidates;
	private Group line;
	private Group column;
	private Group bloc;
	
	
	public Cell(){
		this.value = 0;
		this.initialValue = false;
		this.candidates = new boolean[9];
		for(int i = 0 ; i < this.candidates.length; i++){
			this.candidates[i] = true;
		}
		
	}
	
	public void setInitialValue(int value){
		this.value = value;
	}


	/**
	 * @return the line
	 */
	public Group getLine() {
		return line;
	}

	/**
	 * @return the column
	 */
	public Group getColumn() {
		return column;
	}

	/**
	 * @return the bloc
	 */
	public Group getBloc() {
		return bloc;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Group line) {
		this.line = line;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(Group column) {
		this.column = column;
	}

	/**
	 * @param bloc the bloc to set
	 */
	public void setBloc(Group bloc) {
		this.bloc = bloc;
	}

	@Override
	public boolean isInitialValue() {
		return this.initialValue;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public ArrayList<Integer> getCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isError() {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	

}
