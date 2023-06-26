
package towerofhanoi;

import java.util.EmptyStackException;
import bag.Node;
import stack.StackInterface;

/**
 * @author Pranav Poodari
 * @version 10.18.2022
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {
    
    private int size;
    private Node topNode;
    
    /**
     * Default constructor for LinkedStack and sets topNode to null
     */
    public LinkedStack() {
        topNode = null;
    }
    
    /**
     * Size of LinkedStack
     * @return
     *        size of LinkedStack
     */
    public int size() {
        return size;
    }

    /**
     * Clears a LinkedStack
     */
    @Override
    public void clear() {
        while (topNode != null) {
            Node n = topNode;
            topNode = topNode.getNextNode();
            n = null;
            
        }
        size = 0;
        
    }

    /**
     * Checks if LinkedStack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    
    /**
     * Returns the value of the topNode
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return (T)topNode.getData();
    }

    /**
     * Returns the value of the topNode and removes the topNode
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node n = topNode;
        topNode = topNode.getNextNode();
        size--;
        return (T)n.getData();
    }

    /**
     * Adds a new node to the top of the stack
     */
    @Override
    public void push(T anEntry) {
        Node n = new Node(anEntry);
        n.setNextNode(topNode);
        topNode = n;
        size++;
    }
    
    /**
     * Prints the stack from top to bottom
     * @return
     *        String representation of stack from top to bottom
     */
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        else {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            Node temp = topNode;
            while (temp != null) {
                sb.append(temp.getData());
                if (temp.getNextNode() != null) {
                    sb.append(", ");
                    
                }
                temp = temp.getNextNode();
                
            }
            sb.append("]");
            return sb.toString();
        }
        
    }
    
    

    
    private class Node<T> {

        /**
         * Node entry
         */
        private T data;
        
        /**
         * Link to next node
         */
        private Node next;
        
        
        public Node(T entry, Node<T> node) { 
            this(entry); 
            this.setNextNode(node); 
        }

        
        /**
         * Constructor
         * 
         * @param dataPortion
         *            the data to be stored in the node
         */
        public Node(T data) { 
            this.data = data; 
        } 


        /**
         * Returns the data portion of the node
         * 
         * @return data portion
         */
        private T getData() {
            return this.data;
        }

        /**
         * Sets the data portion of the node
         * 
         * @param newData
         *            data to store in the node
         */
        private void setData(T newData) {
            this.data = newData;
        } 

        /**
         * Returns the next node
         * 
         * @return reference to the next node
         */
        private Node<T> getNextNode() {
            return this.next;
        } 

        /**
         * Sets the next node reference
         * 
         * @param nextNode
         *            reference to next node
         */
        private void setNextNode(Node<T> nextNode) {
            this.next = nextNode;
        } 
    }

}
