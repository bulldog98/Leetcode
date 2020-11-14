package de.bulldog98.leetcode.four_median_of_two_sorted_arrays

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun findMedianSortedArrays(firstArray: IntArray, secondArray: IntArray): Double {
        val m = firstArray.size
        val n = secondArray.size
        if (m > n) { // ensure m <= n
            return findMedianSortedArrays(secondArray, firstArray)
        }
        var iMin = 0
        var iMax = m
        val halfLength = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = halfLength - i
            if (i < iMax && secondArray[j - 1] > firstArray[i]) {
                iMin = i + 1 // iMin is to small
            } else if (i > iMin && firstArray[i - 1] > secondArray[j]) {
                iMax = i - 1 // iMax is to big
            } else {
                val maxLeft = when {
                    i == 0 -> {
                        secondArray[j - 1]
                    }
                    j == 0 -> {
                        firstArray[i - 1]
                    }
                    else -> {
                        max(firstArray[i - 1], secondArray[j - 1])
                    }
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft.toDouble()
                }

                val minRight = when {
                    i == m -> {
                        secondArray[j]
                    }
                    j == n -> {
                        firstArray[i]
                    }
                    else -> {
                        min(secondArray[j], firstArray[i])
                    }
                }

                return (maxLeft + minRight) / 2.0
            }
        }
        return 0.0
    }
}
