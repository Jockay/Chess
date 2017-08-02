package test.chess.model.pieces;

import static model.Constants.DOWN;
import static model.Constants.WHITE;
import static org.junit.Assert.assertArrayEquals;
import static test.util.UtilTest.*;

import org.junit.Test;

import model.Board;
import model.Place;
import model.pieces.Piece;
import model.pieces.Queen;

public class QueenTest {
	
	private Integer[][] table;
	private Integer[][] expected;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece queen;

	@Test
	public void isStepable() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 15,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 0
			{ 1,  1,  1,  1,  1,  1,  0,  1}, // 1
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 2
			{ 0,  0,  0,  0,  1,  0,  1,  0}, // 3
			{ 0,  0,  0,  1,  0,  0,  1,  0}, // 4
			{ 0,  0,  1,  0,  0,  0,  1,  0}, // 5
			{ 0,  1,  0,  0,  0,  0,  1,  0}, // 6
			{ 1,  0,  0,  0,  0,  0,  1,  0}  // 7
		};
		queen = new Queen(new Place(6, 1), WHITE);
		actual = createIsStepableTestMatrix(queen, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
		
		// #2 
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 15, 11}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 0
			{ 0,  0,  0,  1,  1,  1,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 2
			{ 0,  0,  0,  0,  1,  0,  1,  0}, // 3
			{ 0,  0,  0,  1,  0,  0,  0,  0}, // 4
			{ 0,  0,  1,  0,  0,  0,  0,  0}, // 5
			{ 0,  1,  0,  0,  0,  0,  0,  0}, // 6
			{ 1,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		queen = new Queen(new Place(6, 1), WHITE);
		actual = createIsStepableTestMatrix(queen, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
		
		// #3
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0, 24,  0,  0,  0,  0,  0, 24}, // 0
			{21, 21, 21,  0, 21,  0, 25, 11}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{23, 22,  0,  0, 15,  0, 21, 22}, // 3
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 4
			{ 0,  0, 11,  0,  0,  0, 11,  0}, // 5
			{ 0, 21,  0,  0, 11,  0,  0, 11}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  1,  1,  1,  0,  0}, // 2
			{ 0,  0,  1,  1,  0,  1,  0,  0}, // 3
			{ 0,  0,  0,  1,  1,  1,  0,  0}, // 4
			{ 0,  0,  0,  0,  1,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		queen = new Queen(new Place(4, 3), WHITE);
		actual = createIsStepableTestMatrix(queen, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isHitable() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 15,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		queen = new Queen(new Place(6, 1), WHITE);
		actual = createIsHitableTestMatrix(queen, board);
//			printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
		
		// #2 
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 15, 11}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  1,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		queen = new Queen(new Place(6, 1), WHITE);
		actual = createIsHitableTestMatrix(queen, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isPossibleHitablePlace() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 15, 11}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 0
			{ 0,  0,  1,  1,  1,  1,  0,  1}, // 1
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 2
			{ 0,  0,  0,  0,  1,  0,  1,  0}, // 3
			{ 0,  0,  0,  1,  0,  0,  1,  0}, // 4
			{ 0,  0,  1,  0,  0,  0,  0,  0}, // 5
			{ 0,  1,  0,  0,  0,  0,  0,  0}, // 6
			{ 1,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		queen = new Queen(new Place(6, 1), WHITE);
		actual = createIsPossibleHitablePlaceTestMatrix(queen, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}

}
