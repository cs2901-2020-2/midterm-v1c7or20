package midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject extends Observable{
    private List<DataPoint<String, Integer>> data;

    public Subject(){
        super();
        data = new ArrayList<>();
    }

    public DataPoint<String, Integer> addData (String ind, Integer val) throws IOException {
        if (!data.isEmpty()){
            for (DataPoint<String, Integer> point : data){
                if (point.getIndex().equals(ind)){
                    return null;
                }
            }
        }
        DataPoint<String, Integer> dataPoint = new DataPoint<>(ind, val);
        data.add(dataPoint);
        super.notifyAllObservers();
        return dataPoint;
    }

    public DataPoint<String, Integer> removeData(String ind) throws IOException{
        if (!data.isEmpty()) {
            for (DataPoint<String, Integer> point : data) {
                if (point.getIndex().equals(ind)) {
                    data.remove(point);
                    return point;
                }
            }
        }
        super.notifyAllObservers();
        return null;
    }

    public List<DataPoint<String, Integer>> getData() {
        return data;
    }
}
