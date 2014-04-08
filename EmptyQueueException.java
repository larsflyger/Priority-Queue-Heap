/**
 * Custom exception class thrown when dequeue method in PriorityQueueHeap is called when queue is empty
 * 
 * @author Lars Flyger
 * @version 4/20/2013
 */
public class EmptyQueueException extends Exception
{
    public EmptyQueueException(String msg)
    {
        super(msg);
    }
}