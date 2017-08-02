package test.chess.model.pieces;

import static model.Constants.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import model.Board;

public class BoardTest {
	
	private Board board = new Board();
	private Integer[][] actual = new Integer[8][8];
	
	@Test
	public void boardtest() {
		this.actual = new Integer[][] {
			//			    0   1   2   3   4   5   6   7
			{22, 23, 24, 25, 26, 24, 23, 22}, // 0
			{21, 21, 21, 21, 21, 21, 21, 21}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{11, 11, 11, 11, 11, 11, 11, 11}, // 6
			{12, 13, 14, 15, 16, 14, 13, 12}  // 7
		};
		assertArrayEquals(actual, board.getBoard());
		
//		Board board2 = new Board();
//		this.actual = new Integer[][] {
////	    	  0   1   2   3   4   5   6   7
//			{12, 13, 14, 16, 15, 14, 13, 12},  // 0
//			{11, 11, 11, 11, 11, 11, 11, 11},  // 1
//			{ 0,  0,  0,  0,  0,  0,  0,  0},  // 2
//			{ 0,  0,  0,  0,  0,  0,  0,  0},  // 3
//			{ 0,  0,  0,  0,  0,  0,  0,  0},  // 4
//			{ 0,  0,  0,  0,  0,  0,  0,  0},  // 5
//			{21, 21, 21, 21, 21, 21, 21, 21},  // 6
//			{22, 23, 24, 26, 25, 24, 23, 22}   // 7
//		};
//		assertArrayEquals(actual, board2.getBoard());
	}

}

