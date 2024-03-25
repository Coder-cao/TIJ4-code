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

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                integer = 0;
            }
            map.put(nums[i], integer + 1);
            if (integer + 1 > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }


    /**
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            integerSet.add(candyType[i]);
        }
        return Math.min(integerSet.size(), candyType.length / 2);
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大
     * 子字符串
     * 。
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int index = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (i == index - 1) {
                    index = i;
                    continue;
                }
                return index - i - 1;
            }
        }
        return index;
    }


    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOneV2(int[] digits) {
        int lowPlusBit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int bit = (digits[i] + lowPlusBit) % 10;
            if (bit == 0) {
                digits[i] = 0;
            } else {
                digits[i] = bit;
                return digits;
            }

        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long max = x / 2 + 2;
        long min = 0;
        while (true) {
            if (max == min + 1) {
                return (int) min;
            }
            long temp = (min + max) / 2;
            if (temp * temp > x) {
                max = temp;
                continue;
            }
            min = temp;
        }

    }


    /**
     * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
     * <p>
     * i < j < k ，
     * nums[j] - nums[i] == diff 且
     * nums[k] - nums[j] == diff
     * 返回不同 算术三元组 的数目
     *
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        res++;
                    }
                }
            }
        }
        return res;
    }


    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        int dp[] = new int[31];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < 31; i++) {
            long res = 3L * dp[i - 1];
            if (res > Integer.MAX_VALUE)
                break;
            dp[i] = (int) res;
            max = i;
        }
        for (int i = 0; i <= max; i++) {
            if (dp[i] == n)
                return true;

        }
        return false;
    }


    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给定 n ，请计算 F(n) 。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] fib = new int[31];
        fib[0] = 0;
        fib[1] = 1;
        if (n == 0) return fib[0];
        if (n == 1) return fib[1];
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * <p>
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * <p>
     * 不能使用任何内置的库函数，如  sqrt
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i < (num + 1) / 2 + 1; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }


    /**
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     * <p>
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.merge(key, 1, Integer::sum);
        }
        int res = 0;
        int haveMid = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                res = res + value;
                continue;
            }
            res = res + value - 1;
            haveMid++;
        }
        if (haveMid > 0) {
            res++;
        }
        return res;
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min + res) {
                res = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return res;
    }

    /**
     * 设计一个算法，算出 n 阶乘有多少个尾随零。
     */
    public int trailingZeroes(int n) {
        int res = 0;
        int count_2 = 0;
        int count_5 = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                temp = temp / 2;
                if (count_5 > 0) {
                    count_5--;
                    res++;
                } else {
                    count_2++;
                }
            }
            while (temp % 5 == 0) {
                temp = temp / 5;
                if (count_2 > 0) {
                    count_2--;
                    res++;
                } else {
                    count_5++;
                }
            }
        }
        return res;
    }





}