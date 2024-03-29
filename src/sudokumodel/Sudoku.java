package sudokumodel;

import java.util.ArrayList;

public class Sudoku implements SudokuModel{

	private boolean grilleinitialisee;
	private Cell[][] cells;
	private Group[] blocs;
	private Group[] column;
	private Group[] lines;
	//private ArrayList<HintSolver> hints;

	public Sudoku(){
		this.cells = new Cell[9][9];
		this.blocs = new Group[9];
		this.lines = new Group[9];
		this.column = new Group[9];
		for(int i = 0 ; i < this.cells.length; i++){
			for(int j = 0; j< this.cells.length; j++){
				this.cells[i][j] = new Cell();
			}
		}

		for(int i = 0 ; i < this.cells.length; i++){
			this.blocs[i] = new GroupBloc(i, this);
			this.lines[i] = new GroupLine(i, this);
			this.column[i] = new GroupColumn(i, this);
		}

		//		this.hints = new ArrayList<HintSolver>();
		this.grilleinitialisee = false;
	}

	@Override
	public void init(String grid) {
		int compt = 0;
		for(int i = 0 ; i < this.cells.length ; i++){
			for(int j = 0 ; j < this.cells.length ; j++){
				int c = grid.charAt(compt);
				int v = c -'0';
				this.cells[i][j].setInitialValue(v);
				compt++;			
			}
		}
		this.grilleinitialisee = true;

	}

	@Override
	public boolean isInit() {
		return this.grilleinitialisee;
	}

	/**
	 * @return the blocs
	 */
	public Group[] getBlocs() {
		return blocs;
	}

	/**
	 * @return the column
	 */
	public Group[] getColumn() {
		return column;
	}

	/**
	 * @return the lines
	 */
	public Group[] getLines() {
		return lines;
	}

	@Override
	public boolean isFull() {
		boolean res = true;
		for(int i = 0 ; i < this.cells.length; i++){
			for(int j = 0 ; j < this.cells.length; j++){
				if(this.cells[i][j].getValue() == 0)res = false; 
			}
		}
		return res;
	}

	@Override
	public boolean isValide() {
		boolean res = true;
		for(int i = 0 ; i < this.cells.length; i++){
			for(int j = 0 ; j < this.cells.length; j++){
				if(this.cells[i][j].isError())res = false; 
			}
		}
		return res && this.isFull();
	}

	/*
	@Override
	public CellValue getCell(int x, int y) {
		return (CellValue)this.cells[x][y];
	}
	 */

	public Cell getCell(int x, int y){
		return this.cells[y][x];
	}

	public Cell getCell(int cellNumber){
		return this.cells[cellNumber/9][cellNumber%9];
	}

	@Override
	public boolean setValue(int value, int cellNumber) {
		return this.getCell(cellNumber).setValue(value);

	}

	@Override
	public void computeCandidates() {
		for(int i = 0 ; i < this.cells.length; i++){
			for(int j = 0 ; j < this.cells.length; j++){
				this.cells[i][j].computeCandidates();
			}
		}
	}

	@Override
	public void toggleCandidate(int digit, int cellNumber) {
		this.getCell(cellNumber).toggleCandidate(digit);
	}

	@Override
	public boolean solve() {
		boolean res = true;
		for(int i = 0 ; i < this.cells.length * this.cells.length; i++){
				if(!this.backtracking(i))res = false;
		}
		return res;
	}

	@Override
	public String hint() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean backtracking(int cellNumber){
		boolean res = true;
		if(cellNumber == 81) res = true;
		else{
			if(this.getCell(cellNumber).getValue() != 0) res =this.backtracking(cellNumber+1);
			else{
				this.getCell(cellNumber).computeCandidates();
				ArrayList<Integer> c = this.getCell(cellNumber).getCandidates();
				for(int i = 0 ; i  < c.size();i++){
					if(!res){
					this.getCell(cellNumber).setValue(c.get(i));
					res = this.backtracking(cellNumber+1);
					if(!res){
						this.getCell(cellNumber).clearValue();
					}
					}
					
				}
			}
		}
		return res;
	}

}
