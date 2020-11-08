package de.bulldog98.leetcode.twelf_integer_to_roman

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {
    private val solution = Solution()

    @ParameterizedTest(name = "intToRoman() of different values")
    @ArgumentsSource(InputAndOutputProvider::class)
    fun toRomanReturnsExpected(x: InputAndOutput) {
        assertEquals(x.output, solution.intToRoman(x.input))
    }

    @Test
    fun `fail if smaller 1`() {
        assertThrows(IllegalArgumentException::class.java) { solution.intToRoman(0) }
    }

    @Test
    fun `fail if larger 3999`() {
        assertThrows(IllegalArgumentException::class.java) { solution.intToRoman(4000) }
    }
}

object InputAndOutputProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            InputAndOutput(3, "III"),
            InputAndOutput(4, "IV"),
            InputAndOutput(9, "IX"),
            InputAndOutput(39, "XXXIX"),
            InputAndOutput(58, "LVIII"),
            InputAndOutput(1994, "MCMXCIV")
        ).map { Arguments.of(it) }.stream()
}

internal data class InputAndOutput(val input: Int, val output: String)
