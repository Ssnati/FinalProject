package view.user.addUser;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddUserDialog extends JDialog {
    public AddUserDialog(JDialog dialog, boolean modal, ActionListener listener) {
        super(dialog, modal);
        setTitle("Add User");
        setSize(739,321);
        getContentPane().add(new AddUserPanel(listener));
        setLocationRelativeTo(null);
    }
}
