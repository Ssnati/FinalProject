package view.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UsersPanel extends JPanel {
    private JLabel titleLabel;
    private SearchPanel searchPanel;
    private List<JButton> userButtons;


    public UsersPanel(ActionListener listener) {
        userButtons = new ArrayList<>();
        setLayout(new GridBagLayout());
        setBackground(new Color(136, 164, 187));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        titleLabel = new JLabel("User List");
        addTitleLabel();
        addSearchPanel(listener);
        addUsersPanel(listener);
    }

    private void addUsersPanel(ActionListener listener) {
        String name = "User", rentedBooks = "4";
        int counterX = 0;
        int counterY = 2;
        for (int i = 0; i < 10; i++) {
            JButton userButton = new JButton(new ImageIcon("sources/userIcons/Male Icon "+counterY+".png"));
            userButton.setText("<html><center>Name: "+name+"<br>Rented Books: "+rentedBooks+"</center></html>");
            userButton.setHorizontalTextPosition( SwingConstants.CENTER );
            userButton.setVerticalTextPosition( SwingConstants.BOTTOM );

            userButton.setPreferredSize(new Dimension(136, 176));
            userButton.addActionListener(listener);
            userButton.setActionCommand("User " + i);
            userButton.setBorderPainted(false);
            userButton.setFocusable(false);
            userButton.setBackground(new Color(255, 0, 0));

            userButton.setFont(new Font("Sans Serif", Font.PLAIN, 13));
            if(counterX == 0){
                setButtonCoordinates(userButton, counterX, counterY);
                counterX++;
            } else if (counterX==1) {
                setButtonCoordinates(userButton, counterX, counterY);
                counterY++;
                counterX=0;
            }
            userButtons.add(userButton);
        }
    }

    private void setButtonCoordinates(JButton userButton, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(12, 20, 20, 7);
        add(userButton, gbc);
    }

    private void addSearchPanel(ActionListener listener) {
        searchPanel = new SearchPanel(listener);
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

}
