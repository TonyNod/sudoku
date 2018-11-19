package sudokumodel;

import java.util.ArrayList;

public class Sudoku implements SudokuModel{
	
	private boolean grilleinitialisee;
	private Cell[][] cells;
	private Group[] blocs;
	private Group[] column;
	private Group[] lines;
//	private ArrayList<HintSolver> hints;
	
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
		for(int i = 0 ; i < this.cells.length ; i++){
			for(int j = 0  ; j < this.cells.length ; j++){
				
				//this.cells[i][j].setValue(grid.charAt(i * j)); 
			}
		}
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValide() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void computeCandidates() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggleCandidate(int digit, int cellNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String hint() {
		// TODO Auto-generated method stub
		return null;
	}

}
