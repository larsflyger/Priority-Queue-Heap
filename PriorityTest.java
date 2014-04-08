/**
 * Driver class for testing PriorityQueueHeap
 * 
 * @author Lars Flyger
 * 
 * @version 4/30/2013
 */

import java.util.Scanner;
import java.util.Random;

public class PriorityTest
{
    public static int menu()
    {
        System.out.println("1. Generate a random integer value between zero and one hundred and enqueue it");
        System.out.println("2. Dequeue the highest priority element and print it");
        System.out.println("3. Print all items in the queue");
        System.out.println("4. QUIT");
        
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        System.out.println("");
        return option;
    }
    
    
    /**
     * Main Method
     */
    public static void main(String[] args)
    {
        PriorityQueueHeap queue = new PriorityQueueHeap();
        
        Random rand = new Random();
        
        int choice = menu();
        
        while(choice != 4) //4 is exit choice
        {
            switch(choice)
            {
                case 1:
                    //create Integer with a random value between zero and one hundred
                    Integer randInt = new Integer(rand.nextInt(101));
                    
                    System.out.println("Number to enqueue: " + randInt.toString());
                    
                    //enqueue Integer
                    queue.enqueue(randInt);
                    break;
                
                case 2:
                    try
                    {
                        //dequeue top integer and print
                        Integer dequeued = (Integer)queue.dequeue();
                        
                        System.out.println("Removed integer " + dequeued.toString() + " from top of priority queue.");
                        
                    } catch(EmptyQueueException e) {
                        System.err.println("EmptyQueueException: " + e.getMessage());
                    }
                    
                    break;
                    
                case 3:
                    //print all items in the queue's array
                    queue.printAll();
                    break;
                    
                case 4:
                    break;
                    
                default:
                    System.out.println("Invalid Selection!");
                    break;
            }
            
            if(choice != 4)
            {
                choice = menu();
            }
            
        }//end while
        
        System.out.println("Goodbye!");
        
    }//end main
}
