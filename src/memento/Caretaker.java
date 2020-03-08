package memento;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> history;

    public Caretaker() {
        history = new ArrayList<>();
    }

    public void add(Memento memento) {
        history.add(memento);
    }

    public Memento get(int index) {
        return history.get(index);
    }
}
