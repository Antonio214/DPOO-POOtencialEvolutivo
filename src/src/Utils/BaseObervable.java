package Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseObervable<ListenerType, InfoType> {
    protected List<ListenerType> observers = new ArrayList<>();

    public void addObserver(ListenerType observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ListenerType observer) {
        this.observers.remove(observer);
    }

    abstract protected void notifyListeners(InfoType info);
}
