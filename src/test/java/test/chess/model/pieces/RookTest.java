package test.chess.model.pieces;

import static model.Constants.*;
import static org.junit.Assert.*;
import static test.util.UtilTest.*;

import org.junit.Test;

import model.*;
import model.pieces.*;

public class RookTest {

	private Integer[][] table = null;
	private Integer[][] expected = null;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece rook;
	
	@Test
	public void isHitAbleTestNoPieceOnPath() {
		this.board =  new Board();
		this.rook = new Rook(new Place(0, 7), WHITE);
		
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
				{12,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		assertEquals(true, rook.isHitable(new Place(0, 1),  board));
		
		// # 2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{21,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0, 12,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(1, 7), WHITE);
		assertEquals(false, rook.isHitable(new Place(0, 1),  board));
		
		// # 3
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0, 12,  0, 21,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(2, 7), WHITE);
		assertEquals(true, rook.isHitable(new Place(4, 7),  board));
		
		
		// # 4
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0, 12, 21, 21,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(2, 7), WHITE);
		assertEquals(true, rook.isHitable(new Place(3, 7),  board));
		
		// # 5
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0, 21,  0,  0,  0}, // 6
				{ 0,  0, 12,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(2, 7), WHITE);
		assertEquals(false, rook.isHitable(new Place(4, 6),  board));
	}
	
	@Test
	public void isHitAbleTestWithPieceOnPath() {
		this.board =  new Board();
		this.rook = new Rook(new Place(0, 7), WHITE);
		
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{21,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{11,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{12,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		assertEquals(false, rook.isHitable(new Place(0, 1),  board));
		
		// # 2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0, 12, 21, 21,  0,  0, 21}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(2, 7), WHITE);
		assertEquals(false, rook.isHitable(new Place(7, 7),  board));
		
		// # 3
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0, 12, 21, 21,  0,  0, 21}  // 7
			};
		board.setBoard(table);
		this.rook = new Rook(new Place(2, 7), WHITE);
		assertEquals(false, rook.isHitable(new Place(4, 7),  board));
	}

	@Test
	public void isPossibleHitablePlace() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 14, 11}, // 1
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
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 0
			{ 0,  0,  1,  1,  1,  1,  0,  1}, // 1
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		rook = new Rook(new Place(6, 1), WHITE);
		actual = createIsPossibleHitablePlaceTestMatrix(rook, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void isStepable() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 14, 11}, // 1
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
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 0
			{ 0,  0,  0,  1,  1,  1,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  1,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		rook = new Rook(new Place(6, 1), WHITE);
		actual = createIsStepableTestMatrix(rook, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
}
