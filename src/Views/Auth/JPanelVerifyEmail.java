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
import Models.Auth.SendMailModel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.RandomStringUtils;

import Entities.Employees;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelVerifyEmail extends JPanel {
	private JTextField jtextFieldCode;
	private JTextField jtextFieldEmail;
	private JLabel jIconSendMail;

	/**
	 * Create the panel.
	 */
	public JPanelVerifyEmail() {

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel Top_Fix = new JPanel();
		add(Top_Fix);
		Top_Fix.setLayout(new BorderLayout(0, 0));

		JPanel jpanelForm = new JPanel();
		add(jpanelForm);
		jpanelForm.setLayout(new BoxLayout(jpanelForm, BoxLayout.PAGE_AXIS));

		JLabel jlabelVerify = new JLabel("Verify Account");
		jlabelVerify.setMinimumSize(new Dimension(300, 60));
		jlabelVerify.setMaximumSize(new Dimension(300, 60));
		jlabelVerify.setPreferredSize(new Dimension(300, 80));
		jlabelVerify.setFont(new Font("Tahoma", Font.BOLD, 26));
		jlabelVerify.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelVerify.setAlignmentX(Component.CENTER_ALIGNMENT);
		jpanelForm.add(jlabelVerify);

		JPanel jpanelFormCode = new JPanel();
		jpanelForm.add(jpanelFormCode);
		jpanelFormCode.setLayout(new BoxLayout(jpanelFormCode, BoxLayout.PAGE_AXIS));

		JPanel jpanelEmail = new JPanel();
		jpanelFormCode.add(jpanelEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setPreferredSize(new Dimension(80, 30));
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
		jIconSendMail.setPreferredSize(new Dimension(35, 25));
		jpanelEmailText.add(jIconSendMail);

		JPanel jpanelVerifyText = new JPanel();
		jpanelFormCode.add(jpanelVerifyText);

		JLabel lblNewLabel = new JLabel("Verify Code:");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(80, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpanelVerifyText.add(lblNewLabel);

		JPanel jpanelTextField = new JPanel();
		jpanelTextField.setPreferredSize(new Dimension(260, 25));
		jpanelVerifyText.add(jpanelTextField);
		jpanelTextField.setLayout(new BoxLayout(jpanelTextField, BoxLayout.LINE_AXIS));

		jtextFieldCode = new JTextField();
		jpanelTextField.add(jtextFieldCode);
		jtextFieldCode.setColumns(16);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(35, 25));
		jpanelTextField.add(lblNewLabel_1);

		JPanel jpanelButton = new JPanel();
		jpanelButton.setBorder(new EmptyBorder(1, 0, 0, 0));
		FlowLayout flowLayout_2 = (FlowLayout) jpanelButton.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		jpanelButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jpanelButton.setPreferredSize(new Dimension(10, 50));
		jpanelFormCode.add(jpanelButton);

		JButton jbtnOk = new JButton("OK");
		jbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnOk_actionPerformed(e);
			}
		});
		jbtnOk.setHorizontalTextPosition(SwingConstants.CENTER);
		jbtnOk.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpanelButton.add(jbtnOk);

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
		String verifyEmail = jtextFieldEmail.getText().trim();
		Employees employees = emailModel.FindByEmail(verifyEmail);
		if(employees != null) {
			String verifyCodeString = employees.getToken();
			jtextFieldEmail.setEditable(false);
			SendMailModel.sendConfirmEmail(verifyEmail, verifyCodeString);
			JOptionPane.showMessageDialog(null, "Please Check Email Confirm Verify Code !","Message",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "The account is incorrect or does not exist !","Failed",JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public void jbtnOk_actionPerformed(ActionEvent e) {
		String emailString = jtextFieldEmail.getText();
		String codeString = jtextFieldCode.getText();
		if (emailString.isEmpty() || codeString.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter Email and Verify Code !!");
			return;
		}
		EmailModel emailModel = new EmailModel();
		if (emailModel.VerifyEmail(emailString, codeString) == true) {
			JOptionPane.showMessageDialog(null, "Successful Account Verification", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			clearScreen();
			JPanelLogin jLogin = new JPanelLogin();
			add(jLogin);
			jLogin.setVisible(true);
		}
	}

	public void jbtnCancel_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelLogin jLogin = new JPanelLogin();
		add(jLogin);
		jLogin.setVisible(true);
	}

	private void clearScreen() {
		removeAll();
		revalidate();
		repaint();
	}
}