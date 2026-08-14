import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println("Node inserted successfully.");
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println("Node inserted successfully.");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        System.out.println("Node inserted successfully.");
    }

    // Insert at a specific position
    void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Node inserted successfully.");
    }

    // Delete from beginning
    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        head = head.next;

        System.out.println("Node deleted successfully.");
    }

    // Delete from end
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            System.out.println("Node deleted successfully.");
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        System.out.println("Node deleted successfully.");
    }

    // Delete from a specific position
    void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position.");
            return;
        }

        temp.next = temp.next.next;

        System.out.println("Node deleted successfully.");
    }

    // Display linked list
    void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node temp = head;

        System.out.print("Linked List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Search an element
    void search(int key) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println(
                    key + " found at position " + position
                );
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println(key + " not found.");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SinglyLinkedList list = new SinglyLinkedList();

        int choice;

        do {
            System.out.println("\n===== SINGLY LINKED LIST =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display");
            System.out.println("8. Search");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    int data1 = sc.nextInt();
                    list.insertAtBeginning(data1);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    int data2 = sc.nextInt();
                    list.insertAtEnd(data2);
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    int data3 = sc.nextInt();

                    System.out.print("Enter position: ");
                    int position1 = sc.nextInt();

                    list.insertAtPosition(data3, position1);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    int position2 = sc.nextInt();

                    list.deleteFromPosition(position2);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();

                    list.search(key);
                    break;

                case 9:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
