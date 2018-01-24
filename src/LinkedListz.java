import java.util.Arrays;
import java.util.Scanner;

public class LinkedListz{



    //Question 1: Remove Dups:write code to remove duplicates from an unsorted lisked list.
    //Follow-Up: how would you solve this problem if a temporary buffer is not allowed
    public LinkedList<Integer> RemoveDups(LinkedList<Integer> list){
        //Option 1: Brute Force Approach: Looking at each node in the list and checking for duplicates with the others
        //Big O is O(n^2) in the case

        //Option 2: Sort the list then remove the dups
        //Big O is O(nlog n) in the case

        return new LinkedList<Integer>();
    }

    public LinkedList<Integer> RemoveDupsWithoutBuffer(LinkedList<Integer> list){
        return new LinkedList<Integer>();
    }


    //Question 2: Implement a function to check if a linked list is a palindrome

    static boolean CheckPalindromeOnList(LinkedList<Character> list){
        //Algo:First, use two runner with differnt paces. The second runner is two times fast than the first runner
        //1. Once the second runner reaches the end of the list, the fisrt runner is in the middle of the list

        //2.Keep the first runner, and let the second runner start from the head of the list again and start comparing with the first runner
        //Corner case: odd number/even number of elements in the list

        //Character runner1 = list.first.getValue();
        //Character runner2 = list;

        //a
        //a
        LinkedListNode runner1 = list.first;
        LinkedListNode runner2 = list.first;

        int count = 0;

        //1.
        //Problem: null pointer, runner goes too far!!!!
        while(runner2 != null){
            runner1 = runner1.getNext();
            count++;
            runner2 = runner2.getNext().getNext();

            System.out.println("Palindrome half count is "+ count);
        }




        runner2 = list.first;

        //2. Comparing
        while(runner1 != null){
            if(runner2.getValue() != runner1.getValue()){

                System.out.println("Runner 2 is "+ runner2.getValue() + "Runner 1 is "+ runner1.getValue());
                return false;
            }
            runner1 = runner1.getNext();
            runner2 = runner2.getNext();
        }

        return true;
    }

    //Question 3: Loop detection
    //Gievn a circulr linked list, implement an algorithm that returns the node at the beginning of the loop
    //Example: A->B->C->D->E->F->G->C
    public LinkedListNode<Character> LoopDetectionInLinkedList(LinkedList<Character> list){
        

    }

    
    public static void main(String[] args) {

        //Question 2:
        LinkedList<Character> list = new LinkedList<Character>();
        list.insert(new LinkedListNode<Character>('a'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('c'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('a'));
  
        System.out.println("Check Palindrome Result is " + CheckPalindromeOnList(list));
        
//        System.out.println("Main starts");

//        Scanner input = new Scanner(System.in);

//        input.close();
        
    }


}