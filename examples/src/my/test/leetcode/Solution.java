package src.my.test.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return false;
        }
        String temp = s;
        for (int i = 0; i < s.length() / 2; i++) {
            temp = temp.replace("{}", "");
            temp = temp.replace("[]", "");
            temp = temp.replace("()", "");
        }
        if (temp.length() == 0) {
            return true;
        }
        return false;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        List<ListNode> listNodeList = new ArrayList<ListNode>(100);
        while (list1 != null || list2 != null) {
            ListNode currentMin;
            if (list1 == null) {
                listNodeList.add(list2);
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                listNodeList.add(list1);
                list1 = list1.next;
                continue;
            }
            if (list1.val <= list2.val) {
                currentMin = list1;
                list1 = list1.next;
            } else {
                currentMin = list2;
                list2 = list2.next;
            }
            listNodeList.add(currentMin);
        }

        for (int i = 0; i < listNodeList.size() - 1; i++) {
            listNodeList.get(i).next = listNodeList.get(i + 1);
        }
        return listNodeList.get(0);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int mod = (digits[i] + 1) % 10;
            digits[i] = mod;
            if (mod != 0) {
                break;
            }
            if (i == 0) {
                return plusOne(digits.length + 1);
            }
        }
        return digits;
    }

    private int[] plusOne(int size) {
        int[] result = new int[size];
        result[0] = 1;
        return result;
    }


    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.abs(a.length() - b.length()); i++) {
            stringBuilder.append("0");
        }
        if (a.length() < b.length()) {
            a = stringBuilder + a;
        } else {
            b = stringBuilder + b;
        }

        int  moreSum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= a.length(); i++) {
            int tempSum =  Integer.parseInt(String.valueOf(a.charAt(a.length() - i))) + Integer.parseInt(String.valueOf(b.charAt(a.length() - i)));
            if (tempSum + moreSum == 0) {
                result.append(0);
                moreSum = 0;
            } else if (tempSum + moreSum == 1) {
                result.append(1);
                moreSum = 0;
            } else if (tempSum + moreSum == 2) {
                result.append(0);
                moreSum = 1;
                if (i == a.length()) {
                    result.append(1);
                }
            } else {
                result.append(1);
                moreSum = 1;
                if (i == a.length()) {
                    result.append(1);
                }
            }

        }
        return result.reverse().toString();
    }


}