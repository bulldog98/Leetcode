package de.bulldog98.leetcode.one_two_sum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..(nums.size - 2)) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw IllegalArgumentException("No match found")
    }
}