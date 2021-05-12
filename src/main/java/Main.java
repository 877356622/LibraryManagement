import ui.LoginForm;
import ui.userMainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //LoginForm loginForm=new LoginForm();
        userMainForm userMainForm=new userMainForm("333333");
        userMainForm.setVisible(true);
        userMainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
