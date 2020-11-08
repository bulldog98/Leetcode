package de.bulldog98.leetcode.one_two_sum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {
    @ParameterizedTest
    @ArgumentsSource(TwoSumArgumentsProvider::class)
    fun twoSum(nums: IntArray, target: Int, expected: IntArray) {
        val result = Solution().twoSum(nums, target)
        assertAll(
            Executable { assertEquals(2, result.size) },
            Executable { assertEquals(expected[0], result[0]) },
            Executable { assertEquals(expected[1], result[1]) }
        )
    }
}

object TwoSumArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            Arguments.of(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
            Arguments.of(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
            Arguments.of(intArrayOf(3, 3), 6, intArrayOf(0, 1))
        ).stream()
}