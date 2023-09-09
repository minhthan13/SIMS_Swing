package Models.Auth.Validation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class SetFocusBorder {
	public static void addFocusBorder(JTextField textField) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
            }

            @Override
            public void focusLost(FocusEvent e) {
            	String text = textField.getText().trim();
                if (text.isEmpty()) {
                    textField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    textField.setBorder(UIManager.getBorder("TextField.border"));
                }
            }
        });
    }

    public static void addFocusBorderPassword(JPasswordField passwordField) {
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
            }

            @Override
            public void focusLost(FocusEvent e) {
            	 char[] password = passwordField.getPassword();
                 if (password.length == 0) {
                     passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                 } else {
                     passwordField.setBorder(UIManager.getBorder("PasswordField.border"));
                 }
            }
        });
    }
}
