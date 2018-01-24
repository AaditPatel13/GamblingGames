package BlackJackGame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class blackJackGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					blackJackGUI window = new blackJackGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public blackJackGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Deck d1 = new Deck();
	ArrayList<Card> deck = new ArrayList<>();
	int playerTotalPoints= 0;
	int dealerTotalPoints = 0;
	int cardNumber = 3;
	Card dealerSecondCard;
	
	boolean playerAce =false;
	boolean dealerAce  =false;
	
	int playerAceTotal;
	int dealerAceTotal;
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 100, 0));
		frame.setBounds(100, 100, 450, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBackground(new Color(255, 255, 255));
		lblPlayer.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.WEST, lblPlayer, 201, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlayer, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblDealer = new JLabel("Dealer");
		lblDealer.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, lblDealer, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDealer, 0, SpringLayout.WEST, lblPlayer);
		frame.getContentPane().add(lblDealer);
		
		JButton hitButton = new JButton("Hit");
		hitButton.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, hitButton, 6, SpringLayout.EAST, lblPlayer);
		springLayout.putConstraint(SpringLayout.SOUTH, hitButton, -2, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, hitButton, 76, SpringLayout.EAST, lblPlayer);
		frame.getContentPane().add(hitButton);
		
		JButton stayButton = new JButton("Stay");
		stayButton.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, stayButton, -4, SpringLayout.NORTH, lblPlayer);
		springLayout.putConstraint(SpringLayout.EAST, stayButton, -6, SpringLayout.WEST, lblPlayer);
		frame.getContentPane().add(stayButton);
		
		JLabel lblTotal = new JLabel("Total");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTotal, -19, SpringLayout.NORTH, stayButton);
		springLayout.putConstraint(SpringLayout.EAST, lblTotal, -219, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblTotal);
		
		JLabel playerTotal = new JLabel("0");
		springLayout.putConstraint(SpringLayout.WEST, playerTotal, 6, SpringLayout.EAST, lblTotal);
		springLayout.putConstraint(SpringLayout.SOUTH, playerTotal, -19, SpringLayout.NORTH, hitButton);
		springLayout.putConstraint(SpringLayout.EAST, playerTotal, 0, SpringLayout.EAST, hitButton);
		frame.getContentPane().add(playerTotal);
		
		JLabel label = new JLabel("Total");
		springLayout.putConstraint(SpringLayout.NORTH, label, 14, SpringLayout.SOUTH, lblDealer);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblPlayer);
		frame.getContentPane().add(label);
		
		JLabel dealerTotal = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, dealerTotal, 14, SpringLayout.SOUTH, lblDealer);
		springLayout.putConstraint(SpringLayout.WEST, dealerTotal, 8, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.EAST, dealerTotal, -112, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(dealerTotal);
		
		JTextArea playerSlot1 = new JTextArea();
		playerSlot1.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.WEST, playerSlot1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, playerSlot1, -105, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(playerSlot1);
		
		JTextArea dealerSlot1 = new JTextArea();
		dealerSlot1.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, playerSlot1, 102, SpringLayout.SOUTH, dealerSlot1);
		springLayout.putConstraint(SpringLayout.EAST, dealerSlot1, 0, SpringLayout.EAST, playerSlot1);
		springLayout.putConstraint(SpringLayout.NORTH, dealerSlot1, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dealerSlot1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dealerSlot1, -304, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(dealerSlot1);
		
		JTextArea dealerSlot2 = new JTextArea();
		dealerSlot2.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, dealerSlot2, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dealerSlot2, 32, SpringLayout.EAST, dealerSlot1);
		frame.getContentPane().add(dealerSlot2);
		
		JTextArea dealerSlot3 = new JTextArea();
		dealerSlot3.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, dealerSlot3, 28, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, dealerSlot3, 199, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dealerSlot2, -35, SpringLayout.WEST, dealerSlot3);
		springLayout.putConstraint(SpringLayout.EAST, dealerSlot3, -190, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(dealerSlot3);
		
		JTextArea playerSlot2 = new JTextArea();
		playerSlot2.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, playerSlot2, 284, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, playerSlot2, 103, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dealerSlot2, -102, SpringLayout.NORTH, playerSlot2);
		springLayout.putConstraint(SpringLayout.EAST, playerSlot1, -32, SpringLayout.WEST, playerSlot2);
		springLayout.putConstraint(SpringLayout.SOUTH, playerSlot2, -74, SpringLayout.NORTH, stayButton);
		frame.getContentPane().add(playerSlot2);
		
		JTextArea playerSlot3 = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, playerSlot3, 199, SpringLayout.WEST, frame.getContentPane());
		playerSlot3.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.SOUTH, dealerSlot3, -102, SpringLayout.NORTH, playerSlot3);
		springLayout.putConstraint(SpringLayout.EAST, playerSlot2, -35, SpringLayout.WEST, playerSlot3);
		springLayout.putConstraint(SpringLayout.SOUTH, playerSlot3, 0, SpringLayout.SOUTH, playerSlot1);
		springLayout.putConstraint(SpringLayout.NORTH, playerSlot3, 0, SpringLayout.NORTH, playerSlot1);
		frame.getContentPane().add(playerSlot3);
		
		JTextArea playerSlot4 = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, playerSlot4, 288, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, playerSlot3, -28, SpringLayout.WEST, playerSlot4);
		playerSlot4.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, playerSlot4, 0, SpringLayout.NORTH, playerSlot1);
		springLayout.putConstraint(SpringLayout.SOUTH, playerSlot4, 0, SpringLayout.SOUTH, playerSlot1);
		springLayout.putConstraint(SpringLayout.EAST, playerSlot4, -101, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(playerSlot4);
		
		JTextArea dealerSlot4 = new JTextArea();
		dealerSlot4.setBackground(new Color(0, 128, 0));
		springLayout.putConstraint(SpringLayout.NORTH, dealerSlot4, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dealerSlot4, 28, SpringLayout.EAST, dealerSlot3);
		springLayout.putConstraint(SpringLayout.SOUTH, dealerSlot4, 182, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dealerSlot4, 89, SpringLayout.EAST, dealerSlot3);
		frame.getContentPane().add(dealerSlot4);
		
		JTextArea textArea_6 = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea_6, 166, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea_6, -11, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_6, -304, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea_6, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textArea_6);
		
		JTextArea dealerSlot5 = new JTextArea();
		dealerSlot5.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, dealerSlot5, 0, SpringLayout.NORTH, dealerSlot1);
		springLayout.putConstraint(SpringLayout.WEST, dealerSlot5, 23, SpringLayout.EAST, dealerSlot4);
		springLayout.putConstraint(SpringLayout.SOUTH, dealerSlot5, 0, SpringLayout.SOUTH, dealerSlot1);
		springLayout.putConstraint(SpringLayout.EAST, dealerSlot5, -6, SpringLayout.WEST, textArea_6);
		frame.getContentPane().add(dealerSlot5);
		
		JTextArea playerSlot5 = new JTextArea();
		playerSlot5.setBackground(new Color(34, 139, 34));
		springLayout.putConstraint(SpringLayout.NORTH, playerSlot5, 102, SpringLayout.SOUTH, dealerSlot5);
		springLayout.putConstraint(SpringLayout.WEST, playerSlot5, 23, SpringLayout.EAST, playerSlot4);
		springLayout.putConstraint(SpringLayout.SOUTH, playerSlot5, 199, SpringLayout.SOUTH, dealerSlot5);
		springLayout.putConstraint(SpringLayout.EAST, playerSlot5, -11, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(playerSlot5);
		
		JButton btnDeal = new JButton("Deal");
		springLayout.putConstraint(SpringLayout.WEST, btnDeal, 35, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnDeal, -36, SpringLayout.NORTH, playerSlot1);
		springLayout.putConstraint(SpringLayout.EAST, btnDeal, -330, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnDeal);
		
		JLabel winOrLose = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, winOrLose, 0, SpringLayout.NORTH, btnDeal);
		springLayout.putConstraint(SpringLayout.WEST, winOrLose, 60, SpringLayout.EAST, btnDeal);
		springLayout.putConstraint(SpringLayout.SOUTH, winOrLose, 0, SpringLayout.SOUTH, btnDeal);
		frame.getContentPane().add(winOrLose);
		
		JButton playAgain = new JButton("Play Again");
		playAgain.setEnabled(false);
		springLayout.putConstraint(SpringLayout.EAST, winOrLose, -45, SpringLayout.WEST, playAgain);
		springLayout.putConstraint(SpringLayout.NORTH, playAgain, 0, SpringLayout.NORTH, btnDeal);
		springLayout.putConstraint(SpringLayout.WEST, playAgain, 202, SpringLayout.EAST, btnDeal);
		frame.getContentPane().add(playAgain);
		
		
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.clear();
				d1.createDeck(deck);
				d1.shuffle(deck);
				Card temp = deck.remove(0);
				if(temp.getcVal().getVal() == 11){
					playerAce = true;
				}
				playerSlot1.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
				playerTotalPoints += temp.getcVal().getVal();
				temp = deck.remove(0);
				if(temp.getcVal().getVal() == 11){
					playerAce = true;
				}
				playerSlot2.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
				playerTotalPoints += temp.getcVal().getVal();
				temp = deck.remove(0);
				if(temp.getcVal().getVal() == 11){
					dealerAce = true;
				}
				dealerSlot1.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
				dealerTotalPoints += temp.getcVal().getVal();
				dealerTotal.setText("" + dealerTotalPoints);
				dealerSecondCard = deck.remove(0);
				if(dealerSecondCard.getcVal().getVal() == 11){
					dealerAce = true;
				}
				dealerTotalPoints += dealerSecondCard.getcVal().getVal();
				if(playerTotalPoints == 22){
					playerTotalPoints = 12;
				}
				playerTotal.setText("" + playerTotalPoints);
				btnDeal.setEnabled(false);
				hitButton.setEnabled(true);
				stayButton.setEnabled(true);
				
			}
		});
		
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card temp = deck.remove(0);
				if(temp.getcVal().getVal() == 11){
					playerAce = true;
				}
				
				if(cardNumber > 5){
					cardNumber = 1;
				}
				if(cardNumber == 1){
					playerSlot1.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
					playerTotalPoints += temp.getcVal().getVal();
					playerTotal.setText("" + playerTotalPoints);
				}
				if(cardNumber == 2){
					playerSlot2.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
					playerTotalPoints += temp.getcVal().getVal();
					playerTotal.setText("" + playerTotalPoints);
				}
				
				if(cardNumber == 3){
					playerSlot3.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
					playerTotalPoints += temp.getcVal().getVal();
					playerTotal.setText("" + playerTotalPoints);
				}
				if(cardNumber == 4){
					playerSlot4.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
					playerTotalPoints += temp.getcVal().getVal();
					playerTotal.setText("" + playerTotalPoints);
				}
				if(cardNumber == 5){
					playerSlot5.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
					playerTotalPoints += temp.getcVal().getVal();
					playerTotal.setText("" + playerTotalPoints);
				}
				
				if(playerTotalPoints > 21){
					if(!playerAce){
						winOrLose.setText("YOU LOSE");
						hitButton.setEnabled(false);
						stayButton.setEnabled(false);
						playAgain.setEnabled(true);
					}
					else{
						playerTotalPoints -= 10;
						playerTotal.setText("" + playerTotalPoints);
						playerAce = false;
					}
				}
				cardNumber++;
			}
		});
		
		stayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealerSlot2.setText(dealerSecondCard.getcVal() + "\n of \n" + dealerSecondCard.getSuit());
				dealerTotal.setText("" + dealerTotalPoints);
				cardNumber = 3;
				while(dealerTotalPoints < 17){	
					Card temp = deck.remove(0);
					if(temp.getcVal().getVal() == 11){
						dealerAce = true;
					}

					if(cardNumber > 5){
						cardNumber = 1;
					}
					if(cardNumber == 1){
						dealerSlot1.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
						dealerTotalPoints += temp.getcVal().getVal();
						dealerTotal.setText("" + dealerTotalPoints);
					}
					if(cardNumber == 2){
						dealerSlot2.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
						dealerTotalPoints += temp.getcVal().getVal();
						dealerTotal.setText("" + dealerTotalPoints);
					}
					
					if(cardNumber == 3){
						dealerSlot3.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
						dealerTotalPoints += temp.getcVal().getVal();
						dealerTotal.setText("" + dealerTotalPoints);
					}
					if(cardNumber == 4){
						dealerSlot4.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
						dealerTotalPoints += temp.getcVal().getVal();
						dealerTotal.setText("" + dealerTotalPoints);
					}
					if(cardNumber == 5){
						dealerSlot5.setText(temp.getcVal() + "\n of \n" + temp.getSuit());
						dealerTotalPoints += temp.getcVal().getVal();
						dealerTotal.setText("" + dealerTotalPoints);
					}
					if(dealerTotalPoints > 21 && dealerAce == true){
						dealerTotalPoints -= 10;
						dealerAce = false;
					}
					cardNumber++;

				}
				if(playerTotalPoints > dealerTotalPoints){
					winOrLose.setText("YOU WIN");
				}
				else if(playerTotalPoints < dealerTotalPoints){
					if (dealerTotalPoints <= 21){
						winOrLose.setText("YOU LOSE");
					}
					else{
						winOrLose.setText("YOU WIN");
					}
				}
				else{
					winOrLose.setText("DRAW");
				}
				playAgain.setEnabled(true);
				hitButton.setEnabled(false);
				stayButton.setEnabled(false);
			}
		});
		
		playAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeal.setEnabled(true);
				playerSlot1.setText("");
				playerSlot2.setText("");
				playerSlot3.setText("");
				playerSlot4.setText("");
				playerSlot5.setText("");
				
				dealerSlot1.setText("");
				dealerSlot2.setText("");
				dealerSlot3.setText("");
				dealerSlot4.setText("");
				dealerSlot5.setText("");
				
				playerTotalPoints = 0;
				dealerTotalPoints = 0;
				playerTotal.setText("0");
				dealerTotal.setText("0");
				cardNumber = 3;
				winOrLose.setText("");
				
				playAgain.setEnabled(false);
				
			}
		});
	}
	

}
