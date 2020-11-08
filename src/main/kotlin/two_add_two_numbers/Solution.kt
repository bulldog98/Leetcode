package de.bulldog98.leetcode.two_add_two_numbers

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        val sum = l1.`val` + l2.`val`
        val res = ListNode(sum % 10)
        res.next = addTwoNumbers(l1.next, l2.next)
        if (sum > 9) {
            res.next = res.next?.addOne() ?: ListNode(1)
        }
        return res
    }

    private fun ListNode.addOne(): ListNode {
        if (this.`val` < 9) {
            this.`val`++
            return this
        }
        this.`val` = 0
        if (this.next == null) {
            this.next = ListNode(1)
        } else {
            this.next = this.next!!.addOne()
        }
        return this
    }
}