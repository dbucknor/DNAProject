package FiniteAutomata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

///
/// GUI class.
/// Handles creation and display of all gui elements and interactions
public class InputScreen extends JFrame {
    private JTextField textField;
    private JButton button;
    private JPanel mainPanel;
    private final Controller controller;


///
/// Default constructor.
/// Initiates the controller class.
/// @see FiniteAutomata.Controller
    public InputScreen(){
        controller = new Controller(this);
    }

///
/// Adds an action listener to the button to start sequence evaluation
/// @see Controller
    private void loadListeners(){
        assert button != null;

        button.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.getInputString(textField);
                    }
                }
        );

    }

///
/// Starts GUI
    public void loadUI(){
        textField.setPreferredSize(new Dimension(600, 40));
        button.setPreferredSize(new Dimension(600, 30));

        this.setName("DNA Sequence Tester");
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setEnabled(true);

        this.add(mainPanel,BorderLayout.CENTER);

        loadListeners();
    }
}
