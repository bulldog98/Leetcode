package de.bulldog98.leetcode.three_longest_substring_without_repeating_chars

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val results = mutableMapOf<Int, Int>()
        for ((i, v) in s.withIndex()) {
            if (results.containsKey(i - 1) && results[i - 1]!! > 0) results[i] = results[i - 1]!!
            val seen = mutableListOf(v)
            val l = s.drop(i + 1).takeWhile { c -> seen.addIfNotContained(c) }.length
            results[i] = l
            if (l + i + 1 == s.length) return l
        }
        return results.values.maxOrNull() ?: 0
    }

    private fun MutableList<Char>.addIfNotContained(c: Char): Boolean {
        val result = this.contains(c)
        this.add(c)
        return result
    }
}