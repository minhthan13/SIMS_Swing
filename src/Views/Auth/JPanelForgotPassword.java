package Views.Auth;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Models.Auth.EmailModel;
import Models.Auth.PasswordShowHide;
import Models.Auth.SendMailModel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.RandomStringUtils;

import Entities.Employees;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelForgotPassword extends JPanel {
	private JTextField jtextFieldCode;
	private JTextField jtextFieldEmail;
	private JLabel jIconSendMail;
	private PasswordShowHide JpanelNewPassword = new PasswordShowHide();
	private PasswordShowHide JLayoutConfirmPassword = new PasswordShowHide();
	/**
	 * Create the panel.
	 */
	public JPanelForgotPassword() {

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel Top_Fix = new JPanel();
		add(Top_Fix);
		Top_Fix.setLayout(new BorderLayout(0, 0));

		JPanel jpanelForm = new JPanel();
		add(jpanelForm);
		jpanelForm.setLayout(new BoxLayout(jpanelForm, BoxLayout.PAGE_AXIS));

		JLabel jlabelForgot = new JLabel("Reset Password");
		jlabelForgot.setMinimumSize(new Dimension(300, 80));
		jlabelForgot.setMaximumSize(new Dimension(300, 80));
		jlabelForgot.setPreferredSize(new Dimension(300, 120));
		jlabelForgot.setFont(new Font("Tahoma", Font.BOLD, 26));
		jlabelForgot.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelForgot.setAlignmentX(Component.CENTER_ALIGNMENT);
		jpanelForm.add(jlabelForgot);

		JPanel jpanelFormCode = new JPanel();
		jpanelForm.add(jpanelFormCode);
		jpanelFormCode.setLayout(new BoxLayout(jpanelFormCode, BoxLayout.PAGE_AXIS));

		JPanel jpanelEmail = new JPanel();
		jpanelFormCode.add(jpanelEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setPreferredSize(new Dimension(120, 30));
		lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setAlignmentX(0.5f);
		jpanelEmail.add(lblEmail);

		JPanel jpanelEmailText = new JPanel();
		jpanelEmailText.setPreferredSize(new Dimension(260, 25));
		jpanelEmail.add(jpanelEmailText);
		jpanelEmailText.setLayout(new BoxLayout(jpanelEmailText, BoxLayout.X_AXIS));

		jtextFieldEmail = new JTextField();
		jpanelEmailText.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		jIconSendMail = new JLabel("");
		jIconSendMail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jIconSendMail.setHorizontalAlignment(SwingConstants.CENTER);
		jIconSendMail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jIconSendMail_mouseClicked(e);
			}
		});
		jIconSendMail.setIcon(new ImageIcon("D:\\CODE\\JavaSwing_Project\\SIMS\\src\\Resources\\Icons\\sendmail.png"));
		jIconSendMail.setPreferredSize(new Dimension(33, 25));
		jpanelEmailText.add(jIconSendMail);

		JPanel jpanelVerifyText = new JPanel();
		jpanelFormCode.add(jpanelVerifyText);

		JLabel lblNewLabel = new JLabel("Verify Code:");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(120, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpanelVerifyText.add(lblNewLabel);

		JPanel jpanelTextField = new JPanel();
		jpanelTextField.setPreferredSize(new Dimension(260, 25));
		jpanelVerifyText.add(jpanelTextField);
		jpanelTextField.setLayout(new BoxLayout(jpanelTextField, BoxLayout.LINE_AXIS));

		jtextFieldCode = new JTextField();
		jpanelTextField.add(jtextFieldCode);
		jtextFieldCode.setColumns(16);
		
		JLabel jIconCheckCode = new JLabel("");
		jIconCheckCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jIconCheckCode_mouseClicked(e);
			}
		});
		jIconCheckCode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jIconCheckCode.setHorizontalAlignment(SwingConstants.CENTER);
		jIconCheckCode.setIcon(new ImageIcon("D:\\CODE\\JavaSwing_Project\\SIMS\\src\\Resources\\Icons\\Check-icon.png"));
		jIconCheckCode.setPreferredSize(new Dimension(33, 25));
		jpanelTextField.add(jIconCheckCode);
		
		JPanel jpanelNewPassword = new JPanel();
		
		
		jpanelFormCode.add(jpanelNewPassword);
		
		JLabel jLabelNewPass = new JLabel("New Password:");
		jLabelNewPass.setPreferredSize(new Dimension(120, 30));
		jLabelNewPass.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelNewPass.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelNewPass.setAlignmentX(0.5f);
		jpanelNewPassword.add(jLabelNewPass);
		JpanelNewPassword.setPreferredSize(new Dimension(255, 25));
		JpanelNewPassword.getPasswordField().setEditable(false);
		JpanelNewPassword.getPasswordField().setEchoChar('*');
		jpanelNewPassword.add(JpanelNewPassword);
		JPanel jpanelConfirmPassword = new JPanel();
		jpanelFormCode.add(jpanelConfirmPassword);
		
		JLabel jLabelComfirm = new JLabel("Confirm Password:");
		jLabelComfirm.setPreferredSize(new Dimension(120, 30));
		jLabelComfirm.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelComfirm.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelComfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelComfirm.setAlignmentX(0.5f);
		jpanelConfirmPassword.add(jLabelComfirm);
		JLayoutConfirmPassword.setPreferredSize(new Dimension(255, 25));
		JLayoutConfirmPassword.getPasswordField().setEditable(false);
		JLayoutConfirmPassword.getPasswordField().setEchoChar('*');
		jpanelConfirmPassword.add(JLayoutConfirmPassword);
		JPanel jpanelButton = new JPanel();
		jpanelButton.setBorder(new EmptyBorder(1, 0, 0, 0));
		FlowLayout flowLayout_2 = (FlowLayout) jpanelButton.getLayout();
		flowLayout_2.setVgap(20);
		flowLayout_2.setHgap(10);
		jpanelButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jpanelButton.setPreferredSize(new Dimension(10, 50));
		jpanelFormCode.add(jpanelButton);

		JButton jbtnSave = new JButton("Save");
		jbtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnOk_actionPerformed(e);
			}
		});
		jbtnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		jbtnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpanelButton.add(jbtnSave);

		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnCancel_actionPerformed(e);
			}
		});
		jbtnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpanelButton.add(jbtnCancel);

		JPanel Bottom_Fix = new JPanel();
		add(Bottom_Fix);
		Bottom_Fix.setLayout(new BorderLayout(0, 0));
	}

	public void jIconSendMail_mouseClicked(MouseEvent e) {
		EmailModel emailModel = new EmailModel();
		String verifyEmail = jtextFieldEmail.getText();
		Employees employees = emailModel.FindByEmail(verifyEmail);
		if(employees != null) {
			String verifyCodeString = employees.getToken();
			jtextFieldEmail.setEditable(false);
			SendMailModel.sendConfirmEmail(verifyEmail, verifyCodeString);
			JOptionPane.showMessageDialog(this, "Please Check Email Confirm Verify Code !","Message",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "The account is incorrect or does not exist !","Failed",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void jIconCheckCode_mouseClicked(MouseEvent e) {
		EmailModel emailModel = new EmailModel();
		Employees employees = emailModel.FindByEmail(jtextFieldEmail.getText());
		String token = employees.getToken();
		String validCode = jtextFieldCode.getText();
		if(token.equals(validCode)) {
			jtextFieldCode.setEditable(false);
			JpanelNewPassword.getPasswordField().setEditable(true);
			JLayoutConfirmPassword.getPasswordField().setEditable(true);
		}else {
			JOptionPane.showMessageDialog(this, "Invalid Verify Code !!","Failed",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void jbtnOk_actionPerformed(ActionEvent e) {
		String NewPassword = JpanelNewPassword.getPasswordAsString();
		String Confirm = JLayoutConfirmPassword.getPasswordAsString();
		String emailString = jtextFieldEmail.getText();
		EmailModel emailModel = new EmailModel();
		if ( !NewPassword.equals(Confirm)) {
			JOptionPane.showMessageDialog(this, "New Password & Confirm Password Do Not Match !!!");
			return;
		}else {
			if(emailModel.ChangePasswordByEmail(emailString, NewPassword)) {
				JOptionPane.showMessageDialog(this, "Reset Password Success, Please Try Login !!!","Success",JOptionPane.INFORMATION_MESSAGE);
				clearScreenGoLogin();
			}else {
				JOptionPane.showMessageDialog(this, "Reset Password Failed, Please Try Again !!!","Failed",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
	}

	public void jbtnCancel_actionPerformed(ActionEvent e) {
		clearScreenGoLogin();
		
	}

	private void clearScreenGoLogin() {
		removeAll();
		revalidate();
		repaint();
		JPanelLogin jLogin = new JPanelLogin();
		add(jLogin);
		jLogin.setVisible(true);
	}
}
