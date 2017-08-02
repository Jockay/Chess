package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Place;

@SuppressWarnings("serial")
public class ChessButton extends JButton {
	/** Decides if button clicked or not. */
	private boolean selected;
	/** Coordinate of the button on the game field. */
	private Place place;
	private Color pressedColor = Color.GREEN;
    private Color rolloverColor = Color.RED;
    private Color normalColor = Color.BLUE;
	
	private int value;
	
	/** Constructor */
	public ChessButton(Place c) {
		super("");
		this.selected = false;
		this.place = c;
	}
	
	 
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public ChessButton getThisButton() {
		return this;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ChessButton [selected=" + selected + ", coordinate="
				+ place + "]";
	}
}
