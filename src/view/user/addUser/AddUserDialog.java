package view.user.addUser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AddUserDialog extends JDialog {
    private AddUserPanel addUserPanel;

    public AddUserDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener) {
        super(dialog, modal);
        setTitle("Add User");
        setSize(739, 321);
        addUserPanel = new AddUserPanel(actionListener, mouseListener);
        getContentPane().add(addUserPanel);
        setLocationRelativeTo(null);
    }

    public void setPahToUserIcon(String actionCommand) {
        addUserPanel.setPahToUserIcon(actionCommand);
    }

    public String getNewUserInfo() {
        return addUserPanel.getNewUserInfo();
    }
    public void clearFields() {
        addUserPanel.clearFields();
    }
}
