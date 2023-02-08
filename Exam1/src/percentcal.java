import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

//import org.eclipse.swt.widgets.Text;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class percentcal {

	private JFrame frame;
	private JTextField pricefield;
	private JTextField percentfield;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton resetbtn;
	protected JLabel lbspeak;
	
	Double price, percent, calpercent, result ;
	int ranpercent, numlb ;
	String Scalpercent, Sresult, Sprice, Spercent, Sranpercent ;
	String[] speak = {"Calculate!","Reset!","Random % !"} ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					percentcal window = new percentcal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end main class

	/**
	 * Create the application.
	 */
	public percentcal() {
		initialize();
	}
	public void showlebel(int numlb) {
			switch(numlb) {
			
				case 1 : lbspeak.setText(speak[0]); break;
				case 2 : lbspeak.setText(speak[1]); break;
				case 3 : lbspeak.setText(speak[2]); break;	
		}//end switch
	}//end method 

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(24, 29, 49));
		frame.setBounds(100, 100, 552, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERCENT CALCULATOR");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(240, 233, 210));
		lblNewLabel.setBounds(144, 34, 255, 37);
		frame.getContentPane().add(lblNewLabel);
		
		pricefield = new JTextField();
		pricefield.setForeground(new Color(103, 137, 131));
		pricefield.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		pricefield.setBounds(77, 119, 155, 35);
		frame.getContentPane().add(pricefield);
		pricefield.setColumns(10);
		
		percentfield = new JTextField();
		percentfield.setForeground(new Color(103, 137, 131));
		percentfield.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		percentfield.setBounds(306, 119, 155, 35);
		frame.getContentPane().add(percentfield);
		percentfield.setColumns(10);
		
		lblNewLabel_1 = new JLabel("PRICE");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(230, 221, 196));
		lblNewLabel_1.setBounds(77, 94, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("PERCENT (%)");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(230, 221, 196));
		lblNewLabel_2.setBounds(306, 94, 97, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton calbtn = new JButton("Calculate");
		calbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showlebel(1);
				if(pricefield.getText().isEmpty() && percentfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter PRICE and PERCENT","Warning", JOptionPane.WARNING_MESSAGE);
				}else if(pricefield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter PRICE ","Warning", JOptionPane.WARNING_MESSAGE);
				}else if(percentfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter PERCENT ","Warning", JOptionPane.WARNING_MESSAGE);
				}//end fill the blank condition
				
				price = Double.parseDouble(pricefield.getText());
				percent = Double.parseDouble(percentfield.getText());
				
				
				if(percent >= 0 && percent <= 100) {
					calpercent = price*(percent/100) ; 	//คำนวณเปอร์เซ็น
					result = price - calpercent ;		 //คำนวณส่วนต่างเมื่อลดกับราคาเต็ม
					Scalpercent = String.format("%.2f", calpercent);
					Sresult = String.format("%.2f", result);
					JOptionPane.showMessageDialog(null, "price : " + price + "\n" + "percent : " + percent +"\n"+"percent from price : "+ Scalpercent+"\n_____________________________"+"\nThe price that you must pay is "+ Sresult);
				}else {
					JOptionPane.showMessageDialog(null, "You can't put PERCENT(%) under 0 or more than 100 ", "WARNING", JOptionPane.WARNING_MESSAGE);
				}//end else
					
			}//end action button
		});
		calbtn.setForeground(new Color(240, 233, 210));
		calbtn.setBackground(new Color(103, 137, 131));
		calbtn.setBounds(294, 223, 90, 35);
		frame.getContentPane().add(calbtn);
		
		resetbtn = new JButton("Reset");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showlebel(2);
				pricefield.setText(null);
				percentfield.setText(null);
				
			}//end reset button
		});
		resetbtn.setForeground(new Color(221, 189, 189));
		resetbtn.setBackground(new Color(170, 86, 86));
		resetbtn.setBounds(158, 223, 90, 35);
		frame.getContentPane().add(resetbtn);
		
		JButton randombtn = new JButton("%");
		
		randombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showlebel(3);
				ranpercent = (int)(Math.random()*101) ; //random 0-100
				Sranpercent = Integer.toString(ranpercent);
				percentfield.setText(Sranpercent);
				
			}
		});
		randombtn.setBackground(new Color(192, 192, 192));
		randombtn.setBounds(418, 165, 43, 23);
		frame.getContentPane().add(randombtn);
		
		lbspeak = new JLabel("");
		lbspeak.setForeground(new Color(255, 255, 255));
		lbspeak.setBounds(235, 288, 83, 14);
		frame.getContentPane().add(lbspeak);
			
	}
}//end class