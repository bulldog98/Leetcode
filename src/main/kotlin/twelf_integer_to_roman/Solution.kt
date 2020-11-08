package de.bulldog98.leetcode.twelf_integer_to_roman

class Solution {
    fun intToRoman(num: Int): String {
        require(num in 1..3999) { "number has to be between 1 and 3999 including these" }
        var tmp = num
        val sb = StringBuilder()
        for ((index, key) in values.withIndex()) {
            while (tmp >= key) {
                sb.append(romanNumber[index])
                tmp -= key
            }
            if (tmp == 0) return sb.toString()
        }
        throw IllegalArgumentException("Something went wrong")
    }

    companion object {
        private val values = shortArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        private val romanNumber = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    }
}
