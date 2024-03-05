package src.my.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RefChange {

    public Integer value;

    public RefChange(Integer value) {
        this.value = value;
    }

    public static void main(String[] args) {
//        Integer val = 1;
//        RefChange refChange = new RefChange(val);
//        test(val,refChange);

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        for (Integer integer : integerList) {
            integerList.remove(integer);
        }


//        RefChange refChange = new RefChange(1);
//        test(refChange);
    }

    private static void test(Integer val, RefChange refChange) {
        val = val + 1;
        refChange.value = val;
    }

    private static void test(RefChange refChange) {
        Integer value = refChange.value;
        value = -1;
    }
}
