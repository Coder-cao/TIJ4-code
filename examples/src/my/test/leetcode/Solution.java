package src.my.test.leetcode;

import java.util.*;

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


    public int countQuadruplets(int[] nums) {
        class ThreeSum {
            int sum(int target, int[] nums) {
                int sumCount = 0;
                for (int i = 0; i <= nums.length - 3; i++) {
                    for (int j = i + 1; j <= nums.length - 2; j++) {
                        for (int k = j + 1; k <= nums.length - 1; k++) {
                            if (nums[i] + nums[j] + nums[k] == target) {
                                sumCount++;
                            }
                        }
                    }
                }
                return sumCount;
            }
        }
        int result = 0;
        if (nums.length < 4) {
            return result;
        }
        for (int i = nums.length - 1; i > 2; i--) {
            ThreeSum threeSum = new ThreeSum();
            result += threeSum.sum(nums[i], Arrays.copyOfRange(nums, 0, i));
        }
        return result;
    }

    public int[] findEvenNumbers(int[] digits) {

        class Help {
            Integer get(int i, int j, int k) {
                if (i == 0 || k % 2 == 1) {
                    return null;
                }
                return i * 100 + j * 10 + k;
            }
        }

        Help help = new Help();

        Map<Integer, Integer> integerIntegerMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= digits.length - 3; i++) {
            for (int j = i + 1; j <= digits.length - 2; j++) {
                for (int k = j + 1; k <= digits.length - 1; k++) {

                    Integer integer1 = help.get(digits[i], digits[j], digits[k]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }
                    integer1 = help.get(digits[i], digits[k], digits[j]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }
                    integer1 = help.get(digits[j], digits[i], digits[k]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }
                    integer1 = help.get(digits[j], digits[k], digits[i]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }
                    integer1 = help.get(digits[k], digits[i], digits[j]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }
                    integer1 = help.get(digits[k], digits[j], digits[i]);
                    if (integer1 != null) {
                        integerIntegerMap.put(integer1, integer1);
                    }

                }
            }
        }
        int[] result = new int[integerIntegerMap.keySet().size()];
        int i = 0;
        for (Integer integer : integerIntegerMap.keySet()) {
            result[i] = integer;
            i++;
        }
        Arrays.sort(result);
        return result;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;

        return result;
    }


}