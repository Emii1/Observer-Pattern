package de.tum.in.ase.eist;

import java.util.*;

public abstract class Subject<T> {
    // TODO realize observer pattern
    private Set<Observer<T>> observers = new HashSet<>();

    public void subscribe(Observer observer) {
        Objects.requireNonNull(observer);
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        Objects.requireNonNull(observer);
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer<T> observer : observers){
            observer.update(getUpdate());
        }

    }
    abstract T getUpdate();
}
