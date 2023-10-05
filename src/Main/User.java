package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class User extends JFrame implements ActionListener {

	 int j=10;
	 JLabel a,b,g,h;
	 JTextField e,f;
	 JButton c;
	Random rm = new Random();
	int random = rm.nextInt(100)+1;
	public User() {
		setLayout(null);
		setTitle("Number Guessing Game");
		setSize(1000,900);
		setLocation(250,50);
		getContentPane().setBackground(Color.WHITE);
		
		a = new JLabel("Welcome To Number Guessing Game");
		
		a.setFont(new Font("Helvetica",Font.BOLD,50));
		a.setForeground(Color.BLACK);
		a.setBounds(30,10,900,200);
		add(a);

		b = new JLabel("Enter a number to Guess :",SwingConstants.CENTER);
		b.setFont(new Font("Helvetica",Font.BOLD,30));
		b.setForeground(Color.BLACK);
		b.setBounds(50,200,400,100);
		add(b);
		
		e = new JTextField(SwingConstants.CENTER);
		e.setBounds(450,225,200,50);
		e.setFont(new Font("Helvetica",Font.BOLD,20));
		e.setForeground(Color.BLACK);
		e.setVisible(true);
		add(e);
		
		g = new JLabel("",SwingConstants.CENTER);
		g.setFont(new Font("Helvetica",Font.BOLD,30));
		g.setForeground(Color.BLACK);
		g.setBounds(50,350,800,100);
		g.setVisible(true);
		add(g);
		
		h = new JLabel("",SwingConstants.CENTER);
		h.setFont(new Font("Helvetica",Font.BOLD,30));
		h.setForeground(Color.BLACK);
		h.setBounds(50,450,800,100);
		h.setVisible(true);
		add(h);
		
		c = new JButton("CHECK");
	    c.setBounds(400,300,100,30);
	    c.addActionListener(this);	    
	    c.setBackground(Color.BLACK);
	    c.setForeground(Color.WHITE);
	    add(c);
	    
	    ImageIcon i1 = new ImageIcon(("src/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(250, 250, 800, 800);
        add(l3);
			setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Guessing();
		
		
	}

	public void Guessing() {
		int attempts = 0;
		int maxAttempts = 3;
		 while(attempts<maxAttempts) {
		int guess;
		try {	
			guess = Integer.parseInt(e.getText());
			 if(guess<=0|| guess>=100) {
				g.setText("Please enter a number between 1 and 100");
				break;
			} else if(guess == random ) {
				g.setText("Congratulations! You guessed the correct number");
				break;
			}else if (guess < random) {
                 g.setText("Too low. Try again!");
                 break;
            } else if (guess > random) {
                g.setText("Too high. Try again!");
                break;
		}
			     
		}		
		catch(NumberFormatException ex) {
			g.setText("Please enter a valid Integer");
		break;
		}
		attempts++; 
		 }

	}
	public static void main(String[] args) {
		new User();
	}
}
