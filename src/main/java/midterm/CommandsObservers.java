package midterm;

import java.io.IOException;

public interface CommandsObservers {
    void executeAndUpdate(Subject data) throws IOException;
}
