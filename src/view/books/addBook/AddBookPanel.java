package view.books.addBook;

import persistence.PrivateProperties;
import view.OakButton;
import view.OvalButton;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AddBookPanel extends JPanel {
    private final Font defaultFont = new Font("SansSerif", Font.BOLD, 18);
    private final PrivateProperties properties;
    private JButton addCover, saveBook;
    private JButton tittleLabel, descriptionLabel, authorLabel, yearLabel, ISBNLabel, copyNumberLabel;
    private JTextField tittleField, authorField, yearField, ISBNField, copiesField;
    private JTextArea descriptionArea;
    private JScrollPane scrollPane;
    private String pathCover;

    public AddBookPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        initComponents(actionListener, mouseListener);
        setBackground(new Color(233, 208, 208));
    }

    public String getPathCover() {
        return pathCover;
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        pathCover = properties.src_AddCoverPath();
        addCover = new JButton(new ImageIcon(pathCover));
        addCover.addActionListener(actionListener);
        addCover.addMouseListener(mouseListener);
        addCover.setActionCommand(properties.ac_AddCover());

        saveBook = new JButton(properties.btn_txt_saveBookButton());
        saveBook.addActionListener(actionListener);
        saveBook.addMouseListener(mouseListener);
        saveBook.setActionCommand(properties.ac_SaveBook());

        tittleLabel = new JButton(properties.btn_txt_addTittleLabel());
        descriptionLabel = new JButton(properties.btn_txt_addDescriptionLabel());
        authorLabel = new JButton(properties.btn_txt_addAuthorLabel());
        yearLabel = new JButton(properties.btn_txt_addYearLabel());
        ISBNLabel = new JButton(properties.btn_txt_addISBNLabel());
        copyNumberLabel = new JButton("<html>"+properties.btn_txt_addCopyNumberLabel()+"</html>");

        tittleField = new JTextField(14);
        descriptionArea = new JTextArea(5, 14);

        scrollPane = new JScrollPane(descriptionArea);

        authorField = new JTextField(14);
        yearField = new JTextField(14);
        ISBNField = new JTextField(14);
        copiesField = new JTextField(14);
        
        componentFeatures();
        addComponents();
    }

    private void addFileChooser(int pathNumber) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(properties.fc_description(), properties.fc_extension_1(), properties.fc_extension_2());
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = properties.src_BasicCoverPath() + pathNumber+file.getName().substring(file.getName().lastIndexOf("."));
            Path pathDestiny = Paths.get(path);
            Path pathOrigen = Paths.get(file.getAbsolutePath());
            Files.copy(pathOrigen, pathDestiny, StandardCopyOption.REPLACE_EXISTING);
            setPahCoverToNewBook(path);
            fileChooser.setVisible(false);
        }
    }

    private void componentFeatures() {
        addCover.setFocusable(false);
        addCover.setBackground(Color.WHITE);
        addCover.setPreferredSize(new Dimension(160, 257));

        setDefaultFont();
        setLabelsFeatures(tittleLabel);
        setLabelsFeatures(descriptionLabel);
        setLabelsFeatures(authorLabel);
        setLabelsFeatures(yearLabel);
        setLabelsFeatures(ISBNLabel);
        setLabelsFeatures(copyNumberLabel);

        saveBook.setFocusable(false);
        saveBook.setUI(new OvalButton(saveBook.getPreferredSize().width, saveBook.getPreferredSize().height, 25, 25, new Color(103, 195, 71)));
        saveBook.setBackground(new Color(255, 255, 255, 0));
        saveBook.setBorderPainted(false);
        saveBook.setContentAreaFilled(false);

        copiesField.setPreferredSize(new Dimension(14, 50));

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

    }

    private void setLabelsFeatures(JButton label) {
        label.setFocusable(false);
        label.setUI(new OakButton(label.getPreferredSize().width, label.getPreferredSize().height, 50, 50, new Color(182, 240, 107, 255), true, false, true, false));
        label.setBorderPainted(false);
        label.setContentAreaFilled(false);
    }

    private void setDefaultFont() {
        tittleLabel.setFont(defaultFont);
        descriptionLabel.setFont(defaultFont);
        authorLabel.setFont(defaultFont);
        yearLabel.setFont(defaultFont);
        ISBNLabel.setFont(defaultFont);
        copyNumberLabel.setFont(defaultFont);
        saveBook.setFont(new Font("SansSerif", Font.BOLD, 30));

        tittleField.setFont(defaultFont);
        descriptionArea.setFont(defaultFont);
        authorField.setFont(defaultFont);
        yearField.setFont(defaultFont);
        ISBNField.setFont(defaultFont);
        copiesField.setFont(defaultFont);

    }

    private void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(addCover, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        add(saveBook, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(tittleField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(authorField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        add(authorField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        add(yearField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        add(ISBNField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        add(copiesField, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(tittleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(authorLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(descriptionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(authorLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(yearLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        add(ISBNLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        add(copyNumberLabel, gbc);

    }

    public void setPahCoverToNewBook(String bookName) {
        this.pathCover = bookName;
        System.out.println(pathCover);
        addCover.setIcon(new ImageIcon(new ImageIcon(pathCover).getImage().getScaledInstance(136, 219, Image.SCALE_SMOOTH)));
    }

    public String getNewBookInfo() {
        return pathCover + properties.getSplitter() + tittleField.getText() + properties.getSplitter() +
                descriptionArea.getText() + properties.getSplitter() + authorField.getText() + properties.getSplitter() +
                yearField.getText() + properties.getSplitter() + ISBNField.getText() + properties.getSplitter() + copiesField.getText();
    }
    public void showFileChooser(int pathNumber){
        try {
            addFileChooser(pathNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanFields() {
        tittleField.setText("");
        authorField.setText("");
        yearField.setText("");
        descriptionArea.setText("");
        ISBNField.setText("");
        copiesField.setText("");
        addCover.setIcon(new ImageIcon(properties.ac_AddCover()));
    }
}
