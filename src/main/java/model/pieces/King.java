package model.pieces;

import static java.lang.Math.abs;
import static model.Constants.*;

import model.Board;
import model.Place;
import model.Player;

public class King extends Piece {
	
	public King(Place position, String color) {
		super(position, color, KING);
	}
	
	@Override
	public boolean isHitable(Player notActual, Place b, Board board) {
		int placeValue = board.getValue(b);
		Place a  = getPosition();
		int   ax = a.getX();
		int   ay = a.getY();
		int   bx = b.getX();
		int   by = b.getY();
		
		if( ! isBasicallyHitable(placeValue)) {
			return false;
		}
		
		if( ! (abs(ax - bx) <= 1 && abs(ay - by) <= 1) ) {
			return false;
		}
		
		return isOkByEnemyPieces(notActual, b);
	}
	
	@Override
	public boolean isStepable(Player notActual, Place b, Board board) {
		int placeValue = board.getValue(b);
		Place a  = getPosition();
		int   ax = a.getX();
		int   ay = a.getY();
		int   bx = b.getX();
		int   by = b.getY();
		
		for(Piece p : notActual.getPiecesOnBoard()) {
			if(p.getHitables().contains(b)) {
				return false;
			}
		}
			
		if(placeValue != 0) {
			return false;
		}
		
		if( ! (abs(ax - bx) <= 1 && abs(ay - by) <= 1) ) {
			return false;
		}
		
		return isOkByEnemyPieces(notActual, b);
	}
	
	@Override
	public boolean isPossibleHitablePlace(Place b, Board board) {
		if(getPosition().equals(b)) {
			return false;
		}
		
		int ax = getPosition().getX();
		int ay = getPosition().getY();
		int bx = b.getX();
		int by = b.getY();
		
		return (abs(ax - bx) <= 1 && abs(ay - by) <= 1);
	}
	
	public boolean isOkByEnemyPieces(Player notActual, Place b) {
		if(notActual.getColor().equals(getColor())) {
			throw new IllegalArgumentException();
		}
			
		for(Piece piece : notActual.getPiecesOnBoard()) {
			for(Place place : piece.getPossibleHitables()) {
				if(place.equals(b)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
