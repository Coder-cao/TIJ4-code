package src.my.test;

import java.util.List;

public class ListOpsTest<T> {

    private final List<T> list;

    public ListOpsTest(List<T> list) {
        this.list = list;
    }

    public Integer findIndexOf(T item) {
        return list.indexOf(item);
    }

}
