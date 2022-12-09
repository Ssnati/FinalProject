package view.user.userInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class UserInfoDialog extends JDialog {
    private UserInfoPanel userInfoPanel;
    public UserInfoDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        super(dialog, modal);
        setTitle(properties.getUserInfoDialogTitle());
        this.setSize(520,333);
        userInfoPanel = new UserInfoPanel(actionListener, mouseListener, properties);
        getContentPane().add(userInfoPanel);
        setLocationRelativeTo(null);
    }

    public void showUserInfo(String userInfo) {
        userInfoPanel.showUserInfo(userInfo);
    }
}
