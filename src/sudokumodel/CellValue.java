package sudokumodel;

import java.util.ArrayList;

/**
 * Interface d'accÃ¨s en lecture aux donnÃ©es des cellules du modÃ¨le pour l'application sudokuFX.
 * @author Didier Gillard
 */
public interface CellValue {
	
	/**
	 * indique si la cellule contient une valeur <b>initiale</b> autre que zÃ©ro
	 * @return vrai si la cellule contient une valeur initiale autre que zÃ©ro
	 */
	public boolean isInitialValue();
	
	/**
	 * accesseur Ã  la valeur mÃ©morisÃ©e par la cellule
	 * @return la valeur mÃ©morisÃ©e par cette cellule - zÃ©ro indique une cellule vide 
	 */
	public int getValue();
	
	/**
	 * permet la rÃ©cupÃ©ration des candidats possibles de cette cellule si elle est vide.<br>
	 * Si la cellule possÃ¨de une valeur, la mÃ©thode doit retourner une liste vide.
	 * @return la liste des candidats de cette cellule
	 */
	public ArrayList<Integer> getCandidates();
	
	/**
	 * indique si la valeur non initiale, contenue dans cette cellule, autre que zÃ©ro, est en conflit avec une valeur identique dans un des groupes de cette cellule : ligne, colonne ou bloc
	 * @return vrai si un conflit existe pour cette valeur
	 */
	public boolean isError();
}