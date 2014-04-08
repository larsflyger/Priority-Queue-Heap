/**
 * A priority queue class with a heap data structure implemented over an ArrayList, with the largest value known as the max-heap.
 * 
 * @author Lars Flyger
 * @version 4/29/2013
 */

import java.util.ArrayList;

public class PriorityQueueHeap<E extends Comparable>
{
    //pointer to the arraylist
    private ArrayList<E> list;
    
    //maximum size of the list is 127
    private static final int CAPACITY = 127;
    
    /**
     * Constructor for objects of class PriorityQueueHeap
     */
    public PriorityQueueHeap()
    {
        list = new ArrayList<E>();
    }
    
    /**
     * inserts a new item into the queue and then "heapifies" to maintain the heap. Will fail if queue is at maximum capacity.
     * 
     * @param   data    the item to add to the array
     * 
     * @return  true if data is successfully add, false otherwise
     */
    public boolean enqueue(E data)
    {
        if (list.size() >= CAPACITY)
        {
            return false;
        }
        
        else
        {
            list.add(data);
            
            //set parent and child indexes
            int child = list.size() - 1;
            int parent = (child - 1) / 2;
            
            //while parent is greater than zero and value of parent is less than value of child
            while(parent >= 0 && list.get(parent).compareTo(list.get(child)) < 0)
            {
                //swap value of parent and child
                E temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);
                
                //set child equal to parent
                int tempParent = parent;
                child = tempParent;
                
                
                //set new parent value
                parent = (child - 1) / 2;
            }
            
            return true;
        }
    }
    
    /**
     * removes and returns the top element of the priority queue, rearranging the list to maintain heap structure
     * 
     * @param   void
     * 
     * @return  the top element of the priority queue
     */
    public E dequeue() throws EmptyQueueException
    {
        if(list.size() == 1)
        {
            E result = list.get(0);
            
            return result;
        }
        
        else if (!list.isEmpty())
        {
            //save the value of the first element
            E result = list.get(0);
            
            //remove the last element and set the first element to this value
            E temp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.set(0, temp);
            
            //set parent
            int parent = 0;
            
            while(true)
            {
                //set leftChild and rightChild
                int leftChild = (2 * parent) + 1;
                int rightChild = leftChild + 1;
                
                if(leftChild >= list.size())
                {
                    break;
                }
                
                //assume the larger child is leftChild
                int maxChild = leftChild;
                
                //compare leftChild and rightChild, if rightChild is larger, set maxChild to rightChild
                if(rightChild < list.size() && list.get(rightChild).compareTo(list.get(leftChild)) > 0)
                {
                    maxChild = rightChild;
                }
                
                //if parent is less than or equal to maxChild, swap them. "Or equal" is to ensure duplicate values that are added later
                //have lower priority
                if(list.get(parent).compareTo(list.get(maxChild)) <= 0)
                {
                    temp = list.get(maxChild);
                    list.set(maxChild, list.get(parent));
                    list.set(parent, temp);
                    
                    parent = maxChild;
                }
                
                else
                {
                    break;
                }
            }
            
            return result;
        }
        
        else
        {
            throw new EmptyQueueException("Queue is empty!");
        }
    }
    
    /**
     * returns the number of elements in the queue
     * 
     * @param   void
     * 
     * @return  the number of elements in the queue
     */
    public int size()
    {
        return list.size();
    }
    
    /**
     * Prints all the items in the queue in String form
     * 
     * @param   void
     * 
     * @return  void items are printed to System.out
     */
    public void printAll()
    {
        for(int i = 0; i < list.size(); i++)
        {
            String string = list.get(i).toString();
            
            System.out.println(string);
        }
    }
}