package view.rent;

import javax.swing.*;

public class SelectionDialog extends JDialog {
    private SelectionPanel selectionPanel;
    private ReturnPanel returnPanel;
    private RentPanel rentPanel;

    public SelectionDialog(JDialog dialog, boolean modal) {
        super(dialog, modal);
        setTitle("Selection");
        this.setSize(803,402);
        selectionPanel = new SelectionPanel();
        getContentPane().add(selectionPanel);
        setLocationRelativeTo(null);
    }
}
