package view.user.userInfo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserInfoDialog extends JDialog {
    public UserInfoDialog(JDialog dialog, boolean modal, ActionListener listener) {
        super(dialog, modal);
        setTitle("User Info");
        this.setSize(308,298);
        getContentPane().add(new UserInfoPanel(listener));
        setLocationRelativeTo(null);
    }
}
