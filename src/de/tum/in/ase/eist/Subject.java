package de.tum.in.ase.eist;

import java.util.*;

public abstract class Subject<T> {
    // TODO realize observer pattern
    private final Set<Observer<T>> observers = new HashSet<>();

    public void subscribeObserver(Observer<T> observer) {
        Objects.requireNonNull(observer);
        observers.add(observer);
    }

    public void unsubsribeObserver(Observer<T> observer) {
        Objects.requireNonNull(observer);
        observers.remove(observer);
    }
    protected void notifyObservers(final T changedState) {
        for (Observer<T> observer : observers){
            observer.getUpdate(changedState);
        }

    }
}
