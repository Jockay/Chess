package test.chess.model.pieces;

import static model.Constants.*;
import static org.junit.Assert.*;
import static test.util.UtilTest.*;

import org.junit.Test;

import model.Board;
import model.Constants;
import model.Place;
import model.pieces.*;

public class KnightTest {
	
	private Integer[][] table = null;
	private Integer[][] expected = null;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece knight;
	
	@Test
	public void isHitAbleTest() {
		this.board =  new Board();
		
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0, 21,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{13,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.knight = new Knight(new Place(0, 7), WHITE);
		assertEquals(true, knight.isHitable(new Place(1, 5),  board));
		
		// # 2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 21,  0,  0,  0,  0,  0}, // 6
				{ 0, 13,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.knight = new Knight(new Place(1, 7), WHITE);
		assertEquals(false, knight.isHitable(new Place(2, 6),  board));
		
		// # 3
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 21, 0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0, 13,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.knight = new Knight(new Place(2, 7), WHITE);
		assertEquals(true, knight.isHitable(new Place(0, 6),  board));
		
		
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
				{ 0,  0, 13, 21, 21,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.knight = new Knight(new Place(2, 7), WHITE);
		assertEquals(false, knight.isHitable(new Place(3, 7),  board));
		
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
				{ 0,  0, 13,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.knight = new Knight(new Place(2, 7), WHITE);
		assertEquals(true, knight.isHitable(new Place(4, 6),  board));
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
			{ 0,  0,  0,  0,  1,  0,  0,  0}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  1,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		knight = new Knight(new Place(6, 1), WHITE);
		knight.refreshLists(board);
		knight.getPossibleHitables();
		knight.getStepables();
		knight.getHitables();
		actual = createIsPossibleHitablePlaceTestMatrix(knight, board);
		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
}
