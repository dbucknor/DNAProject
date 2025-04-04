package FiniteAutomata;

import java.util.*;

///
/// Deterministic Finite Automata class
public class DFA<T> {
    private List<State<T>> states; // list of all states
    private State<T> initialState; // start state
    private State<T> currentState; // current state after transition
    private State<T> previousState;// previous state after transition
    private boolean startCodonFound;// flag if start codon was found

    ///
    /// Default constructor, initiates members to default values
    public DFA(){
        states = new ArrayList<>();
        previousState = null;
        startCodonFound = false;
    }

    /// Reset members to default values
    public void reset(){
        currentState = initialState;
        previousState = null;
        startCodonFound = false;
    }
    ///
    /// Add a new state, ensures that only one initial/start state can be given
    /// @throws Exception if multiple start states are provided
    public DFA<T> addState(State<T> state) throws Exception {
        if(initialState != null && state.getStateType() == StateType.initial){
            throw new Exception("Only 1 initial state allowed!");
        }else if (initialState == null && state.getStateType() == StateType.initial) {
            setInitialState(state);
        }else{
            states.add(state);
        }
        return this;
    }

    /// Remove a state
    public DFA<T> removeState(State<T> state){
        states.remove(state);
        return this;
    }

    /// @return all states
    public List<State<T>> getStates() {
        return states;
    }

    /// Sets states
    /// @param states list of states
    ///
    /// @see State
    public void setStates(List<State<T>> states) {
        this.states = states;
    }

    /// @return initialState
    public State<T> getInitialState() {
        return initialState;
    }

    /// Sets initialState
    /// removes previous initial state
    ///
    /// @param initialState new start state
    private void setInitialState(State<T> initialState) {
        states.remove(this.initialState);
        this.initialState = initialState;
        currentState = initialState;
        states.add(initialState);
    }

    /// @return current state
    public State<T> getCurrentState() {
        return currentState;
    }

    /// Sets current state
    public void setCurrentState(State<T> currentState) {
        this.currentState = currentState;
    }

    /// @return previous state after transition
    public State<T> getPreviousState() {
        return previousState;
    }

    ///  Sets previous state
    public void setPreviousState(State<T> previousState) {
        this.previousState = previousState;
    }
    /// @return start codon found or not
    public boolean isStartCodonFound() {
        return startCodonFound;
    }

    /// Updates if start codon was found
    public void setStartCodonFound(boolean startCodonFound) {
        this.startCodonFound = startCodonFound;
    }
}
