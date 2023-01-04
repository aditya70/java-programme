package com.example.demo.pr.lc;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _021_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        else if(list2==null) return list1;
        else{
            System.out.println("else block");
            ListNode l=new ListNode();
            ListNode head=l;
            while(list1 !=null && list2 !=null){
                ListNode temp=new ListNode();
                if(list1.val<=list2.val) {
                    temp.val=list1.val;
                }
                else {
                    temp.val=list2.val;
                }
                l.next=temp;
                l=l.next;
            }
            while(list1!=null) {
                ListNode temp=new ListNode();
                temp.val=list1.val;
                l.next=temp;
                l=l.next;
            }
            while(list2!=null) {
                ListNode temp=new ListNode();
                temp.val=list2.val;
                l.next=temp;
                l=l.next;
            }
            l.next=null;
            return head;
        }
    }
}
