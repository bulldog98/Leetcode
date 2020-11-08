package de.bulldog98.leetcode.two_add_two_numbers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolutionTest {
    @ParameterizedTest
    @ArgumentsSource(AddTwoNumbersArgumentsProvider::class)
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, expected: ListNode?) {
        val result = Solution().addTwoNumbers(l1, l2)
        assertEquals(expected, result)
    }
}

object AddTwoNumbersArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
        listOf(
            listOf(listOf(2, 4, 3), listOf(5, 6, 4), listOf(7, 0, 8)),
            listOf(listOf(0), listOf(0), listOf(0)),
            listOf(generateSequence { 9 }.take(7).toList(), listOf(9, 9, 9, 9), listOf(8, 9, 9, 9, 0, 0, 0, 1 ))
        ).map {
            Arguments.of(*it.map { nl -> nl.toListNode() }.toTypedArray())
        }.stream()
}

private fun List<Int>.toListNode(): ListNode? {
    if (this.isEmpty()) return null
    val li = ListNode(this[0])
    li.next = this.drop(1).toListNode()
    return li
}
