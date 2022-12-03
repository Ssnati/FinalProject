package view.books.BookInfo;

import view.OakButton;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookHistoryPanel extends JPanel {

    private JTable bookHistoryTable;
    private JButton backButton, bookHistoryLabel;
    private JScrollPane scrollPane;

    public BookHistoryPanel(ActionListener listener) {
        setLayout(new GridBagLayout());
        initComponent(listener);
    }

    private void initComponent(ActionListener listener) {
        bookHistoryLabel = new JButton("Book History");
        bookHistoryLabelFeatures();
        bookHistoryTable = new JTable(100, 3);
        scrollPane = new JScrollPane(bookHistoryTable);
        scrollProperties();
        fillTable();
        setTableProperties();
        backButton = new JButton(new ImageIcon("sources/Back.png"));
        backButtonFeatures(listener);
        addComponents();
    }

    private void backButtonFeatures(ActionListener listener) {
        backButton.addActionListener(listener);
        backButton.setActionCommand("back");
        Dimension dimension = new Dimension(50, 50);
        backButton.setPreferredSize(dimension);
        backButton.setMinimumSize(dimension);
        backButton.setMaximumSize(dimension);
        backButton.setBackground(new Color(0, 0, 0, 0));
        backButton.setBorderPainted(false);
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
        bookHistoryTable.setRowHeight(30);
        bookHistoryTable.setFont(new Font("Arial", Font.PLAIN, 20));
        bookHistoryTable.getTableHeader().setVisible(false);
        bookHistoryTable.setDefaultEditor(Object.class, null);
        bookHistoryTable.setShowHorizontalLines(true);
        bookHistoryTable.setShowVerticalLines(true);
        changeFirstColumnFont();
        bookHistoryTable.setBackground(new Color(233, 208, 208));
        for (int i = 0, j = 0; i < bookHistoryTable.getColumnCount(); i++) {
            String value = String.valueOf(bookHistoryTable.getValueAt(j, i));
            bookHistoryTable.getColumnModel().getColumn(i).setPreferredWidth(value.length() * 15);
        }
    }

    private void changeFirstColumnFont() {
        for (int i = 0; i < bookHistoryTable.getColumnCount(); i++) {
            bookHistoryTable.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (row == 0) {
                        c.setFont(new Font("Arial", Font.BOLD, 25));
                    }
                    return c;
                }
            });
        }
    }

    private void fillTable() {
        bookHistoryTable.setValueAt("Usuario", 0, 0);
        bookHistoryTable.setValueAt("Fecha de prestamo", 0, 1);
        bookHistoryTable.setValueAt("Fecha de devolucion", 0, 2);

        for (int i = 0; i < 4; i++) {
            bookHistoryTable.setValueAt("Usuario " + i, i + 1, 0);
            bookHistoryTable.setValueAt("Fecha de prestamo " + i, i + 1, 1);
            bookHistoryTable.setValueAt("Fecha de devolucion " + i, i + 1, 2);

        }
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(bookHistoryLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);
    }
}
