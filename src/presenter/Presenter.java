package presenter;

import model.Library;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Presenter implements ActionListener, MouseListener, KeyListener {
    private Library library;
    private View view;

    public Presenter() {
        this.view = new View(this, this,this);
        library = new Library();
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RENT")) {
            view.showRentDialog();
        }
        if (e.getActionCommand().equals("USERS")) {
            view.showUsersDialog();
        }
        if (e.getActionCommand().equals("BOOKS")) {
            view.showBooksDialog();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.mainPanelMouseOverButton(button);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            view.mainPanelMouseExitedButton(button);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
