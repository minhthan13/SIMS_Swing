package Models.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordShowHide extends JPanel {
	private JPasswordField passwordField;
	private JButton toggleButton;
	private boolean passwordVisible;
	private Icon showIcon;
	private Icon hideIcon;

	public PasswordShowHide() {
		this.setLayout(new BorderLayout());

		this.passwordField = new JPasswordField();
		this.passwordVisible = false;
		this.showIcon = resizeIcon(new ImageIcon("src/Resources/Icons/Show.png"), 24, 24);
		this.hideIcon = resizeIcon(new ImageIcon("src/Resources/Icons/Hide.png"), 24, 24);
		this.toggleButton = new JButton(showIcon);
		
		toggleButton.setPreferredSize(new Dimension(30, 25));
		toggleButton.setBorderPainted(false);
		toggleButton.setFocusPainted(false);
		toggleButton.setContentAreaFilled(false);
		toggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				togglePasswordVisibility();
			}
		});

		this.add(passwordField, BorderLayout.CENTER);
		this.add(toggleButton, BorderLayout.EAST);
	}

	private void togglePasswordVisibility() {
		passwordVisible = !passwordVisible;
		if (passwordVisible) {
			passwordField.setEchoChar((char) 0); 
			toggleButton.setIcon(hideIcon);
		} else {
			passwordField.setEchoChar('*'); 
			toggleButton.setIcon(showIcon);
		}
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public String getPasswordAsString() {
	    return new String(passwordField.getPassword()) ;
	}

	private Icon resizeIcon(Icon icon, int width, int height) {
		if (icon instanceof ImageIcon) {
			ImageIcon imageIcon = (ImageIcon) icon;
			Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			return new ImageIcon(image);
		}
		return icon;
	}
}
