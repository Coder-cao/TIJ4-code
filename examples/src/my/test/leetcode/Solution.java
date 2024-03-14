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


    /**
     * 回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        for (int i = 0; i < str.length() / 2; i++) {
            boolean b = str.charAt(i) == str.charAt(str.length() - i - 1);
            if (!b) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给你一个 非严格递增排列 的数组 nums ，
     * 请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * 然后返回 nums 中唯一元素的个数。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int cur;
        int count = 1;
        tag:
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (cur < nums[j]) {
                    nums[i + 1] = nums[j];
                    count++;
                    continue tag;
                }
                if (j == nums.length - 1) {
                    break tag;
                }
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
        return count;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
            return memo[n];
        }
    }


}