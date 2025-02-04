public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    void addingFirst(String name, String details) {
        head = new Node(name, details);
    }

    void addCustomer(String name, String details) {
        Node newNode = new Node(name, details);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    void printCustomers() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " (" + current.details + ") -> ");
            current = current.next;
            if(current == null){
                System.out.println("NULL");
                break;
            }
        }
    }
    void removeCustomer(String name) {
        if(head == null){
            return;
        }
        if(head.name.equals(name)){
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if(current.next.name.equals(name)){
                current.next = current.next.next;
            }

            current = current.next;
        }
    }
    void addVipCustomer(String name, String details) {
        Node newNode = new Node(name, details);
        if (head == null) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }

    }

}
