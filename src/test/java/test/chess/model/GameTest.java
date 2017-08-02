package test.chess.model;

import static model.Constants.WHITE;
import static model.Constants.BLACK;
import static model.Constants.PROMOTION_REQUIERED;
import static model.Constants.HIT_DONE;
import static model.Constants.STEP_DONE;
import static model.Constants.NO_PIECE_FOUND;
import static model.Constants.NOT_MOVEABLE;
import static model.Constants.CHECK;
import static model.Constants.DRAWN;
import static model.Constants.CHECKMATE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;                                           

import model.Board;
import model.Game;
import model.Place;
import model.Player;
import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Piece;
import model.pieces.Queen;
import model.pieces.Rook;
import test.util.UtilTest;

public class GameTest {
	
	private Integer[][] table = null;
	private Integer[][] expected = null;
	private Integer[][] actual = new Integer[8][8];
	private Board board = new Board();
	private Piece king;
	private Player p1 = new Player("player1", WHITE, board);
	private Player p2 = new Player("player2", BLACK, board);
	private Game game = new Game(board, p1, p2);
	
	@Test
	public void isCheck1() {
		this.board  = new Board();
		// # 1
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0, 26,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 21,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(1, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(6, 7), WHITE));
		game.refreshPiecesOnBoard();
		assertEquals(true, game.isCheck());
	}
	
	@Test
	public void isCheck2() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0, 26,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
//				game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(1, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(6, 7), WHITE));
		game.refreshPiecesOnBoard();
		assertEquals(false, game.isCheck());
	}
	
	@Test
	public void isCheck3() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
//				game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(6, 5), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(6, 7), WHITE));
		game.refreshPiecesOnBoard();
		assertEquals(true, game.isCheck());
	}
	
	@Test
	public void isCheckmate1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(6, 7), WHITE));
		game.refreshPiecesOnBoard();
		assertEquals(true, game.isCheckmate());
	}
	
	@Test
	public void isDrawn() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0, 16,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(6, 7), WHITE));
		game.refreshPiecesOnBoard();
		assertEquals(true, game.isDrawn());
	}
	
	@Test
	public void isDoHitAndRevert1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0, 16}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(7, 7), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		game.refreshPiecesOnBoard();
		Player p1Save = game.getP1();
		Player p2Save = game.getP2();
		Piece willHit     = game.searchPieceOnBoard(new Place(4, 4));
		Place lastPlace   = willHit.getPosition();
		Piece willHitSave = willHit;
		Piece toHit       = game.searchPieceOnBoard(new Place(3, 2));
		game.doHit(willHit, toHit.getPosition());
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 23,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0, 16}  // 7
			};
		assertArrayEquals(expectedTable, game.getBoard().getBoard());
		game.revertHit(lastPlace, willHit, toHit);
		expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
			{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0, 16}  // 7
		};
//		printExpectedAndActualArray(expectedTable, game.getBoard().getBoard());
		assertArrayEquals(expectedTable, game.getBoard().getBoard());
		assertEquals(p1Save, game.getP1());
		assertEquals(p2Save, game.getP2());
	}
	
//	@Test
//	public void isTryMoveCHECKMATE1() {
//		this.board  = new Board();
//		this.table = new Integer[][] {
//			//    0   1   2   3   4   5   6   7
//				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
//				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
//				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
//				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
//				{ 0,  0,  0,  0,  0,  0,  0, 16}  // 7
//			};
//		board.setBoard(table);
//		game.setBoard(board);
//		
//		game.getP2().getPiecesOnBoard().clear();
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
//		
//		game.getP1().getPiecesOnBoard().clear();
//		game.getP1().getPiecesOnBoard().add(new King(new Place(7, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
//		
//		game.refreshPiecesOnBoard();
//		
//		int tryResult = game.tryMove(new Place(7, 7), new Place(6, 6));
//		Integer[][] expectedTable =  new Integer[][] {
//			//    0   1   2   3   4   5   6   7
//				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
//				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
//				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
//				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
//				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
//				{ 0,  0,  0,  0,  0,  0,  0, 16}  // 7
//			};
//		Integer[][] actualTable = game.getBoard().getBoard();
////		printExpectedAndActualArray(expectedTable, actualTable);
//		assertEquals(CHECKMATE, tryResult);
//		assertArrayEquals(expectedTable, actualTable);
//	}
//	
	@Test
	public void isTryMoveByKingNOT_MOVEABLE1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(2, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(2, 6), new Place(3, 6));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(NOT_MOVEABLE, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	@Test
	public void isTryMoveByKingNOT_MOVEABLE2() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(2, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(2, 6), new Place(3, 6));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(NOT_MOVEABLE, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	@Test
	public void isTryMoveByKingHIT_DONE1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 21,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 6), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(1, 5), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(2, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(2, 6), new Place(1, 5));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 16,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(HIT_DONE, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	@Test
	public void isTryMoveByKingNOT_MOVEABLE3() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{26,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 21,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(0, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(1, 5), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(2, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(2, 6), new Place(1, 5));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{26,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 21,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(CHECK, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	@Test
	public void isTryMoveByKingSTEP_DONE1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{26,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 21,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0, 16,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(0, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(1, 5), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(2, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 2), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(2, 6), new Place(3, 5));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{26,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0, 21,  0, 16,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 26,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
		UtilTest.printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(STEP_DONE, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	@Test
	public void isTryMoveCHECK1() {
		this.board  = new Board();
		this.table = new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(0, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(5, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 5), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(3, 5), new Place(4, 4));
		Integer[][] expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{ 0,  0,  0,  0,  0,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
				{ 0,  0,  0, 11,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(CHECK, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}

	@Test
	public void isTryMoveCHECK2() {
		this.board  = new Board();
		this.table = new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
		game.getP2().getPiecesOnBoard().add(new King  (new Place(1, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Bishop(new Place(0, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(5, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 5), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(3, 5), new Place(3, 4));
		Integer[][] expectedTable =  new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0, 23,  0, 23,  0}, // 4
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		Integer[][] actualTable = game.getBoard().getBoard();
//		printExpectedAndActualArray(expectedTable, actualTable);
		assertArrayEquals(expectedTable, actualTable);
		assertEquals(CHECK, tryResult);
	}
	
	@Test
	public void isTryMoveCHECK3() {
		this.board  = new Board();
		this.table = new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(1, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Bishop(new Place(0, 0), BLACK));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(5, 5), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 4), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(3, 4), new Place(3, 3));
		Integer[][] expectedTable =  new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0,  0,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 5
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		Integer[][] actualTable = game.getBoard().getBoard();
//		UtilTest.printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(STEP_DONE, tryResult);
		assertArrayEquals(expectedTable, actualTable);
	}
	
	
	@Test
	public void afterPawnHitPromotionRequiered1() {
		this.board  = new Board();
		this.table = new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0, 25,  0,  0, 22}, // 0
			{ 0,  0,  0, 11,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		board.setBoard(table);
		game.setBoard(board);
		
		game.getP2().getPiecesOnBoard().clear();
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(4, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 4), BLACK));
		game.getP2().getPiecesOnBoard().add(new King  (new Place(1, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Bishop(new Place(0, 0), BLACK));
		game.getP2().getPiecesOnBoard().add(new Queen (new Place(4, 0), BLACK));
		game.getP2().getPiecesTakenDown().add(new Queen (new Place(3, 7), WHITE));
		
		game.getP1().getPiecesOnBoard().clear();
		game.getP1().getPiecesOnBoard().add(new King(new Place(5, 6), WHITE));
		game.getP1().getPiecesOnBoard().add(new Pawn(new Place(3, 1), WHITE));
		
		game.refreshPiecesOnBoard();
		
		int tryResult = game.tryMove(new Place(3, 1), new Place(4, 0));
		Integer[][] expectedTable =  new Integer[][] {
		//    0   1   2   3   4   5   6   7
			{24, 26,  0,  0, 11,  0,  0, 22}, // 0
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
			{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
			{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
			{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
		};
		Integer[][] actualTable = game.getBoard().getBoard();
//		UtilTest.printExpectedAndActualArray(expectedTable, actualTable);
		assertEquals(PROMOTION_REQUIERED, tryResult);
		assertArrayEquals(expectedTable, actualTable);
		
		
		Piece pawn = game.searchPieceOnBoard(new Place(4, 0));
		Piece toPromote = new Queen(new Place(0, 0), WHITE);
		game.doPromotion(pawn, toPromote);
		
		
		expectedTable =  new Integer[][] {
			//    0   1   2   3   4   5   6   7
				{24, 26,  0,  0, 15,  0,  0, 22}, // 0
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 1
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 2
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 3
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 4
				{ 0,  0,  0,  0,  0,  0,  0,  0}, // 5
				{ 0,  0,  0,  0,  0, 16,  0,  0}, // 6
				{ 0,  0,  0,  0,  0,  0,  0,  0}  // 7
			};
		actualTable = game.getBoard().getBoard();
//		UtilTest.printExpectedAndActualArray(expectedTable, actualTable);
		assertArrayEquals(expectedTable, actualTable);
		assertEquals(false, game.getP1().isActual());
		assertEquals(true,  game.getP2().isActual());
	}
	
//	@Test
//	public void KingHit1() {
//		this.board  = new Board();
//		this.table = new Integer[][] {
////		       0   1   2   3   4   5   6   7
//			{ 22, 23, 24,  0,  0, 24, 23, 22 }, // 0
//			{ 21, 21,  0,  0,  0,  0,  0, 21 }, // 1
//			{  0,  0, 21,  0,  0, 26,  0,  0 }, // 2
//			{  0,  0,  0,  0,  0,  0,  0,  0 }, // 3
//			{  0,  0,  0, 21, 16, 21,  0, 12 }, // 4
//			{  0,  0,  0,  0,  0,  0,  0,  0 }, // 5
//			{ 11, 11, 11, 11,  0, 11, 11,  0 }, // 6
//			{ 12, 13, 14, 15,  0, 14, 13,  0 }  // 7
//		};
//		board.setBoard(table);
//		game.setBoard(board);
//		
//		game.getP2().getPiecesOnBoard().clear();
//		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(0, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(1, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Bishop(new Place(2, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Bishop(new Place(5, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Knight(new Place(6, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Rook  (new Place(7, 0), BLACK));
//		game.getP2().getPiecesOnBoard().add(new King  (new Place(5, 2), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(0, 1), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(1, 1), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(2, 2), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(3, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(5, 4), BLACK));
//		game.getP2().getPiecesOnBoard().add(new Pawn  (new Place(7, 1), BLACK));
//		
//		
//		game.getP1().getPiecesOnBoard().clear();
//		game.getP1().getPiecesOnBoard().add(new Rook  (new Place(0, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Knight(new Place(1, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Bishop(new Place(2, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Queen (new Place(3, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Bishop(new Place(5, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Knight(new Place(6, 7), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Rook  (new Place(7, 4), WHITE));
//		game.getP1().getPiecesOnBoard().add(new King  (new Place(4, 4), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(0, 6), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(1, 6), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(2, 6), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(3, 6), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(5, 6), WHITE));
//		game.getP1().getPiecesOnBoard().add(new Pawn  (new Place(6, 6), WHITE));
//		
//		game.refreshPiecesOnBoard();
//		
//		int tryResult = game.tryMove(new Place(4, 4), new Place(5, 4));
//		Integer[][] expectedTable =  new Integer[][] {
////		  	   0   1   2   3   4   5   6   7
//			{ 22, 23, 24,  0,  0, 24, 23, 22 }, // 0
//			{ 21, 21,  0,  0,  0,  0,  0, 21 }, // 1
//			{  0,  0, 21,  0,  0, 26,  0,  0 }, // 2
//			{  0,  0,  0,  0,  0,  0,  0,  0 }, // 3
//			{  0,  0,  0, 21,  0, 16,  0, 12 }, // 4
//			{  0,  0,  0,  0,  0,  0,  0,  0 }, // 5
//			{ 11, 11, 11, 11,  0, 11, 11,  0 }, // 6
//			{ 12, 13, 14, 15,  0, 14, 13,  0 }  // 7
//		};
//		Integer[][] actualTable = game.getBoard().getBoard();
////		UtilTest.printExpectedAndActualArray(expectedTable, actualTable);
//		assertEquals(HIT_DONE, tryResult);
////		assertEquals(NOT_MOVEABLE, tryResult);
//		assertArrayEquals(expectedTable, actualTable);
//	}
	
}

