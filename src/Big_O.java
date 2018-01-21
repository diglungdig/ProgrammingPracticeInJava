import java.util.Scanner;

public class Big_O{

    void foo(int[] array){
        int sum = 0;
        int product = 1;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        for(int i = 0; i< array.length; i++){
            product *= array[i];
        }
        //Big_O is O(N)
    }

static boolean isPrime(int n){
    for(int x = 2; x*x <= n ; x++){
        if(n % x == 0){
            return true;
        }
    } 
    return false;

    //Big O is O(sqr(N))
}


static void permutation(String str){
    permutation(str, "");
}


//Dont understand how its done in this function
static void permutation(String str, String prefix){
    if(str.length() == 0){
        System.out.println("!Permutation is " + prefix);
    }else{
        for(int i = 0; i < str.length(); i++){
            String rem = str.substring(0, i) + str.substring(i+1);

            System.out.println("rem is " + rem);
            System.out.println("prefix is " + prefix + str.charAt(i));
            System.out.println();

            permutation(rem, prefix + str.charAt(i));
        }

    }
}

static int powersof2(int n){
    if(n < 0){
        return 0;
    }
    else if( n == 1){
        return 1;
    }
    else{
        int prev = powersof2(n/2);
        int curr = prev * 2;

        System.out.println(curr);

        return curr;
    }

    //Big O is O(log n)
}

static int numChars = 26;

static void printSortedStrings(int remaining){
    printSortedStrings(remaining, "");
}

static void printSortedStrings(int remaining, String prefix){
    if(remaining == 0){
        if(isInOrder(prefix)){
            System.out.println(prefix);
        }
    }
    else{
        for(int i = 0; i < numChars; i++){
            char c = ithLetter(i);
            printSortedStrings(remaining - 1, prefix + c);
        }
    }
}

static boolean isInOrder(String s){
    for(int i = 1; i < s.length(); i++){
        int prev = ithLetter(i - 1);
        int curr = ithLetter(i);

        if(prev > curr){
            return false;
    }
    }
    return true;
}



static char ithLetter(int i){
    return (char)(((int) 'a') + i);
}
    public static void main(String[] args) {

        System.out.println("Main starts");

        Scanner input = new Scanner(System.in);

        printSortedStrings(input.nextInt() );
       // permutation(input.nextLine());
        //boolean cached = isPrime(i);
        //System.out.println("Result is " + cached);

        input.close();
        
    }
}