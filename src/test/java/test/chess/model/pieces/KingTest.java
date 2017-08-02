package test.chess.model.pieces;

import static model.Constants.BLACK;
import static model.Constants.DOWN;
import static model.Constants.UP;
import static model.Constants.WHITE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static test.util.UtilTest.createIsHitableTestMatrix;
import static test.util.UtilTest.createIsPossibleHitablePlaceTestMatrix;
import static test.util.UtilTest.createIsStepableTestMatrix;
import static test.util.UtilTest.printExpectedAndActualArray;

import org.junit.Test;

import model.Board;
import model.Place;
import model.Player;
import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Piece;
import model.pieces.Rook;

public class KingTest {

	private Integer[][] table = null;
	private Integer[][] expected = null;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece king;
	private Player p1 = new Player("player1", WHITE, board);
	private Player p2 = new Player("player2", BLACK, board);
	
	@Test
	public void isHitable() {
		this.board  = new Board();
		
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		Piece knight = new Knight(new Place(4, 4), BLACK);
		this.king    = new King(new Place(6, 7), WHITE);
//		knight.refreshLists(board);
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		p2.getPiecesOnBoard().add(knight);
		p2.getPiecesOnBoard().add(new Knight(new Place(4, 6), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		assertEquals(false, king.isHitable(p2, new Place(5, 6), board));
//		assertEquals(true,  king.isHitable(new Place(7, 6),  board));
		
		//#2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 24,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.expected =  new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  1,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Piece knight2 = new Knight(new Place(4, 4), BLACK);
		this.king    = new King(new Place(5, 3), WHITE);
//				knight.refreshLists(board);
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		p2.getPiecesOnBoard().add(knight2);
		p2.getPiecesOnBoard().add(new Knight(new Place(4, 6), BLACK));
		p2.getPiecesOnBoard().add(new Bishop(new Place(2, 6), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		this.actual = createIsHitableTestMatrix(p2, king, board);
		assertArrayEquals(expected, actual);
//		printExpectedAndActualArray(expected, actual);
		
		// #3
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.expected =  new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  1,  0,  1,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Piece knight3 = new Knight(new Place(4, 4), BLACK);
		this.king    = new King(new Place(5, 3), WHITE);
//		knight.refreshLists(board);
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		p2.getPiecesOnBoard().add(knight3);
		p2.getPiecesOnBoard().add(new Knight(new Place(4, 6), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		this.actual = createIsHitableTestMatrix(p2, king, board);
		assertArrayEquals(expected, actual);
//		printExpectedAndActualArray(expected, actual);
	}
	
	@Test
	public void isStepable() {
		this.board  = new Board();
		
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		this.expected =  new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  1,  0}, // 6
				{ 0,  0,  0,  0,  0,  1,  0,  1}  // 7
			};
		board.setBoard(table);
		this.king = new King(new Place(6, 7), WHITE);
		
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		p2.getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		p2.getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		
		actual = createIsStepableTestMatrix(p2, king, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
		
		// # 2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		this.expected =  new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  1,  0,  1,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  1,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.king = new King(new Place(5, 3), WHITE);
		
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		p2.getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		p2.getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		
		actual = createIsStepableTestMatrix(p2, king, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
		
		// # 2
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{26,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{22,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		this.expected =  new Integer[][] {
	        //    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  1,  0,  1,  0}, // 3
				{ 0,  0,  0,  0,  1,  1,  1,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		this.king = new King(new Place(5, 3), WHITE);
		
		p2.getPiecesOnBoard().clear();
		p2.getPiecesOnBoard().add(new Rook(new Place(0, 2), BLACK));
		p2.getPiecesOnBoard().add(new King(new Place(0, 0), BLACK));
		p2.refreshPiecesOnBoardLists(p1, board);
		
		p1.getPiecesOnBoard().clear();
		p1.getPiecesOnBoard().add(king);
		p1.refreshPiecesOnBoardLists(p2, board);
		
		actual = createIsStepableTestMatrix(p2, king, board);
		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	

	@Test
	public void isLogicalStepable() {
		// # 1
		this.table =  new Integer[][] {
	    //    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
			{21, 21, 21,  0,  0,  0, 16, 11}, // 1
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
			{ 0,  0,  0,  0,  0,  1,  0,  1}, // 1
			{ 0,  0,  0,  0,  0,  1,  1,  1}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		king = new King(new Place(6, 1), WHITE);
		actual = createIsPossibleHitablePlaceTestMatrix(king, board);
//		printExpectedAndActualArray(expected, actual);
		assertArrayEquals(expected, actual);
	}
	
}
