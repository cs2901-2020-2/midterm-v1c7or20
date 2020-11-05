package midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<CommandsObservers> observers = new ArrayList<>();


    public void attach(CommandsObservers observer){
        observers.add(observer);
    }

    public void notifyAllObservers(Subject subject) throws IOException {
        for (CommandsObservers observer : observers) {
            observer.executeAndUpdate(subject);
        }
    }

}
