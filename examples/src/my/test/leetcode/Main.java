package src.my.test.leetcode;

import static net.mindview.util.Print.print;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean valid = solution.isValid("(]");
//        System.out.println(
//                "结果：" + valid
//        );

//        ListNode list1 = new ListNode(0, new ListNode(2, new ListNode(4, new ListNode(6, null))));
//
//        ListNode list12 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7, null))));
//
//        ListNode listNode = solution.mergeTwoLists(list1, list12);
//
//        testPtr(listNode,list12);


        String bin1 = "11010";
        String bin2 =   "100";

        String s = solution.addBinary(bin1, bin2);
        print(s);

    }

    private static void testPtr(ListNode listNode1, ListNode listNode2) {
        while (listNode1 != null) {
            System.out.println("当前节点：" + listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
