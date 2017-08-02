package view;

import static model.Constants.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Game;
import model.Place;
import model.pieces.Piece;

public class PromotionDialog extends JFrame {

	private JPanel contentPane;
	private List<Piece> promotionList;
	private List<ChessButton> buttons;
	private Game game;
	
	/**
	 * Create the frame.
	 */
	public PromotionDialog(final ChessGUI frame, Game Game, Piece pawn, int buttonSize) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		this.game = Game;
		frame.setPromotionDone(false);
		this.promotionList = game.getPromotionList(pawn);
		this.buttons = new ArrayList<>();
		this.contentPane = new JPanel();
		setBounds(0, 0, ((buttonSize * 4)), ((buttonSize * 4)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 2));
		contentPane.setBackground(Color.BLACK);		
//		promotionList = (ArrayList<Piece>) game.getPromotionList();
		
		for(Piece piece : promotionList) {
			ChessButton button = new ChessButton(piece.getPosition());
			Color dark = new Color(209, 139, 71);
			button.setBackground(dark);
			button.setForeground(dark);
			button.setPreferredSize(new Dimension(contentPane.getX()/4, contentPane.getY()/4));
			button.setMargin(new Insets(10, 10, 10, 10));
			button.setBorder(new LineBorder(Color.BLACK));
			button.setPlace(piece.getPosition());
			button.setValue(piece.getValue());
			buttons.add(button);
			contentPane.add(button);
		}
		for(final ChessButton button : buttons) {
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					int   btValue = button.getValue();
					Place btPlace = button.getPlace();
					for(Piece p : promotionList) {
						if((p.getValue() == btValue) 
								&& btPlace.equals(p.getPosition())) {
							game.doPromotion(pawn, p);
							frame.refreshBoardIcons();
							frame.setNotification(game.getActualPlayer(), PROMOTION_DONE);
							frame.setPromotionDone(true);
							setVisible(false);
						}
					}
				}
			});
		}
		refreshBoardIcons(promotionList);
		setContentPane(contentPane);
		setVisible(true);
	}

	public void refreshBoardIcons(List<Piece> promotionList) {
		for (ChessButton button : buttons)	{
			
			int value = button.getValue();
			ImageIcon icon = null;
			switch(value) {
				case 0: 
//					icon = new ImageIcon(getClass().getClassLoader().getResource("Empty.png"));
					button.setIcon(null);
					break;
				case 11:
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_pawn.png"));
					button.setIcon(icon);
					break;
				case 12: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_rook.png"));
					button.setIcon(icon);
					break;
				case 13: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_knight.png"));
					button.setIcon(icon);
					break;
				case 14: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_bishop.png"));
					button.setIcon(icon);
					break;
				case 15: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_queen.png"));
					button.setIcon(icon);
					break;
				case 16: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_king.png"));
					button.setIcon(icon);
					break;
				case 21: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_pawn.png"));
					button.setIcon(icon);
					break;
				case 22: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_rook.png"));
					button.setIcon(icon);
					break;
				case 23: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_knight.png"));
					button.setIcon(icon);
					break;
				case 24: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_bishop.png"));
					button.setIcon(icon);
					break;
				case 25: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_queen.png"));
					button.setIcon(icon);
					break;
				case 26: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_king.png"));
					button.setIcon(icon);
					break;
			}
		}
	}
	
}
