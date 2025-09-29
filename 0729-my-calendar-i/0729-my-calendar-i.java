class MyCalendar {

    Node root;
    class Node{
        Node left;
        Node right;
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        Node(int start, int end, Node left, Node right){
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }

    public MyCalendar() {
        this.root=null;
    }
    
    public boolean book(int startTime, int endTime) {
        if(root==null){
            root = new Node(startTime, endTime);
            return true;
        }
        return book(startTime,endTime,root);
    }

    public boolean book(int start, int end, Node root){
        if(end<=root.start){
            if(root.left==null){
                Node node = new Node(start,end);
                root.left = node;
                return true;
            }
            return book(start,end,root.left);
        }if(start>=root.end){
            if(root.right==null){
                Node node = new Node(start,end);
                root.right = node;
                return true;
            }
            return book(start,end,root.right);
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */