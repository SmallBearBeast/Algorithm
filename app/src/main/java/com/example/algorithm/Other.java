package com.example.algorithm;

import java.util.Arrays;

public class Other {
    public static void main(String[] args) {
        Other other = new Other();
        int[] result = new int[] {
                14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 15
        };
        other.quickSort(result, 0, result.length - 1);
        System.out.println("result = " + Arrays.toString(result));
    }


    public void quickSort(int[] datas, int start, int end) {
        if (start >= end) {
            return;
        }
        int tempStart = start;
        int tempEnd = end;
        while (tempStart < tempEnd) {
            int temp = tempStart;
            while (tempEnd > temp && datas[temp] <= datas[tempEnd]) {
                tempEnd --;
            }
            swap(datas, temp, tempEnd);
            temp = tempEnd;
            while (tempStart < temp && datas[tempStart] <= datas[temp]) {
                tempStart ++;
            }
            swap(datas, temp, tempStart);
        }
        quickSort(datas, start, tempStart - 1);
        quickSort(datas, tempEnd + 1, end);
    }

    public void swap(int[] datas, int index_1, int index_2) {
        int temp = datas[index_1];
        datas[index_1] = datas[index_2];
        datas[index_2] = temp;
    }

}
