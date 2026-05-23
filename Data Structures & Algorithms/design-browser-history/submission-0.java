public class ListNode {
    String val;
    ListNode prev;
    ListNode next;

    public ListNode(String val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
class BrowserHistory {
    private ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage, null, null);
    }
    
    public void visit(String url) {
        curr.next = new ListNode(url, curr, null);
        curr = curr.next;
    }
    
    public String back(int steps) {
        while (curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }

        return curr.val;
    }
    
    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }

        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */