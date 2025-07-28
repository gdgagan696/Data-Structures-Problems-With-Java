package dsquestions.linkedlist;

public class ConvertToDecimal {

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(String.valueOf(current.val));
            current = current.next;
        }
        String result = sb.reverse().toString();
        int num = 0;
        for (int i = 0; i < result.length(); i++) {
            int temp = (1 << i) * Integer.parseInt(result.charAt(i) + "");
            num += temp;
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
        System.out.println(getDecimalValue(listNode));

    }
}
