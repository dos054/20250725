package sec01.jdbc;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	JButton jb1 = new JButton("확인");
	public MyFrame() {
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(1200,400);
		this.setSize(400,400);
		
		jb1.setBounds(10,20, 80, 50);
		con.add(jb1);
		jb1.addActionListener(new ActionListener);
		
	}

	public static void main(String[] args) {
		new MyFrame();
		
		
		
	}

}
