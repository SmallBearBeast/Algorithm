package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Sort {
    public static void main(String[] args) {
        Solution_Sort solution = new Solution_Sort();
        int[] result = new int[]{
                0, 33, 100, 5, 1, 7, 9
        };
//        solution.quickSort_3(result);
//        solution.shellSort(result);
//        solution.insertSort(result);
        solution.mergeSort(result, 0, result.length - 1);
//        solution.baseSort(result);
//        solution.heapSort(result);
        System.out.println(Arrays.toString(result));
    }

    public void quickSort_1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort_1(nums, 0, nums.length - 1);
    }

    public void quickSort_3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort_3(nums, 0, nums.length - 1);
    }

    // 快速排序递归写法
    // 挖坑法递归
    public void quickSort_1(int[] nums, int low, int high) {
        if (nums == null || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int base = nums[left];
        while (left < right) {
            while (left < right && base <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && base >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        quickSort_1(nums, low, left - 1);
        quickSort_1(nums, left + 1, high);
    }

    // 快速排序递归写法
    // 左右指针法
    public void quickSort_3(int[] nums, int low, int high) {
        if (nums == null || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, low, left);
        quickSort_3(nums, low, left - 1);
        quickSort_3(nums, left + 1, high);
    }

    // 快速非递归写法
    public void quickSort_2(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(nums.length - 1);
        while (!queue.isEmpty()) {
            int left = queue.poll();
            int right = queue.poll();
            if (left >= right) {
                continue;
            }
            int low = left;
            int high = right;
            int base = nums[left];
            while (left < right) {
                while (left < right && base <= nums[right]) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && base >= nums[left]) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = base;
            queue.add(low);
            queue.add(left - 1);
            queue.add(left + 1);
            queue.add(high);
        }
    }

    public void swap(int[] nums, int start, int end) {
        int swap = nums[start];
        nums[start] = nums[end];
        nums[end] = swap;
    }

    // 希尔排序
    public void shellSort(int[] nums) {
        int step = nums.length / 2;
        while (step > 0) {
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < nums.length; j = j + step) {
                    int base = nums[j];
                    int k = j - step;
                    while (k >= 0 && base < nums[k]) {
                        nums[k + step] = nums[k];
                        k = k - step;
                    }
                    nums[k + step] = base;
                }
            }
            step = step / 2;
        }
    }

    public void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i - 1;
            int base = nums[i];
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mid = mid == start ? end : mid;
        mergeSort(nums, start, mid - 1);
        mergeSort(nums, mid, end);
        mergeArray(nums, start, end);
    }

    private void mergeArray(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        while (start < mid) {
            if (nums[start] > nums[mid]) {
                swap(nums, start, mid);
            }
            start++;
        }
        int i = mid + 1;
        int base = nums[mid];
        while (i <= end && base > nums[i]) {
            nums[i - 1] = nums[i];
            i++;
        }
        nums[i - 1] = base;
    }


    public int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public int level(int num) {
        int level = 0;
        while (num != 0) {
            num = num / 10;
            level++;
        }
        return level;
    }

    // 基数排序
    public void baseSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int maxNum = max(nums);
        int level = level(maxNum);
        int step = 1;
        int[][] bulks = new int[10][nums.length];
        for (int i = 0; i < level; i++) {
            int[] count = new int[10];
            for (int j = 0; j < nums.length; j++) {
                int value = nums[j] / step % 10;
                bulks[value][count[value]] = nums[j];
                count[value]++;
            }
            step = step * 10;

            int index = 0;
            for (int j = 0; j < bulks.length; j++) {
                for (int k = 0; k < count[j]; k++) {
                    nums[index] = bulks[j][k];
                    index++;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    // 堆排序
    public void heapSort(int[] nums) {
        //1.构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(nums, 0, j);//重新对堆进行调整
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];//先取出当前元素i
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j ++;
            }
            if (temp < nums[j]) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
