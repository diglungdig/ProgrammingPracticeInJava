import java.util.Scanner;

public class ArraysAndStrings{


    //Implement an algo to determine if a sting has all unqiue characters. What if you cannot use addtional data structures?
    static boolean IsStringUnique(String str){
        //Bruth Force Approach is to compare each character in this string to the other characters
        //Big O is n^2

        boolean []CharacterFlags = new boolean[26];
        
        //Option 2 Boolean flags array: only allows for non capitalized input, Big O is O(N)
        for(int i = 0; i < str.length(); i++){
            if(CharacterFlags[str.charAt(i) - 'a'] == false){
                CharacterFlags[str.charAt(i) - 'a'] = true;
            }
            else{
                return false;
            }
        }
        /* Option 1 Brute Force
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        */

        //Option 3 Bit manipulation
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }



    public static void main(String[] args) {
        
                
                System.out.println("Main starts");
        
                Scanner input = new Scanner(System.in);
        
                System.out.println(IsStringUnique(input.nextLine()));
        

                input.close();
                
            }


}