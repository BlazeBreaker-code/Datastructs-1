/*
Linked List implementation by Suraj Mohan N01234931
 */

public class List {

        ListNode head;

        public class ListNode {
            String aname;
            ListNode next;

            public ListNode(){}

            public ListNode(String name){
                aname = name;
            }

            public ListNode(String name, ListNode next1){
                aname = name;
                next = next1;
            }
        }

        public void insertItem(String name) {
            //inserts an element at the end of the linked list
            ListNode newListNode = new ListNode();
            newListNode.aname = name;
            newListNode.next = null;
            if (head == null) {
                head = newListNode;
            } else {
                ListNode n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = newListNode;

            }
        }

        public void insertItem(String name, int pos){
            /*inserts element at given position in the linked list
            assume 0 means first if position out of bounds, output out of bounds
             */
            ListNode newListNode = new ListNode();
            newListNode.aname = name;
            newListNode.next = null;
            if(pos <= size()){
                if(pos < 0){
                    System.out.println("Out of bounds");
                }
                if(pos == 0) {
                    newListNode.next = head;
                    head = newListNode;
                } else {
                    ListNode n = head;
                    for(int i=0; i<pos-1;i++){
                        n=n.next;
                    }
                    newListNode.next = n.next;
                    n.next = newListNode;
                }
            } else {
                System.out.println("Out of bounds");
            }

        }

        public boolean removeItem(String aname) {
            if(head.aname.equals(aname)) {
                head = head.next;
                return true;
            }

            ListNode current = head;
            ListNode previous = null;


            while (current!= null && !current.aname.equals(aname)){
                 previous = current;
                 current = current.next;
            }

            previous.next = current.next;
            return true;


        }

        public void removeItem(int position) {
            //removes node at position, if out of bounds output out of bounds
            if (position < 0){
                System.out.println("Out of bounds");
            }
            if(position == 0){
                head = head.next;
            } else {
                ListNode n = head;
                ListNode n1 = null;
                if(position <= size()) {
                    for (int i = 1; i < position; i++) {
                        n = n.next;
                    }
                    n1 = n.next;
                    n.next = n1.next;
                    n1 = null;
                } else {
                    System.out.println("Out of bounds");
                }
            }
        }

        public boolean contains(String name){
            //return true if the linked list contains the string
            ListNode newListNode = head;
            while(newListNode != null){
                if(newListNode.aname.equals(name)){
                    return true;
                } else {
                    newListNode = newListNode.next;
                }
            }
            return false;
        }


        public void clear() {
            head = null;
        }

        public String get(int pos){
            ListNode n = head;

            for(int i = 0; i<pos; i++){
                n = n.next;
            }

            return n.aname;
        }

        public int size(){
            ListNode newListNode = head;
            int size = 0;

            while (newListNode != null){
                size = size +1;
                newListNode =newListNode.next;
            }

            return size;
        }

        public String toHTMLString(){
	    /*
	    Return a String that starts with < html > ends with < /html >
	    and uses the line breaks, < br/ >, in replacement of new line characters
	    and prints out all the names of all the songs in the list. See the current
	    implementation for details.
	    */
            String temp = "<html>PlayList<br/>";
            ListNode newListNode = head;
            while(newListNode!=null){
                //System.out.println(newListNode.aname);
                temp = temp + newListNode.aname+"<br/>";
                newListNode = newListNode.next;
            }
            temp = temp + "</html>";

            return temp;

        }

        @Override
        public String toString() {
            String temp = "";
            ListNode newListNode = head;
            while(newListNode!=null){
                temp = temp + newListNode.aname+"\n";
                newListNode = newListNode.next;
            }
            return temp;
        }

    }