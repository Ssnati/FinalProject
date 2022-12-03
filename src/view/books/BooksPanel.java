package view.books;

import view.SearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BooksPanel extends JPanel {
    private JLabel titleLabel;
    private SearchPanel searchPanel;
    List<JButton> bookButtons;

    public BooksPanel(ActionListener listener) {
        bookButtons = new ArrayList<>();
        setLayout(new GridBagLayout());
        setBackground(new Color(108, 135, 126));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        titleLabel = new JLabel("Book List");
        searchPanel = new SearchPanel(listener);
        addTitleLabel();
        addSearchPanel(listener);
        addBooksListPanel(listener);
    }

    private void addBooksListPanel(ActionListener listener) {
        int counterX = 0;
        int counterY = 2;
        for (int i = 0; i < 6; i++) {
            JButton bookButton = new JButton(new ImageIcon("sources/covers/Cover1.png"));

            bookButton.setPreferredSize(new Dimension(136, 219));
            bookButton.addActionListener(listener);
            bookButton.setActionCommand("Book " + i);
            bookButton.setFocusable(false);
            bookButton.setBackground(new Color(0, 0, 0));

            bookButton.setFont(new Font("Sans Serif", Font.PLAIN, 13));
            if (counterX < 4) {
                setButtonCoordinates(bookButton, counterX, counterY);
                counterX++;
            } else if (counterX == 4) {
                setButtonCoordinates(bookButton, counterX, counterY);
                counterY++;
                counterX = 0;
            }
            bookButtons.add(bookButton);
        }
    }

    private void setButtonCoordinates(JButton bookButton, int counterX, int counterY) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = counterX;
        gbc.gridy = counterY;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 20;
        gbc.ipady = 20;
        add(bookButton, gbc);
    }

    private void addSearchPanel(ActionListener listener) {
        searchPanel.setWidthSearchBar(45);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(searchPanel, gbc);
    }

    private void addTitleLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(10, 0, 0, 0);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        add(titleLabel, gbc);
    }
}
