package view.books.BookInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class BookInfoPanel extends JPanel {
    private final Font font = new Font("Sans Serif", Font.BOLD, 20);
    private JLabel bookTitleLabel, bookDescriptionLabel, bookAuthorLabel, bookYearLabel, bookISBNLabel, bookAvailableCopiesLabel, bookTotalCopiesLabel;
    private JButton coverButton, deleteButton, historyButton, addCopyButton, removeCopyButton;

    public BookInfoPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        setLayout(new GridBagLayout());
        initComponents(actionListener, mouseListener);
        setBackground(Color.WHITE);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        bookTitleLabel = new JLabel("1984");
        bookAuthorLabel = new JLabel("<html><body><b>Author:</b> George Orwell</body></html>");

        bookDescriptionLabel = new JLabel("<html><body><b>Book Description:</b> It is a dark and stormy night. Winston Smith, his chin nuzzled into his breast in an effort to escape the vile wind, slipped quickly through the glass doors of Victory Mansions, though not quickly enough to prevent a swirl of gritty dust from entering along with him.</body></html>");
        setBreakLines(bookDescriptionLabel);

        bookYearLabel = new JLabel("<html><body><b>Year:</b> 1949</body></html>");
        bookISBNLabel = new JLabel("<html><body><b>ISBN:</b> 978-0451524935</body></html>");
        bookAvailableCopiesLabel = new JLabel("<html><body><b>Available Copies:</b> 9</body></html>");
        bookTotalCopiesLabel = new JLabel("<html><body><b>Total Copies:</b> 18</body></html>");

        coverButton = new JButton(new ImageIcon(new ImageIcon("sources/covers/Cover1.jpg").getImage().getScaledInstance(136, 219, Image.SCALE_AREA_AVERAGING)));
        coverButtonFeatures();
        deleteButton = new JButton("<html><body>Borrar Libro</body></html>");
        deleteButton.setActionCommand("DELETE_BOOK");
        deleteButton.addActionListener(actionListener);
        deleteButton.addMouseListener(mouseListener);

        historyButton = new JButton("<html><body><center>Ver historial de <br>prestamos</center></body></html>");
        historyButton.setActionCommand("HISTORY_BOOK");
        historyButton.addActionListener(actionListener);
        historyButton.addMouseListener(mouseListener);

        addCopyButton = new JButton("<html><body>Agregar copia</body></html>");
        addCopyButton.setActionCommand("ADD_COPY");
        addCopyButton.addActionListener(actionListener);
        addCopyButton.addMouseListener(mouseListener);

        removeCopyButton = new JButton("<html><body>Eliminar copia</body></html>");
        removeCopyButton.setActionCommand("REMOVE_COPY");
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

        historyButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        historyButton.setBackground(new Color(90, 133, 64));
        historyButton.setForeground(Color.WHITE);
        historyButton.setFocusable(false);
        deleteButton.setFont(new Font("Sans Serif", Font.BOLD, 25));
        deleteButton.setBackground(new Color(255, 0, 0));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
        addCopyButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addCopyButton.setBackground(new Color(42, 108, 207));
        addCopyButton.setForeground(Color.WHITE);
        addCopyButton.setFocusable(false);
        removeCopyButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
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
            if (lineLength > 70) {
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
        String[] bookInfo = bookToView.split(";");
        coverButton.setIcon(new ImageIcon(new ImageIcon(bookInfo[0]).getImage().getScaledInstance(136, 219, Image.SCALE_AREA_AVERAGING)));
        bookTitleLabel.setText(bookInfo[1]);
        bookAuthorLabel.setText("<html><body><b>Author:</b> " + bookInfo[2] + "</body></html>");
        bookYearLabel.setText("<html><body><b>Year:</b> " + bookInfo[3] + "</body></html>");
        bookDescriptionLabel.setText("<html><body><b>Book Description:</b> " + bookInfo[4] + "</body></html>");
        setBreakLines(bookDescriptionLabel);
        bookISBNLabel.setText("<html><body><b>ISBN:</b> " + bookInfo[5] + "</body></html>");
        bookAvailableCopiesLabel.setText("<html><body><b>Available Copies:</b> " + bookInfo[6] + "</body></html>");
        bookTotalCopiesLabel.setText("<html><body><b>Total Copies:</b> " + bookInfo[7] + "</body></html>");
    }
}
