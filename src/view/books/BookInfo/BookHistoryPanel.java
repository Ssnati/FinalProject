package view.books.BookInfo;

import persistence.PrivateProperties;
import view.OakButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class BookHistoryPanel extends JPanel {

    private final PrivateProperties properties;
    private JTable bookHistoryTable;
    private JButton bookHistoryLabel;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public BookHistoryPanel(PrivateProperties properties) {
        this.properties = properties;
        setLayout(new GridBagLayout());
        initComponent();
    }

    private void initComponent() {
        bookHistoryLabel = new JButton(properties.getBookHistoryDialogTitle());
        bookHistoryLabelFeatures();
        bookHistoryTable = new JTable();
        tableModel = new DefaultTableModel();
        scrollPane = new JScrollPane(bookHistoryTable);
        scrollProperties();
        setTableProperties();
        addComponents();
    }


    private void bookHistoryLabelFeatures() {
        bookHistoryLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        bookHistoryLabel.setUI(new OakButton(bookHistoryLabel.getPreferredSize().width, bookHistoryLabel.getPreferredSize().height + 5,
                25, 25, new Color(103, 195, 71), true, true, true, true));
        bookHistoryLabel.setForeground(new Color(0, 0, 0));
        bookHistoryLabel.setBorderPainted(false);
        bookHistoryLabel.setFocusPainted(false);

    }

    private void scrollProperties() {
        Dimension d = new Dimension(700, 200);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        scrollPane.getVerticalScrollBar().setValue(0);
        scrollPane.setMinimumSize(d);
        scrollPane.setMaximumSize(d);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private void setTableProperties() {
        bookHistoryTable.setModel(tableModel);
        tableModel.setColumnIdentifiers(new String[]{properties.tbl_0_column(), properties.tbl_1_column(), properties.tbl_2_column(), properties.tbl_3_column()});
        setTableHeaderProperties();

        bookHistoryTable.setRowHeight(30);
        bookHistoryTable.setFont(new Font("Arial", Font.PLAIN, 20));
        bookHistoryTable.setShowHorizontalLines(true);
        bookHistoryTable.setShowVerticalLines(true);
        bookHistoryTable.setBackground(new Color(233, 208, 208));

    }

    private void setTableHeaderProperties() {
        bookHistoryTable.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 20));
        bookHistoryTable.getTableHeader().setReorderingAllowed(false);
        bookHistoryTable.getTableHeader().setResizingAllowed(false);
        TableColumnModel columnModel = bookHistoryTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(bookHistoryLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);
    }

    public void showHistory(List<String> rentHistory) {
        tableModel.setRowCount(0);
        for (String s : rentHistory) {
            String[] data = s.split(properties.getSplitter());
            tableModel.addRow(data);
        }
    }
}
