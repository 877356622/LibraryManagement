import ui.LoginForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginForm loginForm=new LoginForm();
        loginForm.setVisible(true);
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
