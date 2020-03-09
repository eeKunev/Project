package Model;

import java.awt.Container;
import java.awt.EventQueue;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import javafx.scene.input.MouseEvent;

import java.awt.BorderLayout;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class JModel extends FileReader {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JModel window = new JModel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public JModel() throws FileNotFoundException {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		getResource();
        JTree();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tree.setBounds(0, 0, 200, 500);
		frame.getContentPane().add(tree);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(200, 0, 600, 500);
		frame.getContentPane().add(panel_1);
		tree.requestFocusInWindow();
		frame.setVisible(true);
		
			
		}
}


