package de.bulldog98.leetcode.one_two_sum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map.getOrElse(complement) { throw IllegalArgumentException() }, i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No match found")
    }
}