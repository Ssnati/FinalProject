package view.books.BookInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class BookInfoPanel extends JPanel {
    private final Font font = new Font("Sans Serif", Font.BOLD, 20);
    private final PrivateProperties properties;
    private JLabel bookTitleLabel, bookDescriptionLabel, bookAuthorLabel, bookYearLabel, bookISBNLabel, bookAvailableCopiesLabel, bookTotalCopiesLabel;
    private JButton coverButton, deleteButton, historyButton, addCopyButton, removeCopyButton;

    public BookInfoPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        setLayout(new GridBagLayout());
        initComponents(actionListener, mouseListener);
        setBackground(Color.WHITE);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        bookTitleLabel = new JLabel();
        bookAuthorLabel = new JLabel();

        bookDescriptionLabel = new JLabel();
        setBreakLines(bookDescriptionLabel);

        bookYearLabel = new JLabel();
        bookISBNLabel = new JLabel();
        bookAvailableCopiesLabel = new JLabel();
        bookTotalCopiesLabel = new JLabel();

        coverButton = new JButton(new ImageIcon(new ImageIcon(properties.src_AddBookIcon()).getImage().getScaledInstance(136, 219, Image.SCALE_AREA_AVERAGING)));
        coverButtonFeatures();
        deleteButton = new JButton("<html><body>" + properties.btn_txt_deleteBookButton() + "</body></html>");
        deleteButton.setActionCommand(properties.ac_deleteBook());
        deleteButton.addActionListener(actionListener);
        deleteButton.addMouseListener(mouseListener);

        historyButton = new JButton("<html><body><center>" + properties.btn_txt_historyBookButton() + "</center></body></html>");
        historyButton.setActionCommand(properties.ac_historyBook());
        historyButton.addActionListener(actionListener);
        historyButton.addMouseListener(mouseListener);

        addCopyButton = new JButton("<html><body>" + properties.btn_txt_addCopyBookButton() + "</body></html>");
        addCopyButton.setActionCommand(properties.ac_addCopyBook());
        addCopyButton.addActionListener(actionListener);
        addCopyButton.addMouseListener(mouseListener);

        removeCopyButton = new JButton("<html><body>" + properties.btn_txt_removeCopyBookButton() + "</body></html>");
        removeCopyButton.setActionCommand(properties.ac_removeCopyBook());
        removeCopyButton.addActionListener(actionListener);
        removeCopyButton.addMouseListener(mouseListener);

        labelFonts();
        addComponents();
    }

    private void labelFonts() {
        Font altFont = new Font("Sans Serif", Font.PLAIN, 13);
        bookTitleLabel.setFont(font);
        bookDescriptionLabel.setFont(altFont);
        bookAuthorLabel.setFont(altFont);
        bookYearLabel.setFont(altFont);
        bookISBNLabel.setFont(altFont);
        bookAvailableCopiesLabel.setFont(altFont);
        bookTotalCopiesLabel.setFont(altFont);

        historyButton.setFont(font);
        historyButton.setBackground(new Color(90, 133, 64));
        historyButton.setForeground(Color.WHITE);
        historyButton.setFocusable(false);
        deleteButton.setFont(new Font("Sans Serif", Font.BOLD, 25));
        deleteButton.setBackground(new Color(255, 0, 0));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
        addCopyButton.setFont(font);
        addCopyButton.setBackground(new Color(42, 108, 207));
        addCopyButton.setForeground(Color.WHITE);
        addCopyButton.setFocusable(false);
        removeCopyButton.setFont(font);
        removeCopyButton.setBackground(new Color(42, 108, 207));
        removeCopyButton.setForeground(Color.WHITE);
        removeCopyButton.setFocusable(false);
    }

    private void setBreakLines(JLabel label) {
        String text = label.getText().replace("<html><body>", "");
        String[] words = text.split(" ");
        String newText = "";
        int lineLength = 0;
        for (String word : words) {
            newText += word + " ";
            lineLength += word.length();
            if (lineLength > 90) {
                newText += "<br>";
                lineLength = 0;
            }
        }
        newText = "<html><body>" + newText + "</body></html>";
        label.setText(newText);
    }

    private void coverButtonFeatures() {
        coverButton.setPreferredSize(new Dimension(146, 229));
        coverButton.setBorderPainted(false);
        coverButton.setFocusable(false);
        coverButton.setBackground(Color.BLACK);
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 40);
        add(coverButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        add(bookTitleLabel, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bookDescriptionLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(bookAuthorLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(bookYearLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add(bookISBNLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        add(bookAvailableCopiesLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        add(bookTotalCopiesLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(historyButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        add(removeCopyButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 8;
        add(addCopyButton, gbc);

        gbc.gridx = 4;
        gbc.gridy = 8;
        add(deleteButton, gbc);
    }

    public void showBookInfo(String bookToView) {
        String[] bookInfo = bookToView.split(properties.getSplitter());
        coverButton.setIcon(new ImageIcon(new ImageIcon(bookInfo[0]).getImage().getScaledInstance(136, 219, Image.SCALE_AREA_AVERAGING)));
        bookTitleLabel.setText(bookInfo[1]);
        bookAuthorLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelAuthor() + "</b> " + bookInfo[2] + "</body></html>");
        bookYearLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelYear() + "</b> " + bookInfo[3] + "</body></html>");
        bookDescriptionLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelDescription() + "</b> " + bookInfo[4] + "</body></html>");
        setBreakLines(bookDescriptionLabel);
        bookISBNLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelISBN() + "</b> " + bookInfo[5] + "</body></html>");
        bookAvailableCopiesLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelAvailableCopies() + "</b> " + bookInfo[6] + "</body></html>");
        bookTotalCopiesLabel.setText("<html><body><b>" + properties.btn_txt_bookInfoPanelTotalCopies() + "</b> " + bookInfo[7] + "</body></html>");
    }
}

