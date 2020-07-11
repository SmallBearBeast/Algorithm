package com.example.algorithm;

import com.example.algorithm.leetcode.Solution_Module;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Interview {
    public static void main(String[] args) {
        Interview solution = new Interview();
//        int result = solution.getMaxSumChildArr(new int[] {
//                1, 2, 3, -7
//        });
//        System.out.println("result = " + result);
//
//        generateArr(10);

//        Interview interview = new Interview();
//        int[] sum = {1, -2, -33, 4};
//        System.out.println(interview.getTotalSum(sum));
//        int[] result = solution.getRandom(1000);
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < result.length; i++) {
//            set.add(result[i]);
//        }
//        System.out.println("size = " + set.size() + ", result = " + Arrays.toString(result));

        System.out.println(solution.getDuplicateString("sjkfjdfkdf","sdf"));
    }

    public int minDistance(String word1, String word2) {
        return 1;
    }

    public int mySolution_1(String word1, String word2) {
        return 1;
    }

    public int mySolution_2(String word1, String word2) {
        return 1;
    }

    // 陈双的代码
//    public static void main(String[] args) {
//        int[] arr = {4, -1, 6,2 , -3, 6};
//
//        int result = getMaxSumChildArr(arr);
//        System.out.print("result = " + result);
//    }

//    public static int getMaxSumChildArr(int[] arr) {
//        if (arr == null) {
//            return -1;
//        }
//
//        int maxSum = 0;
//
//        int len = arr.length;
//        int tempSum = 0;
//        // 从第一个开始遍历求出最大的和
//        for(int i = 0; i < len; i++) {
//            int cur = arr[i];
//            if (i == 0) maxSum = cur;
//            tempSum = 0;
//            // 当这个值小于0，直接从下一个数开始
//            if (cur < 0 && cur < maxSum) continue;
//            // 求出从这个数开始子数组最大的值
//            for(int j = i; j < len; j++) {
//                tempSum += arr[j];
//                // 如果和大于当前保存的最大值，纪录开始位置和结束位置
//                if(tempSum > maxSum) {
//                    maxSum = tempSum;
//                }
//            }
//        }
//        return maxSum;
//
//    }
//

//
//    /**
//     * 生成长度为n的随机数组，数组的取值范围再1到n，不能重复
//     */
//    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        //int a = in.nextInt();
//        //System.out.println(a);
//        int[] result = generateArr(10);
//        if (result == null) return;
//        for(int i = 0;i < result.length; i++) {
//            System.out.print(result[i] + "  ");
//        }
//    }
//
//    public static int[] generateArr(int n) {
//        if(n <= 0) return null;
//        int[] arr = new int[n];
//
//        // 方法一：
//        Random random = new Random();
//        HashSet<Integer> set = new HashSet<>();
//        int count = 0;
//        while(count < n) {
//            int a = random.nextInt(n) + 1;
//            if(set.contains(a)) continue;
//            set.add(a);
//            arr[count] = a;
//            count++;
//        }
//
//        //
//        return arr;
//    }


    // 石熙的代码，命名很有问题，三次遍历
//    public int getTotalSum(int[] sum){
//        int bigSum = 0;
//        int arrayStart = 0;
//        int arrayEnd = 0;
//
//        for(int startIndex = 0; startIndex <= sum.length - 1; startIndex++){
//            for(int endIndex = startIndex; endIndex <= sum.length - 1; endIndex++ ){
//                int sumNum = getSum(sum, startIndex, endIndex);
//
//                if(sumNum > bigSum){
//                    arrayStart = startIndex;
//                    arrayEnd = endIndex;
//                    bigSum = sumNum;
//                }
//            }
//        }
//
//        return bigSum;
//    }
//
//    public int getSum(int[] sum, int startIndex, int endIndex){
//        int sumNum = 0;
//
//        for(int index=startIndex; index <= endIndex; index++) {
//            sumNum+=sum[index];
//        }
//
//        return sumNum;
//    }

    public int[] getRandom(int n) {
        int[] result = new int[n];
        Random random = new Random(n);
        for (int i = 0; i < result.length; i++) {
            int cur = random.nextInt(n) + 1;
            while (result[cur - 1] < 0) {
                cur = random.nextInt(n) + 1;
            }
            if (result[i] == Integer.MIN_VALUE) {
                result[i] = -cur;
            } else {
                result[i] = cur;
            }
            result[cur - 1] = result[cur - 1] * -1;
            if (result[cur - 1] == 0) {
                result[cur - 1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            result[i] = result[i] * -1;
        }
        return result;
    }


    // 单季兵
    // 计算两个字符串的最大公共子串
    private static StringBuilder sb= new StringBuilder();
    private static HashSet<Character> hashSet = new HashSet<>();
    private static String getDuplicateString(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        for(int i = 0; i < char1.length; i++) {
            for(int j = 0; j < char2.length; j++) {
                if(char1[i] == char2[j] && hashSet.add(char1[i])) {
                    sb.append(char1[i]);
                }
            }
        }
        return sb.toString();
    }

    // 给定整数T和升序的数组A，找到一个最接近T的数字，知道是二分，但是没做出来，没有做题经验。
}
