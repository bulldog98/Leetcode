package de.bulldog98.leetcode.twelf_integer_to_roman

class Solution {
    fun intToRoman(num: Int) = num.toRoman()

    private fun Int.toRoman(): String {
        require(this in 1..3999) { "number has to be between 1 and 3999 including these" }
        val thousandDigit = this / 1000
        val hundredDigit = (this % 1000) / 100
        val tenDigit = (this % 100) / 10
        val singleDigit = (this % 10)
        val result = handleThousandsDigit(thousandDigit) +
                handleHundreds(hundredDigit) +
                handleTens(tenDigit) +
                handleSingle(singleDigit)
        return result.joinToString("")
    }

    private fun handleThousandsDigit(num: Int): CharArray {
        if (num == 0) return CharArray(0)
        if (num <= 3) return CharArray(num) { 'M' }
        throw IllegalArgumentException("Number to big")
    }

    private fun handleHundreds(num: Int) = handleFullDigit(num, 'C', 'D', 'M')
    private fun handleTens(num: Int) = handleFullDigit(num, 'X', 'L', 'C')
    private fun handleSingle(num: Int) = handleFullDigit(num, 'I', 'V', 'X')

    private fun handleFullDigit(num: Int, singleSymbol: Char, fiveSymbol: Char, tenSymbol: Char): CharArray {
        require(num in 0..9) { "digit has to be in 0..9" }
        return when (num) {
            0 -> CharArray(0)
            in 1..3 -> CharArray(num) { singleSymbol }
            4 -> CharArray(2) { if (it == 0) singleSymbol else fiveSymbol }
            5 -> CharArray(1) { fiveSymbol }
            in 6..8 -> CharArray(num - 4) { if (it == 0) fiveSymbol else singleSymbol }
            else -> CharArray(2) { if (it == 0) singleSymbol else tenSymbol }
        }
    }
}
