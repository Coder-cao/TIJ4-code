package src.my.test.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("请输入一行文本：");
//
//        try {
//            String input = reader.readLine();
//            System.out.println("您输入的内容是：" + input);
//        } catch (IOException e) {
//            System.err.println("发生异常：" + e.getMessage());
//        }

        Solution solution = new Solution();
//        boolean valid = solution.isValid("(]");
//        System.out.println(
//                "结果：" + valid
//        );

//        ListNode list1 = new ListNode(0, new ListNode(2, new ListNode(4, new ListNode(6, null))));
//
        ListNode list12 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, null))));
//
//        ListNode listNode = solution.mergeTwoLists(list1, list12);
//
//        testPtr(listNode,list12);


        int param = 1808548329;
        String text = "hello world";
        String brokenLetters = "ad";
        int[] array = {-1,0,3,5,9,12};
        int search = solution.search(array, 2);

        int name = 0;
        String oldName = "";

    }

    private static void testPtr(ListNode listNode1, ListNode listNode2) {
        while (listNode1 != null) {
            System.out.println("当前节点：" + listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
