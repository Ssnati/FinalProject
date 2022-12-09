package view.user;

import view.SearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class UsersPanel extends JPanel {
    private MouseListener mouseListener;
    private ActionListener actionListener;
    private JLabel titleLabel;
    private SearchPanel searchPanel;
    private List<JButton> userButtons;
    private int userIndex;

    public UsersPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        userIndex = -1;
        userButtons = new ArrayList<>();
        this.actionListener = actionListener;
        this.mouseListener = mouseListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(136, 164, 187));
        initComponents(keyListener);
    }

    private void initComponents(KeyListener keyListener) {
        titleLabel = new JLabel("User List");
        addTitleLabel();
        addSearchPanel(actionListener, mouseListener, keyListener);
    }

    private void setButtonCoordinates(JButton userButton, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(12, 20, 20, 7);
        add(userButton, gbc);
    }

    private void addSearchPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        searchPanel = new SearchPanel(actionListener, mouseListener, keyListener);
        searchPanel.setActionCommandAddButton("ADD_USER");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(searchPanel, gbc);
    }

    private void addTitleLabel() {
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);
    }

    public void loadUsers(List<String> users) {
        userButtons.forEach(this::remove);
        userButtons.clear();
        for (int i = 0; i < users.size(); i++) {
            addUser(users.get(i), i);
        }
        setButtonCoordinates();
    }

    private void setButtonCoordinates() {
        int counterX = 0;
        int counterY = 2;
        for (JButton userButton : userButtons) {
            if (userButton!=null){
                if (counterX == 0) {
                    setButtonCoordinates(userButton, counterX, counterY);
                    counterX++;
                } else if (counterX == 1) {
                    setButtonCoordinates(userButton, counterX, counterY);
                    counterY++;
                    counterX = 0;
                }
            }
        }
    }

    private void addUser(String user, int index) {
        String[] userArray = user.split(";");
        JButton userButton = new JButton(new ImageIcon(userArray[0]));
        userButton.setText("<html><center>Name: " + userArray[1] + "<br>Rented Books: " + userArray[5] + "</center></html>");
        userButton.setHorizontalTextPosition(SwingConstants.CENTER);
        userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        userButton.setPreferredSize(new Dimension(136, 176));
        userButton.addActionListener(actionListener);
        userButton.addMouseListener(mouseListener);
        userButton.setActionCommand("USER_" + index);
        userButton.setBorderPainted(false);
        userButton.setFocusable(false);
        userButton.setBackground(Color.red);
        userButton.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        userButtons.add(userButton);
    }

    public int getUsersListSize() {
        return userButtons.size();
    }

    public String getUserInfo(int index) {
        String text = userButtons.get(index).getText().replace("<html><center>Name: ", "");
        return text.substring(0, text.indexOf("<br>"));
    }

    public void setTextInSearchFieldUsers() {
        searchPanel.setTextInSearchField();
    }

    public String getSearchFieldTextUsers() {
        return searchPanel.getTextInSearchField();
    }

    public void removeUser(int userIndex) {
        JButton button = userButtons.get(userIndex);
        userButtons.set(userIndex, null);
        setButtonCoordinates();
        remove(button);
    }

    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
    }

    public int getUserIndex() {
        return userIndex;
    }

    public void loadNewUser(String newUserInfo) {
        addUser(newUserInfo, userButtons.size());
        setButtonCoordinates();
    }

    public JComponent getSearchPanel() {
        return searchPanel;
    }

    public void hidePlusButtons() {
        searchPanel.hidePlusButtons();
    }

    public void showPlusButton() {
        searchPanel.showPlusButton();
    }
}
