package com.hhwf.leetcode;

import java.util.List;
import java.util.Stack;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/4/28 17:46
 *
 */
public class Linked {

    /**
     * 从尾到头打印链表节点的值
     */
    public static void printListNode(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.empty()) {
            Integer pop = stack.pop();
            System.out.println(pop);
        }
    }

    /**
     * 给定非尾的节点，在O(1)的时间复杂度中删除。
     */
    public static void deleNode(ListNode delNode) {
        ListNode temp = delNode.next;
        delNode.val = temp.val;
        delNode.next = temp.next;
    }

    /**
     * 删除给定的节点。
     */
    public static ListNode deleteNode(ListNode head, ListNode delNode) {
        if (head == null || delNode == null) {
            return null;
        }
        if (delNode.next == null) {
            ListNode currentNode = head;
            if (currentNode == delNode) {
                return null;
            } else {
                while (currentNode != null && currentNode.next != delNode) {
                    currentNode = currentNode.next;
                }
                currentNode.next = null;
            }
        } else {
            ListNode temp = delNode.next;
            delNode.val = temp.val;
            delNode.next = temp.next;
        }
        return head;
    }

    /**
     * 找出倒数第K个节点
     */
    public static ListNode findEndK(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }


    /**
     * 找到中间节点
     */
    public static ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 判断链表是否有环
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    /**
     *  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {   //相遇点
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    /**
     * 删除链表的倒数第N个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == null) {
            ListNode currentNode = head;
            if (currentNode == slow) {
                return null;
            } else {
                while (currentNode != null && currentNode.next != slow) {
                    currentNode = currentNode.next;
                }
                currentNode.next = null;
            }
        } else {
            ListNode temp = slow.next;
            slow.val = temp.val;
            slow.next = temp.next;
        }
        return head;
    }


    /**
     * 反转链表(递归)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }


    /**
     * 反转链表（双指针）
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 链表反转前K个节点
     */
    public static ListNode reverseK(ListNode head, int k) {
        ListNode pre = null;
        ListNode curr = head;
        if (head == null || k == 0) {
            return head;
        }
        return null;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 回文链表
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        //定义快慢指针找到链表中间位置
        ListNode slow = head;
        ListNode fast = head;
        return true;
    }


    /**
     * K 个一组翻转链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) {
            return head;
        }
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode tail = dummp;
        ListNode pre = dummp;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            ListNode head1 = pre.next;
            while (pre.next.val != tail.val) {
                // 标记要翻转链表的头节点。
                ListNode cur = pre.next;
                // 头节点索引指向头节点的 next 节点。
                pre.next = cur.next;
                // 标记的头节点 next 指向尾节点的 next 节点。
                cur.next = tail.next;
                // 要翻转链表的结尾节点 next 指向标记的头节点。
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        head.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        print(reverseKGroup(head, 6));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void print(ListNode node) {
        String str = "";
        while (node != null) {
            str = str + node.val + "->";
            node = node.next;
        }
        str = str + "null";
        System.out.println(str);
    }

}











