package src.my.test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        filterDailyBeginData(list);


    }

    private static void filterDailyBeginData(List<Integer> assetTotalValueAndSnapShotTimeList) {
        for (int i = assetTotalValueAndSnapShotTimeList.size() - 1; i > 0; i--) {
            if (isEvenNumber(i)) {
                assetTotalValueAndSnapShotTimeList.remove(i);
            }
        }
    }

    private static Boolean isEvenNumber(Integer index) {
        return index % 2 == 0;
    }

}
