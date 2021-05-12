import ui.UserMainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //LoginForm loginForm=new LoginForm();
        UserMainForm userMainForm=new UserMainForm("333333");
        userMainForm.setVisible(true);
        userMainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
