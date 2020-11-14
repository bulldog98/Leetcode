package de.bulldog98.leetcode.four_median_of_two_sorted_arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {
    @ParameterizedTest
    @ArgumentsSource(FindMedianSortedArraysArgumentsProvider::class)
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray, expectedResult: Double) {
        val result = Solution().findMedianSortedArrays(nums1, nums2)
        assertEquals(expectedResult, result)
    }
}

object FindMedianSortedArraysArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            Triple(intArrayOf(1, 3), intArrayOf(2), 2.0),
            Triple(intArrayOf(1, 2), intArrayOf(3, 4), 2.5),
            Triple(intArrayOf(0, 0), intArrayOf(0, 0), 0.0),
            Triple(intArrayOf(), intArrayOf(1), 1.0),
            Triple(intArrayOf(2), intArrayOf(), 2.0),
            Triple(intArrayOf(1, 3), intArrayOf(2, 7), 2.5)
        ).stream().map {
            Arguments.of(it.first, it.second, it.third)
        }
}
