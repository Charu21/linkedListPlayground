package com.charusmita;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

    private Node<T> head = null;

    public LinkedList() {
    }

    /**
     * Append a new node to the end of the linked list.
     */
    public void addNode(T data) {
        Node<T> currNode = new Node<>(data);
        if (head == null) {
            currNode.setNext(null);
            head = currNode;
        } else {
            Node<T> startNode = head;
            while (startNode.getNext() != null) {
                startNode = startNode.getNext();
            }
            startNode.setNext(currNode);
            currNode.setNext(null);
        }
    }

    /**
     * Print all the nodes in the linked list.
     */
    public void printNodes() {
        if (head == null) {
            System.out.println("THe list is empty!");
        } else {
            Node<T> currNode = head;
            System.out.println("Linked list elements");
            while (currNode != null) {
                System.out.println(currNode.getData());
                currNode = currNode.getNext();
            }
        }
    }

    /**
     * Count the number of nodes in the linked list.
     */
    public int countNodes() {
        int countOfNodes = 0;
        Node<T> currNode = head;
        while (currNode != null) {
            countOfNodes++;
            currNode = currNode.getNext();
        }
        return countOfNodes;
    }

    /**
     * Return the first element in the linked list.
     */
    public T popElement() {
        if (head == null) {
            System.out.println("the list is empty!");
            return null;
        } else {
            Node<T> firstNode = head;
            head = head.getNext();
            return firstNode.getData();
        }
    }

    /**
     * Delete all the elements in the linked list.
     */
    public void deleteLinkedList() {
        // This is the easiest code every written in Java, no clean up
        // required. Java's garbage collector will clean up the memory
        // for all the elements being used in this linked list if
        // they are no longer referenced in the program.
        head = null;
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insertNth(int n, T data) {
        int currentPos = 0;
        Node<T> newNode = new Node<>(data);
        if (n == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> currentNode = head;
            Node<T> prevNode = head;
            while (currentPos < n) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                currentPos++;
            }
            prevNode.setNext(newNode);
            newNode.setNext(currentNode);
        }
    }

    /**
     * Insert the data into the correct position in a sorted list. Assume
     * that the list is sorted in ascending order.
     */
    public void insertSorted(T data) {
        Node<T> currentNode = head;
        if (countNodes() == 0 || head.getData().compareTo(data) > 0) {
            Node<T> next = head;
            head = new Node<T>(data);
            head.setNext(next);
        } else {
            Node<T> prevNode = head;
            while (currentNode != null && currentNode.getData().compareTo(data) <= 0) {
                if (currentNode.getData().compareTo(data) == 0)
                    return;
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }
            Node<T> newNode = new Node<T>(data);
            prevNode.setNext(newNode);
            newNode.setNext(currentNode);
        }
    }

    /**
     * Append the nodes of the other list to the end of the curren list.
     */
    public void appendList(LinkedList<T> ll) {
        if (head == null) {
            head = ll.head;
        } else {
            Node<T> currNode = head;
            Node<T> prevNode = head;
            while (currNode != null) {
                prevNode = currNode;
                currNode = currNode.getNext();
            }
            prevNode.setNext(ll.head);
        }
    }

    /**
     * Split a linked list into 2 equal parts. If there are an odd number of
     * elements, the extra element should be in the first list.
     */
    public List<Node<T>> frontBackSplit() {
        Node<T> front = null;
        Node<T> back = null;
        if (head == null) {
            front = null;
            back = null;
        } else if (head.getNext() == null) {
            front = head;
            back = null;
        } else {
            Node<T> fast = head;
            Node<T> slow = head;

            while (fast != null) {
                fast = fast.getNext();
                if (fast == null) {
                    break;
                }
                fast = fast.getNext();
                if (fast != null) {
                    slow = slow.getNext();
                }
            }
            front = head;
            back = slow.getNext();
            slow.setNext(null);
        }
        List<Node<T>> list = new ArrayList<>();
        list.add(front);
        list.add(back);
        return list;
    }


    /**
     * Remove duplicates in a sorted list.
     */
    public void removeDuplicates() {
        int count = countNodes();
        if (count != 0 && count != 1) {
            Node<T> currNode = head;
            do {
                if (currNode.getNext().getData().compareTo(currNode.getData()) == 0) {
                    currNode.setNext(currNode.getNext().getNext());
                } else {
                    currNode = currNode.getNext();
                }
            } while (currNode.getNext() != null);
        }
    }


    /**
     * Remove duplicates in an unsorted list.
     */
    public void removeDuplicatesUnsortedList() {
        int count = countNodes();
        if (count != 0 && count != 1) {
            Node<T> nodeToDelete = head;
            while (nodeToDelete != null) {
                Node<T> currNode = nodeToDelete;
                while (currNode.getNext() != null) {
                    if (currNode.getNext().getData().compareTo(nodeToDelete.getData()) == 0) {
                        currNode.setNext(currNode.getNext().getNext());
                    } else {
                        currNode = currNode.getNext();
                    }
                }
                nodeToDelete = nodeToDelete.getNext();
            }
        }
    }

    public void deleteNode(T data) {
        if (head.getData().compareTo(data) == 0) {
            head = null;
        } else {
            Node<T> currNode = head;
            while (currNode.getNext() != null) {
                if (currNode.getNext().getData().compareTo(data) == 0) {
                    currNode.setNext(currNode.getNext().getNext());
                }
                currNode = currNode.getNext();
            }
        }
    }

    /**
     * Move the head element or the first element from this list to
     * the destination linked list as the destination's new head node.
     */
    public void changeHead(LinkedList<T> destinationList) {
        T currHead = popElement();
        if (destinationList.head == null) {
            // If this is the first element in the destination list , simply
            // add it to the list.
            destinationList.addNode(currHead);
        } else {
            Node<T> next = destinationList.head;
            destinationList.head = new Node<T>(currHead);
            destinationList.head.setNext(next);
        }
    }

    /**
     * Create a new sorted list which is the merged from two original sorted lists.
     * Assume the lists are sorted in ascending order.
     */
    public LinkedList<T> sortedMergeList(LinkedList otherList) {
        if (otherList == null) {
            return this;
        } else if (head == null) {
            return otherList;
        } else {
            Node<T> curr1 = otherList.head;
            Node<T> curr2 = head;
            LinkedList<T> sortedList = new LinkedList<T>();

            while (curr1 != null || curr2 != null) {
                if (curr2 == null ||
                        (curr1 != null && curr1.getData().compareTo(curr2.getData()) < 0)) {
                    sortedList.addNode(curr1.getData());
                    curr1 = curr1.getNext();
                } else {
                    sortedList.addNode(curr2.getData());
                    curr2 = curr2.getNext();
                }
            }

            return sortedList;
        }
    }

    /**
     * Reverse all the nodes in the linked list so that the last node
     * becomes the first node.
     */
    public void reverseList() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> prevNode = null;
        Node<T> currNode = head;
        while (currNode != null) {
            Node<T> nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    /**
     * Find kth node from the end of the linked list when you dont know n
     */
    public T kthNodeFromEnd(int k) {
        Node<T> p = head;
        Node<T> q = head;
        int i = 0;
        while (i < k) {
            q = q.getNext();
            i++;
        }
        while (q != null) {
            p = p.getNext();
            q = q.getNext();
        }
        return p.getData();
    }

    /**
     * Adding two numbers stored as separate link lists and returning
     * final answer as linkedList
     */
    public static Node<Integer> linkedListSum(LinkedList<Integer> list1,LinkedList<Integer> list2) {
        Node<Integer> list1Ptr = list1.head;
        Node<Integer> list2Ptr = list2.head;
        int temp =0;
        Node<Integer> listSumCurrent = new Node<>(0);
        while(list1Ptr!=null && list2Ptr!=null) {
            int currentSum = list1Ptr.getData() + list2Ptr.getData() + temp;
            temp = (list1Ptr.getData() + list2Ptr.getData()+ temp)%10;
            Node<Integer> newNode = new Node<>(currentSum/10);
            listSumCurrent.setNext(newNode);

            list1Ptr = list1Ptr.getNext();
            list2Ptr = list2Ptr.getNext();
            listSumCurrent = listSumCurrent.getNext();

        }

        if(temp>0){
            Node<Integer> newNode = new Node<>(temp);
            listSumCurrent.setNext(newNode);
            listSumCurrent =listSumCurrent.getNext();
        }
        listSumCurrent.setNext(null);
        return  listSumCurrent.getNext();
    }
}
