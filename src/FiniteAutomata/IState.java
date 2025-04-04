package FiniteAutomata;

import java.util.*;

///
/// State Interface
public interface IState<T> {

    ///
    /// Add a transition from this state to a next state
    /// @param key character to transition on
    /// @param state destination state
    State<T> addTransition(T key, State<T> state);

    ///
    /// Removes a transition
    void removeTransition(T key);
    ///
    /// Retrieves all transitions
    Map<T, State<T>> getTransitions();

    /// Set new transitions
    void setTransitions(Map<T, State<T>> transitions);
    /// Get state name
    String getName();
    /// Set state name
    void setName(String name);
    /// Set state is active
    boolean isActive();
    /// Get state is active
    void setActive(boolean active);
    /// Get state message
    String getMessage();
    /// Get state type
    StateType getStateType();
    /// Set state type
    void setStateType(StateType stateType);
    /// Set state message
    void setMessage(String message) ;
}
