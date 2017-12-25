package adtInterface;

/**
 *
 * @author ng li poh
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    private Node firstNode;
    private int totalEntries = 0;

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        //if the list is empty, store the first record  in the list
        if (isEmpty()) {
            firstNode = newNode;

        } else {
            //create a temperory node point to the first node
            //search until find the last node within the list
            //point the next node to the new node, then add the number of entries
            Node currentNode = firstNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;

        }
        totalEntries++;

    }

    @Override
    public T getEntry(int position) {
        T result = null;
        //1.determines the position whether is between 1 to the total number of entries 
        if (position >= 1 && position <= totalEntries) {
            Node currentNode = firstNode;
            //2.search one by one until the given position is found
            for (int i = 1; i < position; i++) {
                currentNode = currentNode.nextNode;
            }
            result = currentNode.data;
        }

        return result;
    }

    @Override
    public int getTotal() {
        return totalEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        //when the list is enpty, the total number of entris should be 0
        result = totalEntries == 0;

        return result;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        //determines whether the givenPosition is between 1 to the total entries
        if ((givenPosition >= 1) && (givenPosition <= totalEntries)) {
            if (givenPosition == 1) {         // case 1: remove first entry
                result = firstNode.data;
                firstNode = firstNode.nextNode;
            } else {                         // case 2: givenPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.nextNode;		           // advance nodeBefore to its next node
                }
                result = nodeBefore.nextNode.data;
                //make the next node of the node before point to node after the one to be deleted(to disconnect node from chain)
                nodeBefore.nextNode = nodeBefore.nextNode.nextNode;	
            }

            totalEntries--;
        }
        return result;
    }

    private class Node {

        private T data;
        private Node nextNode;

        private Node(T data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        private Node(T data) {
            this.data = data;
            this.nextNode = null;
        }

    }

}
