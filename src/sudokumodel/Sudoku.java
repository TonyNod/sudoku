package sudokumodel;

import java.util.ArrayList;

public class Sudoku implements SudokuModel{
	
	private boolean grilleinitialisee;
	private Cell[][] cells;
	private Group[] blocs;
	private Group[] column;
	private Group[] lines;
	private ArrayList<HintSolver> hints;
	
	public Sudoku(){
		this.cells = new Cell[9][9];
		this.blocs = new Group[9];
		this.lines = new Group[9];
		this.column = new Group[9];
		this.hints = new ArrayList<HintSolver>();
		this.grilleinitialisee = true;
	}

	@Override
	public void init(String grid) {
		
		
	}

	@Override
	public boolean isInit() {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public CellValue getCell(int x, int y) {
		// TODO Auto-generated method stub
		return null;
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
