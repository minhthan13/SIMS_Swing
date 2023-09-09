package Views.Auth;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import org.apache.commons.lang3.RandomStringUtils;

import Entities.Employees;
import Entities.Positons;
import Models.Auth.RegisterModel;
import Models.Auth.SendMailModel;
import Models.Auth.Validation.InputValidator;
import Models.Auth.Validation.SetFocusBorder;
import Models.Positions.PositionModel;

import javax.swing.ImageIcon;

public class JPanelRegister extends JPanel {
	private JTextField jtextFieldUsername;
	private JTextField jtextFieldPassword;
	private JTextField jtextFieldConfirm;
	private JTextField jtextFieldEmail;
	private JComboBox<Positons> jcomboBoxPositions;
	private JTextField jtextFieldTel;
	private JTextField jtextFieldAddress;
	private File selectedFile = null;
	private JLabel jlabelImage;

	/**
	 * Create the panel.
	 */
	public JPanelRegister() {

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel Top_Fix = new JPanel();
		add(Top_Fix);
		Top_Fix.setLayout(new BorderLayout(0, 0));

		JPanel jpanelForm = new JPanel();
		add(jpanelForm);
		jpanelForm.setLayout(new BoxLayout(jpanelForm, BoxLayout.PAGE_AXIS));

		JLabel jlabelRegister = new JLabel("Register");
		jlabelRegister.setMinimumSize(new Dimension(300, 60));
		jlabelRegister.setMaximumSize(new Dimension(300, 60));
		jlabelRegister.setPreferredSize(new Dimension(300, 150));
		jlabelRegister.setFont(new Font("Tahoma", Font.BOLD, 26));
		jlabelRegister.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
		jpanelForm.add(jlabelRegister);

		JPanel jpanelFormRegister = new JPanel();
		jpanelForm.add(jpanelFormRegister);
		jpanelFormRegister.setLayout(new BorderLayout(20, 15));

		JPanel Left_Fix = new JPanel();
		Left_Fix.setSize(new Dimension(10, 0));
		jpanelFormRegister.add(Left_Fix, BorderLayout.WEST);
		Left_Fix.setLayout(new BorderLayout(0, 0));

		JPanel Center_Content = new JPanel();
		jpanelFormRegister.add(Center_Content, BorderLayout.CENTER);
		Center_Content.setLayout(new BoxLayout(Center_Content, BoxLayout.LINE_AXIS));

		JPanel Left_Form = new JPanel();
		Center_Content.add(Left_Form);
		Left_Form.setLayout(new BoxLayout(Left_Form, BoxLayout.PAGE_AXIS));

		JPanel jpanelUsername = new JPanel();
		Left_Form.add(jpanelUsername);
		jpanelUsername.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(40, 0));
		jpanelUsername.add(lblNewLabel_1);

		JPanel jpanelLabel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpanelLabel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		jpanelLabel.setPreferredSize(new Dimension(140, 25));
		jpanelUsername.add(jpanelLabel);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setAlignmentX(0.5f);
		jpanelLabel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		jpanelLabel.add(lblNewLabel_2);

		JPanel jpanelTextUsername = new JPanel();
		jpanelTextUsername.setPreferredSize(new Dimension(200, 25));
		jpanelUsername.add(jpanelTextUsername);
		jpanelTextUsername.setLayout(new BoxLayout(jpanelTextUsername, BoxLayout.X_AXIS));

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setColumns(16);
		jpanelTextUsername.add(jtextFieldUsername);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setPreferredSize(new Dimension(40, 0));
		jpanelUsername.add(lblNewLabel_1_2);

		JPanel jpanelPassword = new JPanel();
		Left_Form.add(jpanelPassword);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(40, 0));
		jpanelPassword.add(lblNewLabel_3);

		JPanel jpanelLabel2 = new JPanel();
		jpanelLabel2.setPreferredSize(new Dimension(140, 25));
		FlowLayout flowLayout_1 = (FlowLayout) jpanelLabel2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		jpanelPassword.add(jpanelLabel2);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setAlignmentX(0.5f);
		jpanelLabel2.add(lblPassword);

		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		jpanelLabel2.add(lblNewLabel_2_1);

		JPanel jpanelPass = new JPanel();
		jpanelPass.setPreferredSize(new Dimension(200, 25));
		jpanelPassword.add(jpanelPass);
		jpanelPass.setLayout(new BoxLayout(jpanelPass, BoxLayout.X_AXIS));

		jtextFieldPassword = new JTextField();
		jtextFieldPassword.setColumns(10);
		jpanelPass.add(jtextFieldPassword);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setPreferredSize(new Dimension(40, 0));
		jpanelPassword.add(lblNewLabel_1_3);

		JPanel jpanelConfirmPass = new JPanel();
		Left_Form.add(jpanelConfirmPass);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(40, 0));
		jpanelConfirmPass.add(lblNewLabel_1_1_1);

		JPanel jpanelLabel2_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) jpanelLabel2_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		jpanelLabel2_1.setPreferredSize(new Dimension(140, 25));
		jpanelConfirmPass.add(jpanelLabel2_1);

		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setAlignmentX(0.5f);
		jpanelLabel2_1.add(lblConfirmPassword);

		JLabel lblNewLabel_2_1_1 = new JLabel("*");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		jpanelLabel2_1.add(lblNewLabel_2_1_1);

		JPanel jpanelConfirm = new JPanel();
		jpanelConfirm.setPreferredSize(new Dimension(200, 25));
		jpanelConfirmPass.add(jpanelConfirm);
		jpanelConfirm.setLayout(new BoxLayout(jpanelConfirm, BoxLayout.X_AXIS));

		jtextFieldConfirm = new JTextField();
		jtextFieldConfirm.setColumns(10);
		jpanelConfirm.add(jtextFieldConfirm);

		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setPreferredSize(new Dimension(40, 0));
		jpanelConfirmPass.add(lblNewLabel_1_4);

		JPanel jpanelEmail = new JPanel();
		Left_Form.add(jpanelEmail);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setPreferredSize(new Dimension(40, 0));
		jpanelEmail.add(lblNewLabel_1_1);

		JPanel jpanelLabel2_1_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) jpanelLabel2_1_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		jpanelLabel2_1_1.setPreferredSize(new Dimension(140, 25));
		jpanelEmail.add(jpanelLabel2_1_1);

		JLabel lbla = new JLabel("Email:");
		lbla.setHorizontalTextPosition(SwingConstants.CENTER);
		lbla.setHorizontalAlignment(SwingConstants.LEFT);
		lbla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla.setAlignmentX(0.5f);
		jpanelLabel2_1_1.add(lbla);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("*");
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		jpanelLabel2_1_1.add(lblNewLabel_2_1_1_1);

		JPanel jpanelMail = new JPanel();
		jpanelMail.setPreferredSize(new Dimension(200, 25));
		jpanelEmail.add(jpanelMail);
		jpanelMail.setLayout(new BoxLayout(jpanelMail, BoxLayout.X_AXIS));

		jtextFieldEmail = new JTextField();
		jpanelMail.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setPreferredSize(new Dimension(40, 0));
		jpanelEmail.add(lblNewLabel_1_5);

		JPanel Right_Form = new JPanel();
		Right_Form.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(30, 144, 255)));
		Center_Content.add(Right_Form);
		Right_Form.setLayout(new BoxLayout(Right_Form, BoxLayout.PAGE_AXIS));

		JPanel jpanelPosition = new JPanel();
		Right_Form.add(jpanelPosition);
		jpanelPosition.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setPreferredSize(new Dimension(40, 0));
		jpanelPosition.add(lblNewLabel_1_1_2);

		JPanel jpanelLabel2_1_1_1 = new JPanel();
		jpanelLabel2_1_1_1.setPreferredSize(new Dimension(100, 25));
		jpanelPosition.add(jpanelLabel2_1_1_1);
		jpanelLabel2_1_1_1.setLayout(new BoxLayout(jpanelLabel2_1_1_1, BoxLayout.X_AXIS));

		JLabel lbla_1 = new JLabel("Position");
		lbla_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbla_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbla_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla_1.setAlignmentX(0.5f);
		jpanelLabel2_1_1_1.add(lbla_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("*");
		lblNewLabel_2_1_1_1_1.setForeground(Color.RED);
		jpanelLabel2_1_1_1.add(lblNewLabel_2_1_1_1_1);

		JPanel JPanelComboBox = new JPanel();
		JPanelComboBox.setPreferredSize(new Dimension(220, 25));
		jpanelPosition.add(JPanelComboBox);
		JPanelComboBox.setLayout(new BoxLayout(JPanelComboBox, BoxLayout.X_AXIS));

		jcomboBoxPositions = new JComboBox();
		JPanelComboBox.add(jcomboBoxPositions);

		JPanel jpanelTelephone = new JPanel();
		Right_Form.add(jpanelTelephone);
		jpanelTelephone.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("");
		lblNewLabel_1_1_2_1.setPreferredSize(new Dimension(40, 0));
		jpanelTelephone.add(lblNewLabel_1_1_2_1);

		JPanel jpanelLabel2_1_1_1_1 = new JPanel();
		jpanelLabel2_1_1_1_1.setPreferredSize(new Dimension(100, 25));
		jpanelTelephone.add(jpanelLabel2_1_1_1_1);
		jpanelLabel2_1_1_1_1.setLayout(new BoxLayout(jpanelLabel2_1_1_1_1, BoxLayout.X_AXIS));

		JLabel lbla_1_1 = new JLabel("Telephone:");
		lbla_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbla_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbla_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla_1_1.setAlignmentX(0.5f);
		jpanelLabel2_1_1_1_1.add(lbla_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("*");
		lblNewLabel_2_1_1_1_1_1.setForeground(Color.RED);
		jpanelLabel2_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1);

		JPanel jpanelTextPhone = new JPanel();
		jpanelTextPhone.setPreferredSize(new Dimension(220, 25));
		jpanelTelephone.add(jpanelTextPhone);
		jpanelTextPhone.setLayout(new BoxLayout(jpanelTextPhone, BoxLayout.X_AXIS));

		jtextFieldTel = new JTextField();
		jpanelTextPhone.add(jtextFieldTel);
		jtextFieldTel.setColumns(10);

		JPanel jpanelAddress = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) jpanelAddress.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		Right_Form.add(jpanelAddress);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("");
		lblNewLabel_1_1_2_1_1.setPreferredSize(new Dimension(40, 0));
		jpanelAddress.add(lblNewLabel_1_1_2_1_1);

		JPanel jpanellabel = new JPanel();
		jpanellabel.setPreferredSize(new Dimension(100, 25));
		jpanelAddress.add(jpanellabel);
		jpanellabel.setLayout(new BoxLayout(jpanellabel, BoxLayout.X_AXIS));

		JLabel lbla_1_1_1 = new JLabel("Address:");
		lbla_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbla_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbla_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla_1_1_1.setAlignmentX(0.5f);
		jpanellabel.add(lbla_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("*");
		lblNewLabel_2_1_1_1_1_1_1.setForeground(Color.RED);
		jpanellabel.add(lblNewLabel_2_1_1_1_1_1_1);

		JPanel jpanelTextAddress = new JPanel();
		jpanelTextAddress.setPreferredSize(new Dimension(220, 25));
		jpanelAddress.add(jpanelTextAddress);
		jpanelTextAddress.setLayout(new BoxLayout(jpanelTextAddress, BoxLayout.X_AXIS));

		jtextFieldAddress = new JTextField();
		jpanelTextAddress.add(jtextFieldAddress);
		jtextFieldAddress.setColumns(10);

		JPanel jpanelImage = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) jpanelImage.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		Right_Form.add(jpanelImage);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("");
		lblNewLabel_1_1_2_1_1_1.setPreferredSize(new Dimension(40, 0));
		jpanelImage.add(lblNewLabel_1_1_2_1_1_1);

		JPanel jPanelLabel = new JPanel();
		jPanelLabel.setPreferredSize(new Dimension(100, 120));
		jpanelImage.add(jPanelLabel);
		jPanelLabel.setLayout(new BoxLayout(jPanelLabel, BoxLayout.PAGE_AXIS));

		JLabel lbla_1_1_1_1 = new JLabel("Image:");
		lbla_1_1_1_1.setMaximumSize(new Dimension(120, 25));
		lbla_1_1_1_1.setPreferredSize(new Dimension(100, 14));
		lbla_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbla_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbla_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla_1_1_1_1.setAlignmentX(0.5f);
		jPanelLabel.add(lbla_1_1_1_1);

		JButton jbtnBrowse = new JButton("Browse");
		jbtnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBrowse_actionPerformed(e);

			}
		});

		jlabelImage = new JLabel("");
		jlabelImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelImage.setSize(new Dimension(120, 120));
		jlabelImage.setPreferredSize(new Dimension(120, 120));
		jpanelImage.add(jlabelImage);
		jbtnBrowse.setForeground(SystemColor.textHighlight);
		jbtnBrowse.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		jbtnBrowse.setBorderPainted(false);
		jbtnBrowse.setContentAreaFilled(false);
		jbtnBrowse.setFocusPainted(false);
		jbtnBrowse.setIcon(new ImageIcon("D:\\CODE\\JavaSwing_Project\\SIMS\\src\\Resources\\Icons\\add2.png"));
		jbtnBrowse.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtnBrowse.setAlignmentX(Component.CENTER_ALIGNMENT);
		jpanelImage.add(jbtnBrowse);

		JPanel Rigth_fix = new JPanel();
		jpanelFormRegister.add(Rigth_fix, BorderLayout.EAST);
		Rigth_fix.setLayout(new BorderLayout(0, 0));

		JPanel jpanelButton = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) jpanelButton.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		jpanelButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jpanelButton.setPreferredSize(new Dimension(10, 50));
		jpanelFormRegister.add(jpanelButton, BorderLayout.SOUTH);

		JButton jbtnRegister = new JButton("Register");
		jbtnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateInput()) {
					jbtnRegister_actionPerformed(e);
				}
			}
		});
		jpanelButton.add(jbtnRegister);

		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnCancel_actionPerformed(e);
			}
		});
		jpanelButton.add(jbtnCancel);

		JPanel Bottom_Fix = new JPanel();
		add(Bottom_Fix);
		Bottom_Fix.setLayout(new BorderLayout(0, 0));

		initPanel();
		// focus model.auth.validation
		SetFocusBorder.addFocusBorder(jtextFieldUsername);
		SetFocusBorder.addFocusBorder(jtextFieldPassword);
		SetFocusBorder.addFocusBorder(jtextFieldConfirm);
		SetFocusBorder.addFocusBorder(jtextFieldEmail);
		SetFocusBorder.addFocusBorder(jtextFieldTel);
		SetFocusBorder.addFocusBorder(jtextFieldAddress);
		
	}

	private void initPanel() {
		PositionModel positionModel = new PositionModel();
		DefaultComboBoxModel<Positons> model = new DefaultComboBoxModel<Positons>();

		for (Positons positons : positionModel.ShowPosition()) {
			model.addElement(positons);
		}
		jcomboBoxPositions.setModel(model);
		jcomboBoxPositions.setRenderer(new PositionsBox());
	}

	public void jbtnRegister_actionPerformed(ActionEvent e) {
		try {
			Employees employee = new Employees();
			employee.setUsername(jtextFieldUsername.getText());
			employee.setPassword(jtextFieldPassword.getText());
			employee.setEmail(jtextFieldEmail.getText());
			Positons positons = (Positons) jcomboBoxPositions.getSelectedItem();
			employee.setPosition_id(positons.getPosition_id());
			employee.setTel(jtextFieldTel.getText());
			employee.setAddress(jtextFieldAddress.getText());
			String verifyCodeString = RandomStringUtils.random(8, true, true);
			employee.setToken(verifyCodeString);
			byte[] bytes = null;
			if (selectedFile != null) {
				bytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
			}
			employee.setImage(bytes);
			RegisterModel registerModel = new RegisterModel();
			if (registerModel.Register(employee)) {
				int result = JOptionPane.showOptionDialog(this,
						"Please go to email '" + jtextFieldEmail.getText() + "' to verify your account",
						"Register Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_CANCEL_OPTION, null, null,
						null);
				SendMailModel.sendConfirmEmail(employee.getEmail(), verifyCodeString);
				if (result == JOptionPane.OK_OPTION) {
					ClearScreen();
					JPanelVerifyEmail jVerifyEmail = new JPanelVerifyEmail();
					add(jVerifyEmail);
					jVerifyEmail.setVisible(true);
				} else {
					ClearScreen();
					JPanelLogin jLogin = new JPanelLogin();
					add(jLogin);
					jLogin.setVisible(true);
				}

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	public void jbtnCancel_actionPerformed(ActionEvent e) {
		JPanelLogin jLogin = new JPanelLogin();
		ClearScreen();
		add(jLogin);
		jLogin.setVisible(true);
	}

	public void jbtnBrowse_actionPerformed(ActionEvent e) {
		JFileChooser jFileChooser = new JFileChooser("C:\\Users\\Krantz\\Desktop\\img");
		jFileChooser.setDialogTitle("Select a Photo");
		jFileChooser.setMultiSelectionEnabled(false);
		int result = jFileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = jFileChooser.getSelectedFile();
			int width = jlabelImage.getWidth();
			int height = jlabelImage.getHeight();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
					.getScaledInstance(width, height, Image.SCALE_DEFAULT));
			jlabelImage.setIcon(imageIcon);
		}
	}

	private class PositionsBox extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Positons positons = (Positons) value;
			return super.getListCellRendererComponent(list, positons.getPosition_name(), index, isSelected,
					cellHasFocus);
		}

	}

	private boolean validateInput() {
		String username = jtextFieldUsername.getText();
		String password = jtextFieldPassword.getText();
		String confirmPassword = jtextFieldConfirm.getText();
		String email = jtextFieldEmail.getText();
		String tel = jtextFieldTel.getText();
		String address = jtextFieldAddress.getText();

		if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || tel.isEmpty()
				|| address.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter complete information !!", "Failed",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "Password and confirm password do not match !!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (InputValidator.isValidEmail(email)) {
			InputValidator.showErrorMessage(this, "Incorrect email format !!");
			return false;
		}
		if (InputValidator.isValidPhoneNumber(tel)) {
			InputValidator.showErrorMessage(this, "Incorrect Telephone number format !!");
			return false;
		}
		return true;
	}

	private void ClearScreen() {
		removeAll();
		revalidate();
		repaint();
	}
}