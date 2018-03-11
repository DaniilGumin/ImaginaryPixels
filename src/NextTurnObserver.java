import com.sun.javafx.property.adapter.PropertyDescriptor;

import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

public class NextTurnObserver {
    private List<NextTurnListener> listeners = new ArrayList<>();

    public void subscribe(NextTurnListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(NextTurnListener listener) {
        listeners.remove(listener);
    }

    public void notify(int turn){
        for (NextTurnListener listener : listeners){
            listener.onNextTurn();
        }
    }
}
