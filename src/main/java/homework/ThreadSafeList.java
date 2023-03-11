package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<T> {
    private List<T> list;

    public ThreadSafeList() {
        list = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T remove(int index) {
        return list.remove(index);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }

    @Override
    public synchronized String toString() {
        return "List {" + list +'}';
    }
}
