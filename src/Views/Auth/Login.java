package Views.Auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Employees;
import Models.Auth.LoginModel;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel jpanelMain;
	private JPanel jpanelLogin;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 590);
		jpanelMain = new JPanel();
		jpanelMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpanelMain);
		jpanelMain.setLayout(new BoxLayout(jpanelMain, BoxLayout.PAGE_AXIS));
		
		JPanel Top_Panel = new JPanel();
		jpanelMain.add(Top_Panel);
		Top_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel Middle_Panel = new JPanel();
		jpanelMain.add(Middle_Panel);
		Middle_Panel.setLayout(new BoxLayout(Middle_Panel, BoxLayout.X_AXIS));
		
		JPanel Left_Panel = new JPanel();
		Middle_Panel.add(Left_Panel);
		Left_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel Center_Content_Panel = new JPanel();
		Middle_Panel.add(Center_Content_Panel);
		Center_Content_Panel.setLayout(new BoxLayout(Center_Content_Panel, BoxLayout.X_AXIS));
		
		jpanelLogin = new JPanel();
		Center_Content_Panel.add(jpanelLogin);
		jpanelLogin.setLayout(new BoxLayout(jpanelLogin, BoxLayout.PAGE_AXIS));
		
		JPanel Top_Fix = new JPanel();
		jpanelLogin.add(Top_Fix);
		Top_Fix.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelForm = new JPanel();
		jpanelLogin.add(jpanelForm);
		jpanelForm.setLayout(new BoxLayout(jpanelForm, BoxLayout.PAGE_AXIS));
		
		JLabel jlabelLogin = new JLabel("Login");
		jlabelLogin.setMinimumSize(new Dimension(300, 60));
		jlabelLogin.setMaximumSize(new Dimension(300, 60));
		jlabelLogin.setPreferredSize(new Dimension(300, 80));
		jlabelLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		jlabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		jpanelForm.add(jlabelLogin);
		
		JPanel jpanelFormLogin = new JPanel();
		jpanelForm.add(jpanelFormLogin);
		jpanelFormLogin.setLayout(new BoxLayout(jpanelFormLogin, BoxLayout.PAGE_AXIS));
		
		JPanel jpanelUsername = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpanelUsername.getLayout();
		jpanelFormLogin.add(jpanelUsername);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(80, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpanelUsername.add(lblNewLabel);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setPreferredSize(new Dimension(7, 25));
		jpanelUsername.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(20);
		
		JPanel jpanelPassword = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) jpanelPassword.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		jpanelFormLogin.add(jpanelPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setPreferredSize(new Dimension(80, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpanelPassword.add(lblNewLabel_1);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setPreferredSize(new Dimension(7, 25));
		jpasswordField.setColumns(20);
		jpasswordField.setEchoChar('*');
		jpanelPassword.add(jpasswordField);
		
		JLabel jlabelForgotPassword = new JLabel("Forgot Password? ");
		jlabelForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlabelForgotPassword.setPreferredSize(new Dimension(300, 30));
		jlabelForgotPassword.setMaximumSize(new Dimension(280, 14));
		jlabelForgotPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
		jlabelForgotPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		jlabelForgotPassword.setForeground(SystemColor.textHighlight);
		jlabelForgotPassword.setFont(new Font("Tahoma", Font.ITALIC, 14));
		jlabelForgotPassword.setAlignmentX(0.5f);
		jpanelFormLogin.add(jlabelForgotPassword);
		
		JPanel jpanelButton = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) jpanelButton.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		jpanelButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jpanelButton.setPreferredSize(new Dimension(10, 50));
		jpanelFormLogin.add(jpanelButton);
		
		JButton jbtnLogin = new JButton("Login");
		jbtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnLogin_actionPerformed(e);
			}
		});
		jbtnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		jbtnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpanelButton.add(jbtnLogin);
		
		JButton jbtnRegister = new JButton("Register");
		jbtnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpanelButton.add(jbtnRegister);
		
		JPanel Bottom_Fix = new JPanel();
		jpanelLogin.add(Bottom_Fix);
		Bottom_Fix.setLayout(new BorderLayout(0, 0));
		
		JPanel Right_Panel = new JPanel();
		Middle_Panel.add(Right_Panel);
		Right_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel Bottom_Panel = new JPanel();
		jpanelMain.add(Bottom_Panel);
		Bottom_Panel.setLayout(new BorderLayout(0, 0));
	}
	
	public void jbtnLogin_actionPerformed(ActionEvent e) {
		LoginModel loginModel = new LoginModel();
		String username = jtextFieldUsername.getText();
		String password = new String(jpasswordField.getPassword());
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter username and password");
			return;
		}
		Employees employee  = loginModel.Login(username, password);
		if(employee != null) {
			System.out.println("Success");
		}
	}

}
