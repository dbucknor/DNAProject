package FiniteAutomata;

import java.util.*;

///
/// State class object to store information on state
///including transitions from the state
public class State<T> implements IState<T>{
    private String name;
    boolean active;
    private Map<T, State<T>> transitions;
    private StateType stateType;
    private String message;

    ///
    /// Creates a state with:
    /// @param name name of state
    /// @param active if the state is active
    /// @param stateType state type
    /// @implNote  Also initiates transitions list to an empty list and message to mull
    ///
    /// @see StateType
    public State(String name, boolean active, StateType stateType){
        this.stateType = stateType;
        this.name = name;
        this.active = active;
        this.transitions = new LinkedHashMap<>();
        this.message = null;
    }

    @Override
    public State<T> addTransition(T key, State<T> state){
        transitions.put(key, state);
        return this;
    }

    @Override
    public void removeTransition(T key){
        transitions.remove(key);
    }
    @Override
    public Map<T, State<T>> getTransitions() {
        return transitions;
    }
    @Override
    public void setTransitions(Map<T, State<T>> transitions) {
        this.transitions = transitions;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isActive() {
        return active;
    }
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public StateType getStateType() {
        return stateType;
    }
    @Override
    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FiniteAutomata.State{" +
                "name='" + name + '\'' +
                "message='" + message + '\'' +
                ", transitions=" + transitions.keySet() +
                '}';
    }
}
