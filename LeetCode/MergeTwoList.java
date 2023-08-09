import java.util.LinkedList;

public class MergeTwoList {

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        LinkedList<ListNode> newList = new LinkedList<>();
        while (list1.next != null && list2.next != null) {
            if (list1.val <= list2.val) {
                newList.add(list1);
                list1 = list1.next;
            }
            else {
                newList.add(list2);
                list2 = list2.next;
            }
            newList = newList.next;
        }
        return newList.get(0);
    }
}
