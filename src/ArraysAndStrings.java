import java.util.Arrays;
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

    //given two strings, write a method to decide if one is a permutation of the other
    static boolean CheckPermutation(String str1, String str2){
        //If the first string contains all the chars the second string(with the exact number of appearance for each entry) has then it is a permutation of the first string
        //First we check if these two strings have the same length, if not then they are not permutation
        
        //Options 1: Brute Force Solution: we assume the strings only contain characters from 'a' - 'z'
        //This option has the Big O of O(m + n)
        /*
        if(str1.length() == str2.length()){
            int [] CheckArray = new int[26];
            //Setting up the check array
            for(int i = 0; i < str1.length(); i++){
                CheckArray[str1.charAt(i) - 'a']++;
            }

            //Varifying the check array
            for(int i = 0; i < str2.length(); i++){
                if(CheckArray[str2.charAt(i) - 'a'] > 0){
                    CheckArray[str2.charAt(i) - 'a']--;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
*/
        //Option 2: Using a Hashmap to map character entry on the string as key and setting the value as the times it appears


        //Option 3: Sort two arrarys and comapre them side by side

        char[] chararray1 = str1.toCharArray();
        char[] chararray2 = str2.toCharArray();

        Arrays.sort(chararray1);
        Arrays.sort(chararray2);

        for(int i = 0; i < chararray1.length; i++){
            if(chararray1[i] != chararray2[i])
                return false;
        }
        return true;
    }

    //Replacing the space in a string with "%20"
    //Example: "Mr John Smith     " => "Mr%20John%20Smith"
    static String SpaceTo20(String str){
        //Option 1: Brute Force Aproach: Utilizing StringBuilder to concatanate/replace the strings with 20%
        //Algo:

        StringBuilder strb = new StringBuilder(str);
        int i = 0;

        while( i < strb.length()){
            //Recognize the Space in the string
            if(strb.charAt(i) == ' '){
                if(( i - 1 >= 0 && strb.charAt(i-1) != ' ') && (i + 1 < strb.length() && strb.charAt(i+1) != ' ') ){
                    //True Space
                    strb.replace(i, i+1, "20%");

                    i+=3;
                }
                else{
                    //False Space, delete from the string
                    strb.deleteCharAt(i);
                }
            }
            else{
                i++;
            }

        }

        return strb.toString();
    }


    //Palindrome Permutation Checking
    //Example: Tact Coa is true because "taco cat" or "atco cta"
    static boolean CheckPalindromePermutation(String str){
        

        return false;
    }



    public static void main(String[] args) {
                
                System.out.println("Main starts");
        
                Scanner input = new Scanner(System.in);
        
                //System.out.println(IsStringUnique(input.nextLine()));
                
                //System.out.println(CheckPermutation(input.nextLine(), input.nextLine()));

                System.out.println(SpaceTo20(input.nextLine()));

                input.close();
                
            }


}