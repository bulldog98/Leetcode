package de.bulldog98.leetcode.two_add_two_numbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val start = "[${this.`val`}"
        if (this.next == null) return "$start]"
        return "$start, ${(next.toString().drop(1))}"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other is ListNode) return this.`val` == other.`val` && this.next == other.next
        return false
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }
}