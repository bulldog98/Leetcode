package de.bulldog98.leetcode.six_zigzag_pattern

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {

    @ParameterizedTest
    @ArgumentsSource(ConvertArgumentsProvider::class)
    fun convert(s: String, numRows: Int, expectedResult: String) {
        val result = Solution().convert(s, numRows)
        assertEquals(expectedResult, result)
    }
}

object ConvertArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            Triple("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
            Triple("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
            Triple("A", 1, "A")
        ).stream().map {
            Arguments.of(it.first, it.second, it.third)
        }
}
