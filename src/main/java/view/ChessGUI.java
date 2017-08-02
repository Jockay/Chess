package view;

import static model.Constants.BLACK;
import static model.Constants.CHECK;
import static model.Constants.CHECK_WARN;
import static model.Constants.CHECKMATE;
import static model.Constants.HIT_DONE;
import static model.Constants.NOT_MOVEABLE;
import static model.Constants.PROMOTION_REQUIERED;
import static model.Constants.STEP_DONE;
import static model.Constants.WHITE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ChessService;
import controller.Util;
import model.Board;
import model.Game;
import model.Place;
import model.Player;
import model.pieces.Bishop;
import model.pieces.Piece;
import model.pieces.Queen;

public class ChessGUI extends JFrame {
	/** Main content pane. */
	private JPanel 	contentPane;
	/** Content pane for game buttons. */
	private JPanel 	chessField;
	/** Label for notifications. */
	private JLabel 	notification;
	/** List for game buttons. */
	private static List<ChessButton> buttons;
	/** Size of the buttons. */
	public int 	buttonSize;
	/** Offset from the edge of the window. */
	public int 	offset;
	/** Game state. */
	private static Game	game;
	/** Window frame. */
	private static ChessGUI frame;
	private boolean isPromotionDone;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChessGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refreshBoardIcons() {
		for (ChessButton chessButton : buttons)	{
			int value = game.getBoardValue(chessButton.getPlace());
			ImageIcon icon = null;
			switch(value) {
				case 0: 
//					icon = new ImageIcon(getClass().getClassLoader().getResource("Empty.png"));
					chessButton.setIcon(null);
					break;
				case 11:
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_pawn.png"));
					chessButton.setIcon(icon);
					break;
				case 12: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_rook.png"));
					chessButton.setIcon(icon);
					break;
				case 13: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_knight.png"));
					chessButton.setIcon(icon);
					break;
				case 14: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_bishop.png"));
					chessButton.setIcon(icon);
					break;
				case 15: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_queen.png"));
					chessButton.setIcon(icon);
					break;
				case 16: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("w_king.png"));
					chessButton.setIcon(icon);
					break;
				case 21: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_pawn2.png"));
					chessButton.setIcon(icon);
					break;
				case 22: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_rook2.png"));
					chessButton.setIcon(icon);
					break;
				case 23: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_knight2.png"));
					chessButton.setIcon(icon);
					break;
				case 24: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_bishop.png"));
					chessButton.setIcon(icon);
					break;
				case 25: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_queen2.png"));
					chessButton.setIcon(icon);
					break;
				case 26: 
					icon = new ImageIcon(getClass().getClassLoader().getResource("b_king2.png"));
					chessButton.setIcon(icon);
					break;
			}
		}
	}
	
	public void createBoard() {
//		Color dark = Color.BLACK;
		Color dark = new Color(209, 139, 71);
//		Color bright = Color.GRAY;
		Color bright = new Color(255, 206, 158);
		
		buttons = new ArrayList<ChessButton>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ChessButton button = new ChessButton(new Place(j, i));
				if(isEven(i)) {
					if( ! isEven(j)) {
						button.setBackground(dark);
						button.setForeground(dark);
					} else {
						button.setBackground(bright);
						button.setForeground(bright);
					}
				} else {
					if(isEven(j)) {
						button.setBackground(dark);
						button.setForeground(dark);
					} else {
						button.setBackground(bright);
						button.setForeground(bright);
					}
				}
				button.setPreferredSize(new Dimension(chessField.getX()/8, chessField.getY()/8));
				button.setMargin(new Insets(10, 10, 10, 10));
				button.setBorder(new LineBorder(Color.BLACK));
				
				buttons.add(button);
				chessField.add(button);
			}
		}
		bindListener();
	}
	
	public void createBorderLabels() {
//		JLabel label = new JLabel("0");
//		label.setForeground(Color.LIGHT_GRAY);
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setBounds(26, 12, 47, 15);
//		contentPane.add(label);
//		
//		JLabel label_1 = new JLabel("1");
//		label_1.setHorizontalAlignment(SwingConstants.CENTER);
//		label_1.setForeground(Color.LIGHT_GRAY);
//		label_1.setBounds(85, 12, 47, 15);
//		contentPane.add(label_1);
//		
//		JLabel label_2 = new JLabel("2");
//		label_2.setHorizontalAlignment(SwingConstants.CENTER);
//		label_2.setForeground(Color.LIGHT_GRAY);
//		label_2.setBounds(144, 12, 47, 15);
//		contentPane.add(label_2);
//		
//		JLabel label_3 = new JLabel("3");
//		label_3.setHorizontalAlignment(SwingConstants.CENTER);
//		label_3.setForeground(Color.LIGHT_GRAY);
//		label_3.setBounds(203, 12, 40, 15);
//		contentPane.add(label_3);
//		
//		JLabel label_4 = new JLabel("4");
//		label_4.setHorizontalAlignment(SwingConstants.CENTER);
//		label_4.setForeground(Color.LIGHT_GRAY);
//		label_4.setBounds(255, 12, 47, 15);
//		contentPane.add(label_4);
//		
//		JLabel label_5 = new JLabel("5");
//		label_5.setHorizontalAlignment(SwingConstants.CENTER);
//		label_5.setForeground(Color.LIGHT_GRAY);
//		label_5.setBounds(302, 12, 59, 15);
//		contentPane.add(label_5);
//		
//		JLabel label_6 = new JLabel("6");
//		label_6.setHorizontalAlignment(SwingConstants.CENTER);
//		label_6.setForeground(Color.LIGHT_GRAY);
//		label_6.setBounds(361, 12, 59, 15);
//		contentPane.add(label_6);
//		
//		JLabel label_7 = new JLabel("7");
//		label_7.setHorizontalAlignment(SwingConstants.CENTER);
//		label_7.setForeground(Color.LIGHT_GRAY);
//		label_7.setBounds(407, 12, 66, 15);
//		contentPane.add(label_7);
//		
//		JLabel label_8 = new JLabel("0");
//		label_8.setForeground(Color.LIGHT_GRAY);
//		label_8.setHorizontalAlignment(SwingConstants.CENTER);
//		label_8.setBounds(12, 25, 17, 46);
//		contentPane.add(label_8);
//		
//		JLabel label_9 = new JLabel("1");
//		label_9.setHorizontalAlignment(SwingConstants.CENTER);
//		label_9.setForeground(Color.LIGHT_GRAY);
//		label_9.setBounds(12, 83, 17, 46);
//		contentPane.add(label_9);
//		
//		JLabel label_10 = new JLabel("2");
//		label_10.setHorizontalAlignment(SwingConstants.CENTER);
//		label_10.setForeground(Color.LIGHT_GRAY);
//		label_10.setBounds(12, 141, 17, 46);
//		contentPane.add(label_10);
//		
//		JLabel label_11 = new JLabel("3");
//		label_11.setHorizontalAlignment(SwingConstants.CENTER);
//		label_11.setForeground(Color.LIGHT_GRAY);
//		label_11.setBounds(12, 199, 17, 46);
//		contentPane.add(label_11);
//		
//		JLabel label_12 = new JLabel("4");
//		label_12.setHorizontalAlignment(SwingConstants.CENTER);
//		label_12.setForeground(Color.LIGHT_GRAY);
//		label_12.setBounds(12, 257, 17, 46);
//		contentPane.add(label_12);
//		
//		JLabel label_13 = new JLabel("5");
//		label_13.setHorizontalAlignment(SwingConstants.CENTER);
//		label_13.setForeground(Color.LIGHT_GRAY);
//		label_13.setBounds(12, 315, 17, 46);
//		contentPane.add(label_13);
//		
//		JLabel label_14 = new JLabel("6");
//		label_14.setHorizontalAlignment(SwingConstants.CENTER);
//		label_14.setForeground(Color.LIGHT_GRAY);
//		label_14.setBounds(12, 373, 17, 46);
//		contentPane.add(label_14);
//		
//		JLabel label_15 = new JLabel("7");
//		label_15.setHorizontalAlignment(SwingConstants.CENTER);
//		label_15.setForeground(Color.LIGHT_GRAY);
//		label_15.setBounds(12, 431, 17, 46);
//		contentPane.add(label_15);
		
		JLabel label = new JLabel("A");
		label.setForeground(Color.LIGHT_GRAY);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(26, 12, 47, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("B");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setBounds(85, 12, 47, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setBounds(144, 12, 47, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("D");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setBounds(203, 12, 40, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("E");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setBounds(255, 12, 47, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("F");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setBounds(302, 12, 59, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("G");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.LIGHT_GRAY);
		label_6.setBounds(361, 12, 59, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("H");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.LIGHT_GRAY);
		label_7.setBounds(407, 12, 66, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("8");
		label_8.setForeground(Color.LIGHT_GRAY);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(12, 25, 17, 46);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("7");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.LIGHT_GRAY);
		label_9.setBounds(12, 83, 17, 46);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("6");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.LIGHT_GRAY);
		label_10.setBounds(12, 141, 17, 46);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("5");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.LIGHT_GRAY);
		label_11.setBounds(12, 199, 17, 46);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("4");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.LIGHT_GRAY);
		label_12.setBounds(12, 257, 17, 46);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("3");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.LIGHT_GRAY);
		label_13.setBounds(12, 315, 17, 46);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("2");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.LIGHT_GRAY);
		label_14.setBounds(12, 373, 17, 46);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("1");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.LIGHT_GRAY);
		label_15.setBounds(12, 431, 17, 46);
		contentPane.add(label_15);
	}
	
	public void highlightPossibleHitableButtons(Place place) {
		Piece piece = game.searchPieceOnBoard(place);
		
		if(piece == null) {
			return;
		}
		
		for(ChessButton bt : buttons) {
			Place btPlace = bt.getPlace();
			int btValue = game.getBoardValue(btPlace);
			if(piece.getHitables().contains(btPlace) 
					&& btValue != 0
					&& ( ! game.isInActualValueGroup(btValue))) {
				bt.setBorder(new LineBorder(Color.RED));
			}
			
			for(Place p : piece.getStepables()) {
				if(bt.getPlace().equals(p)) {
					bt.setBorder(new LineBorder(Color.GREEN));
				}
			}
		}
	}
	
	public void bindListener() {
		for(final ChessButton button : buttons) {
			Color defBckg =button.getBackground();
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					setBackground(defBckg.darker().darker());
					if( isPromotionDone == false) {
						notification.setText("PROMOTION IN PROGRESS");
						return; 
					}
//					if(game.getIsCheckmate()) { return; }
					ChessButton actButton = (ChessButton)e.getSource();
					Place       actPlace  = actButton.getPlace();
					int         actValue  = game.getBoardValue(actPlace);
					ChessButton preButton = getPreviousClickedButton();
					Place		prePlace  = null;
					int		    preValue  = -1;
					
					if( preButton == null 
							&& game.isInActualValueGroup(actValue)) {
						actButton.setBorder(new LineBorder(Color.GREEN));
						highlightPossibleHitableButtons(actPlace);
						actButton.setSelected(true);
						return;
					} else if(preButton != null) {
						if(preButton.equals(actButton)) {
							clearButtons();
							return;
						}
						
						if(game.isInActualValueGroup(actValue)) {
							clearButtons();
							actButton.setBorder(new LineBorder(Color.GREEN));
							highlightPossibleHitableButtons(actPlace);
							actButton.setSelected(true);
							return;
						} else {
							prePlace  = preButton.getPlace();
							preValue  = game.getBoardValue(prePlace);
							int tryResult = game.tryMove(prePlace, actPlace);
//							tryMoveLog(tryResult, prePlace, preValue, actPlace, actValue);
							
							if(tryResult == PROMOTION_REQUIERED) {
								Piece actPawn = game.searchPieceOnBoard(actPlace);
								clearButtons();
								refreshBoardIcons();
								new PromotionDialog(frame, game, actPawn, buttonSize);
								refreshBoardIcons();
							}
							
							if(tryResult == HIT_DONE 
									|| tryResult == STEP_DONE
									|| tryResult == CHECK
									|| tryResult == CHECK_WARN
									|| tryResult == NOT_MOVEABLE
									|| tryResult == CHECKMATE) {
								clearButtons();
							}
							refreshBoardIcons();
							setNotification(game.getActualPlayer(), tryResult);
						}
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(defBckg.darker());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(defBckg);
				}
				
			});
		}
	}
	
	public void setNotification(Player actualPlayer, int tryResult) {
		String actName = actualPlayer.getName();
		String actColor = actualPlayer.getColor();
		switch(tryResult) {
			case CHECK: {
				notification.setText(actName + "'s (" + actColor +") turn - IN CHECK");
				break;
			}
			case CHECK_WARN: {
				notification.setText(actName + "'s (" + actColor +") turn - CHECK WARN");
				break;
			}
			case CHECKMATE: {
				notification.setText(actName + "'s (" + actColor +") turn - CHECKMATE");
				break;
			}
			default: {
				notification.setText(actName + "'s turn");
			}
		}
	}
	
	public void tryMoveLog(int tryResult, Place prePlace, int preValue, Place actPlace, int actValue) {
		System.out.println("prePlace: " + prePlace);
		System.out.println("preValue: " + preValue);
		System.out.println("actPlace: " + actPlace);
		System.out.println("actValue: " + actValue);
		Util.printTryResult(tryResult);
		Util.printMatrix(game.getBoard().getBoard());
		System.out.println("=====================");
	}
	
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnApplication = new JMenu("Application");
		menuBar.add(mnApplication);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				game.newGame();
				clearButtons();
				refreshBoardIcons();
			}
		});
		mnApplication.add(mntmNewGame);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmSaveToDatabase = new JMenuItem("Save");
		mntmSaveToDatabase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new ChessService().saveToXML(game);
			}
		});
		mnApplication.add(mntmSaveToDatabase);
		
		JMenuItem mntmLoadFromDatabase = new JMenuItem("Load");
		mntmLoadFromDatabase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new ChessService().loadFromXML(game);
				refreshBoardIcons();
				setNotification(game.getActualPlayer(), 0);
			}
		});
		mnApplication.add(mntmLoadFromDatabase);
		mnApplication.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new About(frame);
			}
		});
		mnAbout.add(mntmAuthor);
	}
	
	public boolean isEven(int number) {
		return (number % 2) == 0;
	}
	
	/**
	 * Create the frame.
	 */
	public ChessGUI() {
//		List<Image> icons = new ArrayList<Image>();
//		icons.addAll((Collection<? extends Image>) new ImageIcon(getClass().getClassLoader().getResource("w_knight.png")));
////		icons.add(getImage("someImage32x32.gif"));
		
		this.isPromotionDone = true;
		this.buttonSize = 56;
		this.offset = 25;
		Board board = new Board();
		Player player1 = new Player("Player1", WHITE, board);
		Player player2 = new Player("Player2", BLACK, board);
		game = new Game(board, player1, player2);
		
		List<Piece> promotionList =  new ArrayList<Piece>(Arrays.asList(
				new Queen(new Place(0, 5), WHITE),
				new Bishop(new Place(0, 7), WHITE)
				));
		
		
		setBounds(0, 0, ((buttonSize * 8) + (offset * 2)) + 0,
				((buttonSize * 9) + (offset * 2))+offset);
		
		createMenuBar();
		
		contentPane = new JPanel();
		/*contentPane.setBounds(0, 0, ((buttonSize * 8) + (offset * 2)),
				((buttonSize * 8) + (offset * 2)));*/
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		
		
		chessField = new JPanel(new GridLayout(8, 8, 1, 1));
		chessField.setBorder(new EmptyBorder(2, 2, 2, 2));
		chessField.setBounds(offset, offset, ((buttonSize * 8)),
				((buttonSize * 8)));
		chessField.setBackground(Color.LIGHT_GRAY);
		contentPane.add(chessField);
		
		notification = new JLabel(game.getActualPlayer().getName() + " starts the game!");
		notification.setHorizontalAlignment(SwingConstants.CENTER);
		notification.setForeground(Color.LIGHT_GRAY);
//		notification.setBounds(20, 441, buttonSize*8, 15);
		notification.setBounds(offset, offset + 8*buttonSize + (int)(buttonSize/3), buttonSize*8, 15);
		contentPane.add(notification);
		
		createBorderLabels();
		createBoard();
		
		refreshBoardIcons();
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = this;
		Image icon = Toolkit.getDefaultToolkit().getImage("chess-icon.png");
//		Image icon = Toolkit.getDefaultToolkit().getImage("w_knight.png");
		frame.setIconImage(icon);
	}
	
	/**
	 * Returns previous clicked game button.
	 * 
	 * @return Previous clicked game button.
	 */
	public ChessButton getPreviousClickedButton() {
		for (ChessButton chessButton : buttons)
			if (chessButton.isSelected())
				return chessButton;
		return null;
	}

	/**
	 * Clears all button from clicked state.
	 */
	public void clearButtons() {
		for (ChessButton chessButton : buttons) {
			chessButton.setBorder(new LineBorder(Color.BLACK));
			if (chessButton.isSelected())
				chessButton.setSelected(false);
		}
	}
	
	public void pgt() {
//		for (int i = 0; i < g.getBoard().length; i++) {
//			for (int j = 0; j < g.getBoard().length; j++) {
//				System.out.print(g.getTableVal(new Coordinate(i, j)) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	
	public ChessGUI getGui() {
		return this;
	}

	public boolean isPromotionDone() {
		return isPromotionDone;
	}

	public void setPromotionDone(boolean isPromotionDone) {
		this.isPromotionDone = isPromotionDone;
	}
	
}

