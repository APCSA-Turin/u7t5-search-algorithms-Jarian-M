package com.example.project.Binary_Search;

public class BinarySearch {
    // implements binary search on the elements list for target,
    // and returns the index at which the target is found, or -1 if
    public static int binarySearch(int[] elements, int target) {
        // int loopCounter = 0; // for testing
        int leftIdx = 0;  
        int rightIdx = elements.length - 1; 
        if(leftIdx == rightIdx) {
            if(target == elements[leftIdx]) {
                return leftIdx;
            }
        }

        while (elements[leftIdx] < elements[rightIdx]) {  
        //loopCounter++; // for testing
        //System.out.print(loopCounter + " "); // for testing
            int middleIdx = rightIdx / 2; 
            if(elements[middleIdx] < target) {
                leftIdx = middleIdx++;
            } else if(elements[middleIdx] > target) {
                rightIdx = middleIdx--;
            } else {
                return middleIdx;
            }
        }
        return -1; // not found
    }
}
