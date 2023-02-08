import javax.swing.JFrame;
import javax.swing.JButton;

public class FIRSTPAGE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createframe();
	}
	
	public static void createframe() {
		JFrame frame = new JFrame("FIRSTPAGE");
		frame.setBounds(100, 100, 552, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton resultBtn = new JButton("go next page");
		resultBtn.setBounds(293, 234, 112, 23);
		frame.getContentPane().add(resultBtn);
		resultBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				   
			}
		});
		
		
		frame.setVisible(true);
	}
}

