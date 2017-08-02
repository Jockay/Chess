package test.util;

import model.Board;
import model.Place;
import model.Player;
import model.pieces.Piece;

public class UtilTest {
	
	public static void printMatrix(Integer[][] matrix) {
		for(int i = 0; i < 8; i++) {
			System.out.print("{ ");
			for(int j = 0; j < 8; j++) {
				if(j != 7 ) {
					System.out.printf("%2d, ", matrix[i][j]);
				} else {
					System.out.printf("%2d", matrix[i][j]);
				}
			}
			System.out.print(" }\n");
		}
	}
	
	public static void printExpectedAndActualArray(Integer[][] expected, Integer[][] actual) {
		System.out.println("actual");
		printMatrix(actual);
		System.out.println("expected");
		printMatrix(expected);
	}
	
	public static Integer[][] createIsStepableTestMatrix(Piece piece, Board board) {
		Integer[][] test = new Integer[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(piece.isStepable(new Place(i, j),  board)) {
					test[j][i] = 1;
				} else {
					test[j][i] = 0;
				}
			}
		}
		
		return test;
	}
	
	public static Integer[][] createIsStepableTestMatrix(Player notActual, Piece piece, Board board) {
		Integer[][] test = new Integer[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(piece.isStepable(notActual, new Place(i, j),  board)) {
					test[j][i] = 1;
				} else {
					test[j][i] = 0;
				}
			}
		}
		
		return test;
	}
	
	public static Integer[][] createIsHitableTestMatrix(Piece piece, Board board) {
		Integer[][] test = new Integer[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(piece.isHitable(new Place(i, j),  board)) {
					test[j][i] = 1;
				} else {
					test[j][i] = 0;
				}
			}
		}
		
		return test;
	}
	
	public static Integer[][] createIsHitableTestMatrix(Player notActual, Piece piece, Board board) {
		Integer[][] test = new Integer[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(piece.isHitable(notActual, new Place(i, j),  board)) {
					test[j][i] = 1;
				} else {
					test[j][i] = 0;
				}
			}
		}
		
		return test;
	}
	
	public static Integer[][] createIsPossibleHitablePlaceTestMatrix(Piece piece, Board board) {
		Integer[][] test = new Integer[8][8];
		Place place = piece.getPosition();
		Place actualPlace = null;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				actualPlace = new Place(i, j);
				if(actualPlace.equals(place)) {
					test[j][i] = 0;
					continue;
				}
				if( piece.isPossibleHitablePlace(actualPlace,  board)) {
					test[j][i] = 1;
				} else {
					test[j][i] = 0;
				}
			}
		}
		
		return test;
	}
	
}
