package test.chess.model.pieces;

import static model.Constants.BLACK;
import static model.Constants.DOWN;
import static model.Constants.UP;
import static model.Constants.WHITE;
import static org.junit.Assert.*;
import static test.util.UtilTest.*;

import org.junit.Test;

import model.Board;
import model.Place;
import model.pieces.Pawn;
import model.pieces.Piece;

public class PawnTest {

	private Integer[][] table;
	private Integer[][] expected;
	private Integer[][] actual;
	private Board board = new Board();
	private Piece pawn;
	
	@Test
	public void isStepable() {
		this.actual = new Integer[8][8];
		
		// #1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		Piece pawn = new Pawn(new Place(6, 6), WHITE);
		actual = createIsStepableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #2
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 6), WHITE);
		pawn.setIsFirstMove(false);
		actual = createIsStepableTestMatrix(pawn, board); 
		assertArrayEquals(expected, actual);
		
		// #3
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 1
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
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 1), BLACK);
		actual = createIsStepableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #4
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 1
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
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 1), BLACK);
		pawn.setIsFirstMove(false);
		actual = createIsStepableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #5
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 6
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
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 6), WHITE);
		actual = createIsStepableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #6
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 4
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 5
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 6
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
		pawn = new Pawn(new Place(6, 6), WHITE);
		actual = createIsStepableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isHitable() {
		this.actual = new Integer[8][8];
		
		// #1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0, 21,  0, 21}, // 5
			{ 0,  0,  0,  0,  0,  0, 11,  0}, // 6
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
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		Piece pawn = new Pawn(new Place(6, 6), WHITE);
		actual = createIsHitableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #3
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 1
			{ 0,  0,  0,  0,  0, 11,  0,  0}, // 2
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
			{ 0,  0,  0,  0,  0,  1,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 1), BLACK);
		actual = createIsHitableTestMatrix(pawn, board);
		assertArrayEquals(expected, actual);
		
		// #4
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 1
			{ 0,  0,  0,  0,  0, 11,  0, 11}, // 2
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
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 1), BLACK);
		actual = createIsHitableTestMatrix(pawn, board);
//		System.out.println("test");
//		printMatrix(test);
//		System.out.println("expected");
//		printMatrix(expected);
		assertArrayEquals(expected, actual);
		assertEquals(true, pawn.isHitable(new Place(5, 2), board));
		assertEquals(true, pawn.isHitable(new Place(7, 2), board));
	}

	@Test
	public void isLogicalStepable() {
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 21,  0}, // 1
			{ 0,  0,  0,  0,  0, 11,  0, 11}, // 2
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
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		pawn = new Pawn(new Place(6, 1), BLACK);
		actual = createIsPossibleHitablePlaceTestMatrix(pawn, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
}
