package sudokumodel;

import java.util.ArrayList;
import java.util.Arrays;

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
		this.candidates = new boolean[10];
		for(int i = 0 ; i < this.candidates.length; i++){
			this.candidates[i] = true;
		}

	}

	public void setInitialValue(int value){
		this.value = value;
		if(value != 0)this.initialValue = true;
		for(int i = 0 ; i < this.candidates.length; i++){
			this.toggleCandidate(i);
		}
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
	 * @param btrueloc the bloc to set
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
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(this.value == 0){
			for( int i = 0 ; i < this.candidates.length ; i++){
				if(this.candidates[i]) res.add(i);
			}
		}
		return res;
	}

	@Override
	public boolean isError() {
		boolean res = false;
		if(!this.initialValue && this.value != 0){
			/*
			 	ancien code : 
			 	for(int i = 0 ; i < 9; i++){
				if(this.value == this.line.getCells(i).value) res = true;
				if(this.value == this.bloc.getCells(i).value) res = true;
				if(this.value == this.column.getCells(i).value) res = true;
			}
			 */
			res = line.checkError(value) || column.checkError(value) || bloc.checkError(value);
		}
		return res;
	}

	public boolean setValue(int value){
		boolean res = false;
		if(this.initialValue == false){
			this.value = value;
			if( value != 0 && this.candidates[value])this.toggleCandidate(value);
			res = true;
		}
		return res;
	}
	
	public void computeCandidates(){
		for( int i = 0 ; i < this.candidates.length ; i++){
			this.candidates[i] = false;
			if(this.line.isCandidate(i) && this.column.isCandidate(i) && this.bloc.isCandidate(i)){
				this.candidates[i] = true;
			}
		}
	}
	
	public void toggleCandidate(int digit){
		this.candidates[digit] = !this.candidates[digit];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cell [value=" + value + ", initialValue=" + initialValue + ", candidates=" + Arrays.toString(candidates)+ "]";
	}
	
	public void unsetCandidate(int value){
		this.candidates[value] = false;
	}




}
