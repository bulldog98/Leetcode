package de.bulldog98.leetcode.six_zigzag_pattern

import kotlin.math.min

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val rows = (0 until (min(s.length, numRows))).map {
            StringBuilder()
        }
        var currentRow = 0
        var goingDown = false
        s.forEach {
            rows[currentRow].append(it)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown
            }
            currentRow += if (goingDown) 1 else -1
        }
        val ret = StringBuilder()
        rows.forEach {
            ret.append(it)
        }
        return ret.toString()
    }
}
