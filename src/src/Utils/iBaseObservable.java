package Utils;

public interface iBaseObservable<ListenerType, InfoType> {
    public void addObserver(ListenerType observer);

    public void removeObserver(ListenerType observer);

    public void notifyListeners(InfoType info);
}
