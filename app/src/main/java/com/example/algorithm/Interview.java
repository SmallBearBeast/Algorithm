package com.example.algorithm;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interview {
    // 单季兵
    // 计算两个字符串的最大公共子串
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<Character> hashSet = new HashSet<>();

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

//        System.out.println(solution.getDuplicateString("sjkfjdfkdf", "sdf"));
//        int[] result = solution.getRandom(1000);
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < result.length; i++) {
//            set.add(result[i]);
//        }
//        System.out.println("size = " + set.size() + ", result = " + Arrays.toString(result));
//        String val = "\uD83C\uDF39";
//
//        System.out.println("defaultCharset = " + Charset.defaultCharset());
//        System.out.println("val.toCharArray = " + Arrays.toString(val.toCharArray()));
//        System.out.println("val.getBytes = " + Arrays.toString(val.getBytes()));
//        System.out.println("val.getBytes = " + Arrays.toString(val.getBytes()));
//        System.out.println("val = " + val);
//
//        String another = new String(new byte[]{
//                -16, -97, -104, -115
//        });
//        System.out.println("another = " + another);
//        System.out.println("another = " + solution.parseEmojiText("早上好[-16, -97, -104, -115][-16, -97, -104, -115]"));
//
//        String content = "[{\"text\":\"*好[-16, -97, -104, -115]\",\"type\":1},{\"text\":\"女嘉宾真漂亮[-16, -97, -104, -115]\",\"type\":2},{\"text\":\"女嘉宾喜欢什么样的男生？\",\"type\":2},{\"text\":\"你好，认识下吗？\",\"type\":2},{\"text\":\"[-16, -97, -104, -115]\",\"type\":1},{\"text\":\"很高兴认识你\",\"type\":1},{\"text\":\"红娘，求介绍对象\",\"type\":1},{\"text\":\"哈哈哈[-16, -97, -104, -124]\",\"type\":1}]";
//
//        solution.getDayPeriodText();

        int result = solution.getNearbyNum(new int[]{
                1, 2, 3, 4, 5, 6
        }, 10);
        System.out.println("result = " + result);
    }

    private static String getDuplicateString(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        for (int i = 0; i < char1.length; i++) {
            for (int j = 0; j < char2.length; j++) {
                if (char1[i] == char2[j] && hashSet.add(char1[i])) {
                    sb.append(char1[i]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 早上：5:00–8:00
     * 上午：8:00–12:00
     * 中午：12:00–13:00
     * 下午：13:00–19:00
     * 晚上：19:00–24:00
     * 凌晨：0:00–5:00
     */
    public String getDayPeriodText() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("hour = " + hour);
        if (hour >= 5 && hour < 8) {
            return "早上好";
        } else if (hour >= 8 && hour < 12) {
            return "上午好";
        } else if (hour >= 12 && hour < 13) {
            return "中午好";
        } else if (hour >= 13 && hour < 19) {
            return "下午好";
        } else if (hour >= 19 && hour < 24) {
            return "晚上好";
        }
        return null;
    }

    public String parseEmojiText(String text) {
        StringBuilder builder = new StringBuilder();
        String regex = "\\[(.+?)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int start = 0;
        while (matcher.find()) {
            String emojiStr = matcher.group();
            builder.append(text.substring(start, matcher.start()));
            start = matcher.end();
            try {
                emojiStr = emojiStr.substring(1, emojiStr.length() - 1);
                String[] emojiStrArray = emojiStr.split(",");
                byte[] emojiByteArray = new byte[emojiStrArray.length];
                for (int i = 0; i < emojiByteArray.length; i++) {
                    emojiByteArray[i] = Byte.parseByte(emojiStrArray[i].trim());
                }
                builder.append(new String(emojiByteArray, StandardCharsets.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
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

    public int minDistance(String word1, String word2) {
        return 1;
    }

    public int mySolution_1(String word1, String word2) {
        return 1;
    }

    public int mySolution_2(String word1, String word2) {
        return 1;
    }

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

    public int getNearbyNum(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (end - start <= 2) {
                if (Math.abs(nums[end] - val) > Math.abs(nums[start] - val)) {
                    return nums[start];
                }
                return nums[end];
            }
            int mid = (start + end) >> 1;
            if (nums[mid] < val) {
                start = mid;
            } else if (nums[mid] > val) {
                end = mid;
            } else {
                return nums[mid];
            }
        }
        return 0;
    }

    // 给定整数T和升序的数组A，找到一个最接近T的数字，知道是二分，但是没做出来，没有做题经验。
}
