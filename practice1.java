import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        
        ListNode list = new ListNode();
        ListNode t = list;
        int carry = 0;
        boolean ini = true;

        while(l1!=null && l2 !=null){

            int val = l1.val + l2.val + carry;

            int ans = val % 10;
            
            if(ini){
                list.val = ans;
                ini = false;
            }else{
                ListNode n = new ListNode();
                n.val = ans;
                t.next = n;
                t = n;
            }
            l1 = l1.next;
            l2 = l2.next;
            carry = val / 10;
        }

        while(l1!=null){

            ListNode l = new ListNode();
            int temp_val = l1.val+carry;
            
            int real_val = temp_val % 10;
            carry = temp_val / 10;

            l.val = real_val;
            
            t.next = l;
            t = l;
            l1 = l1.next;
        }


        while(l2!=null){

            ListNode l = new ListNode();
            int temp_val = l2.val+carry;
            
            int real_val = temp_val % 10;
            carry = temp_val / 10;

            l.val = real_val;
            t.next = l;
            t = l;
            l2 = l2.next;
        }

        if(carry>0){
            ListNode l = new ListNode();
            l.val = carry;
            t.next = l;
        }
        return list;
    }
}