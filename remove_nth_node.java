/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
       
       
       ListNode temp = head;
       ListNode prev = null;
       int count = 0;
       while(temp!=null){
           temp = temp.next;
           count++;
       }
       
       if(count==1 && n==1){
           return null;
       }
       
       temp = head;
       
       int del = count - n;
       
       if (del==0) del=0;
       
       count  = 0;
       
       while(temp!=null){
           
           if(count==del){
               
               if(prev!=null){
                   prev.next = temp.next;    
               }else{
                   
                   ListNode node = temp.next;
                   return node;
               }
                   
               break;
           }
           
           prev = temp;
           temp = temp.next;
           count++;
       }
       
       return head;
   }
}
