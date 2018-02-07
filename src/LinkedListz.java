import java.util.Arrays;
import java.util.Scanner;

public class LinkedListz{



    //Question 1: Remove Dups:write code to remove duplicates from an unsorted linked list.
    //Follow-Up: how would you solve this problem if a temporary buffer is not allowed
    public static LinkedList<Character> RemoveDups(LinkedList<Character> list){
        //Option 1: Brute Force Approach: Looking at each node in the list and checking for duplicates with the others
        //Big O is O(n^2) in the case
        LinkedListNode runner1 = list.first;


        LinkedListNode presNode = runner1;

        while(runner1 != null){

           
        LinkedListNode runner2 = runner1;
        

            while(runner2.getNext() != null){

                
                if(runner1.getValue() == runner2.getNext().getValue()){
                    //Duplicates, removes them
                   runner2.setNext(runner2.getNext().getNext());
                }
                else
                {
                    runner2 = runner2.getNext();
                }
            }

            runner1 = runner1.getNext();
        }

        //recursion
        //Option 2: Sort the list then remove the dups
        //Big O is O(nlog n) in the case

        return list;
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
    public static LinkedListNode<Character> LoopDetectionInLinkedList(LinkedList<Character> list){
        //First use double points to get both into the loop and count the loop length
        
        LinkedListNode<Character> runner1 = list.first;
        LinkedListNode<Character> runner2 = list.first.getNext();


        System.out.println("SDitting at node " + runner1.getValue());
        int loopLength = 0;

        while(runner1 != runner2){
            runner1 = runner1.getNext();
            runner2 = runner2.getNext().getNext();
        }

        System.out.println("First Loop Finished");

        //now both are in the loop and sit at the same node, start counting the length of the loop
        System.out.println("SDitting at node " + runner1.getValue());
        

        runner1 = runner1.getNext();
        loopLength++;
        while(runner1 != runner2){
            runner1 = runner1.getNext();
            loopLength++;
        }

        System.out.println("Second Loop Finished");
        
        //We got the loop length, now we back to start and make a slice with loop length starting from the beginning of the linked list using two runners

        runner1 = list.first;

        while(loopLength >= 0){
            runner2 = runner2.getNext();
            loopLength--;
        }
        System.out.println("Third Loop Finished");
        System.out.println("SDitting at node " + runner2.getValue());
        //Proceed both runners with the same speed
        while(runner1 != runner2){
            runner1 = runner1.getNext();
            runner2 = runner2.getNext();
        }

        //We got the loop starting node
        return runner1;
    
    }



    public static void main(String[] args) {

        //Question 2:
        
        LinkedList<Character> list = new LinkedList<Character>();
        /*
        list.insert(new LinkedListNode<Character>('a'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('c'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('b'));
        list.insert(new LinkedListNode<Character>('a'));
        list.insert(new LinkedListNode<Character>('a'));
        list.insert(new LinkedListNode<Character>('a'));
        list.insert(new LinkedListNode<Character>('a'));
  */

        //Question 3:
        //Example: A->B->C->D->E->C
        LinkedListNode<Character> CNode = new LinkedListNode<Character>('c');
        LinkedListNode<Character> ENode = new LinkedListNode<Character>('e');
        
        list.append(new LinkedListNode<Character>('a'));
        list.append(new LinkedListNode<Character>('b'));
        list.append(CNode);
        list.append(new LinkedListNode<Character>('d'));
        list.append(new LinkedListNode<Character>('f'));
        list.append(new LinkedListNode<Character>('k'));
        
        list.append(ENode);
        list.last.setNext(CNode);
        //list.print();

        System.out.println("Loop Detection Result is " + LoopDetectionInLinkedList(list).getValue());
        
        //list.print();
        
        
        //System.out.println("Check Palindrome Result is " + CheckPalindromeOnList(list));

        //list = RemoveDups(list);


        //list.print();

        //System.out.println("Check Palindrome Result is " + RemoveDups(list));
        
        
//        System.out.println("Main starts");

//        Scanner input = new Scanner(System.in);

//        input.close();
        
    }


}