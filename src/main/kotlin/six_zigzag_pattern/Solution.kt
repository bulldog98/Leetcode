package de.bulldog98.leetcode.six_zigzag_pattern

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val resultSet = (1..numRows).map {
            mutableListOf<Char>()
        }
        val dividend = numRows*2 - 2
        s.forEachIndexed { index, c ->
            (0 until numRows).forEach { row ->
                if (index % dividend == row || index % dividend == dividend - row) {
                    resultSet[row].add(c)
                }
            }
        }
        return resultSet.map {
            if (it.isEmpty()) "" else
            it.map { "$it" }.reduce { a, b -> a + b}
        }.reduce { a, b -> a + b }
    }
}
