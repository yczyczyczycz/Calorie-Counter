package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<UserObserver> observers = new ArrayList<>();

    public void addObserver(UserObserver uo)
    {
        if(!observers.contains(uo))
        {
            observers.add(uo);
        }
    }

    public void notifyObservers(double bmr)
    {
        for(UserObserver o : observers)
        {
            o.update(bmr);
        }
    }

}
