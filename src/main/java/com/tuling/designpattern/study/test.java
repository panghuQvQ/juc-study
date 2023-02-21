package com.tuling.designpattern.study;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2023年02月14日 13:52:00
 */
public class test {

    public static void main(String[] args) {

    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null ) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list2, list1.next);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



