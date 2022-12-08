package view.user.userInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class UserInfoDialog extends JDialog {
    private UserInfoPanel userInfoPanel;
    public UserInfoDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener) {
        super(dialog, modal);
        setTitle("User Info");
        this.setSize(510,333);
        userInfoPanel = new UserInfoPanel(actionListener, mouseListener);
        getContentPane().add(userInfoPanel);
        setLocationRelativeTo(null);
    }

    public void showUserInfo(String userInfo) {
        userInfoPanel.showUserInfo(userInfo);
    }

    public String printSize() {
        return "Width: " + getPreferredSize().width + " Height: " + getPreferredSize().height;
    }
}
