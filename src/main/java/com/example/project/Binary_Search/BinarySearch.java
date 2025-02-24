package com.example.project.Binary_Search;

public class BinarySearch {
    // implements binary search on the elements list for target,
    // and returns the index at which the target is found, or -1 if
    public static int binarySearch(int[] elements, int target) {
        int leftIdx = 0;
        int rightIdx = elements.length - 1;


        while (leftIdx <= rightIdx) {
            int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if (elements[middleIdx] == target) {
                return middleIdx;

            } else if (elements[middleIdx] < target) {
                leftIdx = middleIdx + 1;
                System.out.println(leftIdx);
            } else {
                rightIdx = middleIdx - 1;
                System.out.println(rightIdx);
            }
        }
        return -1; // not found
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        System.out.println(binarySearch(nums, 13));
    }
}
