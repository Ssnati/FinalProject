package view.books.addBook;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddBookDialog extends JDialog {

    public AddBookDialog(JDialog dialog, boolean modal, ActionListener listener) {
        super(dialog, modal);
        setTitle("Add Book");
        this.setSize(431,749);
        getContentPane().add(new AddBookPanel(listener));
        setLocationRelativeTo(null);
    }
}
