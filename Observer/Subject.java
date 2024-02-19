package Observer;

public interface Subject {
    
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    protected void notifyObservers();
}
