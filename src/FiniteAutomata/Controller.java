package FiniteAutomata;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.regex.Pattern;

/// Controller class
public class Controller {
    private LinkedList<String> charList; //stores user input
    private final DFA<String> dfa; // stores dfa object
    private final JFrame displayFrame; //stores main gui frame


    /// Creates a new controller object, initiates data members to default values and starts dfa configuration
    ///
    /// @param frame main gui frame
    public Controller(JFrame frame) {
        charList = new LinkedList<>();
        dfa = new DFA<>();
        this.displayFrame = frame;
        configureDfa();
    }

    /// Validates if input meets alphabet criteria
    public static boolean validateInput(String input) {
        return Pattern.matches("[acgt]+", input.toLowerCase());
    }

    /// Retrieves input from text field, validates the input and runs dfa evaluation
    ///
    /// @param textField text field
    /// @see JTextField
    public void getInputString(JTextField textField) {
        String input = textField.getText().toLowerCase().trim();
        if (validateInput(input)) {
            charList = new LinkedList<>();
            for (int i = 0; i < input.length(); i++) {
                charList.add(Character.toString(input.charAt(i)));
            }

            evaluateInput(); //start evaluation
        } else {
            System.err.println("Fail");
            JOptionPane.showMessageDialog(displayFrame, "DNA Sequence not valid!", "Input Rejected", JOptionPane.ERROR_MESSAGE);
            dfa.reset();
        }
    }

    /// Configures DFA for input validation.
    private void configureDfa() {
        State<String> q0 = new State<String>("q0", true, StateType.initial);
        State<String> q1 = new State<String>("q1", false, StateType.normal);
        State<String> q2 = new State<String>("q2", false, StateType.normal);
        State<String> q3 = new State<String>("q3", false, StateType.normal);

        State<String> q4 = new State<String>("q4", false, StateType.normal);
        State<String> q5 = new State<String>("q5", false, StateType.normal);
        State<String> q6 = new State<String>("q6", false, StateType.normal);
        State<String> q7 = new State<String>("q7", false, StateType.normal);

        State<String> q8 = new State<String>("q8", false, StateType.normal);
        State<String> q9 = new State<String>("q9", false, StateType.normal);
        State<String> q10 = new State<String>("q10", false, StateType.normal);
        State<String> q11 = new State<String>("q11", false, StateType.normal);

        State<String> q13 = new State<String>("q13", false, StateType.normal);
        State<String> q12 = new State<String>("q12", false, StateType.accept);

        State<String> q14 = new State<String>("q14", false, StateType.normal);
        State<String> q15 = new State<String>("q15", false, StateType.normal);

        State<String> q16 = new State<String>("q16", false, StateType.normal);
        State<String> q17 = new State<String>("q17", false, StateType.normal);
        State<String> q18 = new State<String>("q18", false, StateType.normal);

        //create transitions
        q0.addTransition("a", q1).addTransition("t", q0).addTransition("g", q0).addTransition("c", q0);
        q1.addTransition("a", q1).addTransition("t", q2).addTransition("g", q0).addTransition("c", q0);

        q2.addTransition("a", q1).addTransition("t", q3).addTransition("g", q3).addTransition("c", q0);
        q3.addTransition("a", q3).addTransition("t", q3).addTransition("g", q13).addTransition("c", q4);

        q4.addTransition("a", q5).addTransition("t", q3).addTransition("g", q3).addTransition("c", q4);
        q5.addTransition("a", q3).addTransition("t", q3).addTransition("g", q6).addTransition("c", q4);

        q6.addTransition("a", q3).addTransition("t", q3).addTransition("g", q3).addTransition("c", q7);
        q7.addTransition("a", q8).addTransition("t", q3).addTransition("g", q3).addTransition("c", q3);

        q8.addTransition("a", q3).addTransition("t", q3).addTransition("g", q9).addTransition("c", q3);
        q9.addTransition("a", q3).addTransition("t", q3).addTransition("g", q3).addTransition("c", q10);

        q10.addTransition("a", q11).addTransition("t", q3).addTransition("g", q3).addTransition("c", q3);
        q11.addTransition("a", q3).addTransition("t", q3).addTransition("g", q12).addTransition("c", q3);

        q12.addTransition("a", q18).addTransition("t", q18).addTransition("g", q18).addTransition("c", q18);
        q13.addTransition("a", q3).addTransition("t", q3).addTransition("g", q14).addTransition("c", q3);

        q14.addTransition("a", q3).addTransition("t", q15).addTransition("g", q14).addTransition("c", q3);
        q15.addTransition("a", q3).addTransition("t", q3).addTransition("g", q16).addTransition("c", q3);

        q16.addTransition("a", q17).addTransition("t", q3).addTransition("g", q3).addTransition("c", q3);
        q17.addTransition("a", q3).addTransition("t", q12).addTransition("g", q3).addTransition("c", q3);

        q18.addTransition("a", q3).addTransition("t", q3).addTransition("g", q3).addTransition("c", q3);

        //add states to dfa
        try {
            dfa.addState(q0).addState(q1).addState(q2).addState(q3).addState(q4).addState(q5).addState(q6).addState(q7)
                    .addState(q8).addState(q9).addState(q10).addState(q11).addState(q12).addState(q13).addState(q14)
                    .addState(q15).addState(q16).addState(q17).addState(q18);
        } catch (Exception e) {
            System.err.println(e.getMessage()); //output error to console
            JOptionPane.showMessageDialog(displayFrame, e.getMessage(), "Error Configuring States", JOptionPane.ERROR_MESSAGE); //display error to user
            SwingUtilities.getWindowAncestor(displayFrame).dispose(); //close program
        }
    }

    /// Evaluate user input by looping through the characters and using the transitions saved to the states to find
    /// paths to the accepts states(s). Output messages are shown as necessary.
    public void evaluateInput() {
        System.out.println("Starting Evaluation: ");
        System.out.println("Start: " + dfa.getCurrentState().toString());
        dfa.setCurrentState(dfa.getInitialState()); //update current state to initial state

        //check if current state is an accept state and input is finished
        if (dfa.getCurrentState().getStateType() == StateType.accept && charList.size() <= 1) {
            System.out.println("Accept: " + dfa.getCurrentState().toString());
            System.out.println("Pass");
            dfa.reset();
        }

        //loop through input and evaluate transitions
        for (String c : charList) {
            System.out.println("FiniteAutomata.Transition: " + c);

            //make transition if found
            if (dfa.getCurrentState().getTransitions().containsKey(c)) {
                dfa.getInitialState().setActive(false);
                State<String> nextState = dfa.getCurrentState().getTransitions().get(c);
                nextState.setActive(true);

                //updates start codon found
                if (Objects.equals(dfa.getCurrentState().getName(), "q3") || Objects.equals(nextState.getName(), "q3")) {
                    dfa.setStartCodonFound(true);
                }

                //update previous state
                dfa.setPreviousState(dfa.getCurrentState());
                dfa.getPreviousState().setActive(false);

                dfa.setCurrentState(nextState); // move to next state
                System.out.println("Current: " + dfa.getCurrentState().toString());
            } else {
                //if no transition found output error message
                System.err.println("Fail");
                JOptionPane.showMessageDialog(displayFrame, "DNA Sequence not valid!", "Input Rejected", JOptionPane.ERROR_MESSAGE);
                dfa.reset();
            }
        }

        //output error message if start codon was not found
        if (!dfa.isStartCodonFound()) {
            JOptionPane.showMessageDialog(displayFrame, "Start codon not found.", "", JOptionPane.INFORMATION_MESSAGE);
            dfa.reset();
            return;
        }

        //check if accept state has been reached
        if (dfa.getCurrentState().getStateType() == StateType.accept) {
            System.out.println("Accept: " + dfa.getCurrentState().toString());
            System.out.println("Pass");

            //check the previous state and output correct message to user
            if (Objects.equals(dfa.getPreviousState().getName(), "q17")) {
                JOptionPane.showMessageDialog(displayFrame, "Huntington's disease gene found", "", JOptionPane.INFORMATION_MESSAGE);
            }

            //check the previous state and output correct message to user
            if (Objects.equals(dfa.getPreviousState().getName(), "q11")) {
                JOptionPane.showMessageDialog(displayFrame, "Possible cancer mutation found.", "", JOptionPane.INFORMATION_MESSAGE);
            }

            dfa.reset();
        } else {
            //no patterns found so output message to user
            JOptionPane.showMessageDialog(displayFrame, "No significant patterns found", "", JOptionPane.INFORMATION_MESSAGE);
            dfa.reset();
        }
    }
}
