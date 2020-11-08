package de.bulldog98.leetcode.three_longest_substring_without_repeating_chars

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {

    @ParameterizedTest
    @ArgumentsSource(LengthOfLongestSubstringArgumentsProvider::class)
    fun lengthOfLongestSubstring(input: String, expected: Int) {
        val result = Solution().lengthOfLongestSubstring(input)
        assertEquals(expected, result)
    }
}

object LengthOfLongestSubstringArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            listOf("abcabcbb", 3),
            listOf("bbbbb", 1),
            listOf("pwwkew", 3),
            listOf("", 0)
        ).map {
            Arguments.of(it[0], it[1])
        }.stream()
}