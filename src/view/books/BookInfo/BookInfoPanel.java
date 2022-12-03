package view.books.BookInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookInfoPanel extends JPanel {
    private final Font font = new Font("Sans Serif", Font.BOLD, 20);
    private JLabel bookTitleLabel, bookDescriptionLabel, bookAuthorLabel, bookYearLabel, bookISBNLabel, bookAvailableCopiesLabel, bookTotalCopiesLabel;
    private JButton coverButton, deleteButton, historyButton;

    public BookInfoPanel(ActionListener listener) {
        setLayout(new GridBagLayout());
        initComponents(listener);
        setBackground(Color.WHITE);
    }

    private void initComponents(ActionListener listener) {
        bookTitleLabel = new JLabel("1984");
        bookAuthorLabel = new JLabel("<html><body><b>Author:</b> George Orwell</body></html>");

        bookDescriptionLabel = new JLabel("<html><body><b>Book Description:</b> It is a dark and stormy night. Winston Smith, his chin nuzzled into his breast in an effort to escape the vile wind, slipped quickly through the glass doors of Victory Mansions, though not quickly enough to prevent a swirl of gritty dust from entering along with him.</body></html>");
        setBreakLines(bookDescriptionLabel);

        bookYearLabel = new JLabel("<html><body><b>Year:</b> 1949</body></html>");
        bookISBNLabel = new JLabel("<html><body><b>ISBN:</b> 978-0451524935</body></html>");
        bookAvailableCopiesLabel = new JLabel("<html><body><b>Available Copies:</b> 9</body></html>");
        bookTotalCopiesLabel = new JLabel("<html><body><b>Total Copies:</b> 18</body></html>");

        coverButton = new JButton(new ImageIcon(new ImageIcon("sources/covers/Cover1.png").getImage().getScaledInstance(136, 219, Image.SCALE_AREA_AVERAGING)));
        coverButtonFeatures();
        deleteButton = new JButton("<html><body>Borrar Libro</body></html>");
        historyButton = new JButton("<html><body><center>Ver historial de <br>prestamos</center></body></html>");

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
        deleteButton.setFont(new Font("Sans Serif", Font.BOLD, 30));
        deleteButton.setBackground(new Color(255, 0, 0));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
    }

    private void setBreakLines(JLabel label) {
        String text = label.getText().replace("<html><body>", "");
        text = text.replace("</body></html>", "");
        for (int i = 0; i < text.length(); i++) {
            if ((i % 100 == 0)&& (i != 0)) {
                boolean isSpace = false;
                while (!isSpace) {
                    if(text.charAt(i) == ' '){
                        text = text.substring(0, i) + "<br>" + text.substring(i);
                        isSpace = true;
                    } else i++;
                }
            }
        }
        label.setText("<html><body>"+text+"</html></body>");
    }

        private void coverButtonFeatures () {
            coverButton.setPreferredSize(new Dimension(146, 229));
            coverButton.setBorderPainted(false);
            coverButton.setFocusable(false);
            coverButton.setBackground(Color.BLACK);
        }

        private void addComponents () {
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
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.NONE;
            gbc.insets = new Insets(10, 10, 10, 10);
            add(historyButton, gbc);

            gbc.gridx = 3;
            gbc.gridy = 8;
            gbc.gridwidth = 2;
            add(deleteButton, gbc);
        }
    }
