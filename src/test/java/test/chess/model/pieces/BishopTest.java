package test.chess.model.pieces;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static test.util.UtilTest.*;
import static model.Constants.*;

import org.junit.Test;

import model.Board;
import model.Place;
import model.pieces.Bishop;
import model.pieces.Piece;

public class BishopTest {
	
	private Integer[][] table;
	private Integer[][] expected;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece bishop;
	
	@Test
	public void isHitable() {
		this.bishop = new Bishop(new Place(6, 7), WHITE);
		
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{21,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 14,  0}  // 7
			};
		board.setBoard(table);
		assertEquals(true, bishop.isHitable(new Place(0, 1),  board));
		
		// #2  - array
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0, 21,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0, 24,  0,  0,  0, 24,  0}, // 1
			{ 0,  0,  0, 23,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0, 14,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0, 21,  0,  0,  0, 11,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0, 21}, // 6
			{22,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 1
			{ 0,  0,  0,  1,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  1,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		bishop = new Bishop(new Place(4, 3), WHITE);
		actual = createIsHitableTestMatrix(bishop, board);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isStepable() {
		this.board  = new Board();
		this.bishop = new Bishop(new Place(6, 7), WHITE);
		
		// # 1
		this.table =  new Integer[][] {
		    //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0, 14,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0, 11,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
			board.setBoard(table);
			this.expected = new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  1,  0,  1}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  1,  0,  1}, // 2
				{ 0,  0,  0,  0,  1,  0,  0,  0}, // 3
				{ 0,  0,  0,  1,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
			bishop = new Bishop(new Place(6, 1), WHITE);
			actual = createIsStepableTestMatrix(bishop, board);
			assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isPossibleHitablePlace() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0, 14,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0, 11,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		this.expected = new Integer[][] {
        //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 2
			{ 0,  0,  0,  0,  1,  0,  0,  0}, // 3
			{ 0,  0,  0,  1,  0,  0,  0,  0}, // 4
			{ 0,  0,  1,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		bishop = new Bishop(new Place(6, 1), WHITE);
		actual = createIsPossibleHitablePlaceTestMatrix(bishop, board);
		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
}
