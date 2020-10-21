package com.charusmita;

import java.util.List;

import static com.charusmita.LinkedList.linkedListSum;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> n = new LinkedList<Integer>();
        n.addNode(3);
        n.addNode(4);
        n.addNode(5);
        n.addNode(10);

        System.out.println("Printing all nodes through printnode function" );
        n.printNodes(); //  to print all the nodes

        System.out.println("Using countNodes function, printing total number of nodes which is  " + n.countNodes());

        System.out.println("Using popelemenet function,Popping the top node from the list whose value is " + n.popElement());
        System.out.println("Printing all nodes through printnode function after pop function" );
        n.printNodes();


        n.insertNth(0, 3);
        n.insertNth(4, 12);
        n.insertNth(4, 11);
        System.out.println("Printing all nodes through printnode function after insert function" );
        n.printNodes();

        n.insertSorted(3);
        n.insertSorted(14);
        n.insertSorted(14);
        n.insertSorted(7);
        System.out.println("Printing all nodes through printnode function after insertsorted function" );
        n.printNodes();

        // After removing duplicates
        n.removeDuplicates();
        System.out.println("Printing all nodes through printnode function after removeDuplicate function" );
        n.printNodes();


        LinkedList<Integer> n1 = new LinkedList<Integer>();
        n1.addNode(500);
        n1.addNode(600);
        n1.addNode(700);

        n.appendList(n1);
        System.out.println("Printing all nodes through printnode function after append_list function" );
        n.printNodes();

        n.changeHead(n1);
        System.out.println("Printing all nodes through printnode function after changeHead function" );
        n1.printNodes();
        n.printNodes();

        n.reverseList();
        System.out.println("Printing all nodes through printnode function after reverseLinked function" );
        n.printNodes();
        n.reverseList();
        n.popElement();
        n.popElement();
        n.popElement();

        System.out.println("*********************************************");
        System.out.println("first list to merge");
        n.printNodes();
        System.out.println("second list to merge");
        n1.printNodes();
        LinkedList<Integer> mergesort = n.sortedMergeList(n1);
        System.out.println("Printing all nodes through printnode function after mergesorted function" );
        mergesort.printNodes();

        System.out.println("Deleting an element ");
        mergesort.deleteNode(600);
        System.out.println("Printing all nodes after deleting" );
        mergesort.printNodes();

        LinkedList<String> input = new LinkedList<>();
        input.addNode("F");
        input.addNode("O");
        input.addNode("L");
        input.addNode("L");
        input.addNode("O");
        input.addNode("W");
        input.addNode(" ");
        input.addNode("U");
        input.addNode("P");

        System.out.println("Original list");
        input.printNodes();
        System.out.println("Deleting from unsorted list ");
        input.removeDuplicatesUnsortedList();
        System.out.println("Printing all nodes after deleting" );
        input.printNodes();

        System.out.println("Finding kth node from the end of list");
        String kthNode = input.kthNodeFromEnd(4);
        System.out.println(" The kth node from end is= "+kthNode);

        System.out.println("Sum two lists as numbers");
        LinkedList<Integer> no1 = new LinkedList<>();
        no1.addNode(7);
        no1.addNode(1);
        no1.addNode(6);
        LinkedList<Integer> no2 = new LinkedList<>();
        no2.addNode(5);
        no2.addNode(9);
        no2.addNode(2);
        System.out.println("Add two numbers in linked list");
        Node<Integer> answer = linkedListSum(no1,no2);

        System.out.println("Sum = ");
        printNode(answer);
        List<Node<Integer>> frontBackSplit = n.frontBackSplit();

        System.out.println("Printing all nodes through printnode function of Front Split after frontBackSplit function" );
        printNode(frontBackSplit.get(0));

        System.out.println("Printing all nodes through printnode function of Back Split after frontBackSplit function" );
        printNode(frontBackSplit.get(1));
    }


    static void printNode(Node head)
    {
        Node curr = null;
        curr = head;
        int i = 1;
        while (curr!= null)
        {
            System.out.println("this is the Node number " + i + ", the value it stores is "+ curr.toString() );
            curr = curr.getNext();
            i++;
        }

    }
}
