package de.bulldog98.leetcode.twelf_integer_to_roman

class Solution {
    fun intToRoman(num: Int) = num.toRoman()

    private fun Int.toRoman(): String {
        require(this in 1..3999) { "number has to be between 1 and 3999 including these" }
        val thousandDigit = this / 1000
        val hundredDigit = (this % 1000) / 100
        val tenDigit = (this % 100) / 10
        val singleDigit = (this % 10)
        return "${handleThousandsDigit(thousandDigit)}${handleHundreds(hundredDigit)}${handleTens(tenDigit)}${handleSingle(singleDigit)}"
    }

    private fun handleThousandsDigit(num: Int): String {
        if (num == 0) return ""
        if (num <= 3) return (1..num).map { 'M' }.toCharArray().joinToString("")
        throw IllegalArgumentException("Number to big")
    }

    private fun handleHundreds(num: Int): String = handleFullDigit(num, 'C', "D", "M")
    private fun handleTens(num: Int) = handleFullDigit(num, 'X', "L", "C")
    private fun handleSingle(num: Int) = handleFullDigit(num, 'I', "V", "X")

    private fun handleFullDigit(num: Int, singleSymbol: Char, fiveSymbol: String, tenSymbol: String): String {
        require(num in 0..9) { "digit has to be in 0..9" }
        if (num == 0) return ""
        if (num < 4) return (1..num).map { singleSymbol }.toCharArray().joinToString("")
        if (num == 4) return "$singleSymbol$fiveSymbol"
        if (num < 9) return "$fiveSymbol${handleFullDigit(num - 5, singleSymbol, fiveSymbol, tenSymbol)}"
        return "$singleSymbol$tenSymbol"
    }
}


