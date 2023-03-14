import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener{

	// all global variables. frame, buttons, time display, etc.
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton stopButton = new JButton("STOP");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean timeActive = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			elapsedTime+=1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		}
	});

	StopWatch(){
		//time display box and contents
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(125, 125, 225, 80);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		//start button
		startButton.setBounds(135,208,100,30);
		startButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(237,208,100,30);
		resetButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) {
			
			
			if (timeActive==false) {
				timeActive = true;
				startButton.setText("STOP");
				startButton.setBackground(Color.RED);
				start();
			}
			
			else {
				timeActive = false;
				startButton.setText("START");
				startButton.setBackground(null);
				stop();
			}
		}
		
		if(e.getSource() == resetButton) {
			
				timeActive= false;
				startButton.setText("START");
				startButton.setBackground(null);
				reset();			
			
		}
		
	}

	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime = 0;
		hours = 0;
		minutes = 0;
		seconds = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
}
