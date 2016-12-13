package Rekursion;

public class Toolbox {

    public static int evenSum(int n) {
        if (n > 0){
            return n + evenSum(n - 1);
        }
        else if (n < 0){
            return n + evenSum(n + 1);
        }
        else{
            return 0;
        }
    }

    public static int multiplication(int x, int y) {
        if (x == 0){
            return 0;
        }
        return y + multiplication(x - 1, y);
    }

    public static void reverse(int[] m) {
        reverseArrayEntry(m, 0, m.length - 1);
    }

    private static void reverseArrayEntry(int[] x, int i, int j){
        if(i<j){//Swap
            int tmp = x[i];
            x[i] = x[j];
            x[j] = tmp;
            reverseArrayEntry(x, ++i, --j);//Recursive
        }
    }

    public static int numberOfOddIntegers(int[] m) {
        return countOdds(m, 0);
    }

    private static int countOdds(int[] x, int i){
        if (i < x.length){
            if (x[i] % 2 != 0){
                return 1 + countOdds(x, ++i);
            }
            else{
                return 0 + countOdds(x, ++i);
            }
        }
        else {
            return 0;
        }
    }

    public static int[] filterOdd(int[] m) {
        return cooleRekursion(0,0,m);
    }

    // Idea: while going down, we find out the count of uneven numbers.
    // Each recursion step also knows the count of uneven numbers *in this step*
    // when reaching the recursion end, we create the array that will hold the uneven numbers (with space for all uneven numbers)
    // While going up, we add the uneven number (if there is one) from each step to the uneven array
    // For each step, the *current* number of uneven numbers is the index where it writes its number into the uneven array
    private static int[] cooleRekursion(int index, int countUngerade, int[] fullArray) {


        boolean ungerade = fullArray[index] % 2 != 0;


        // determine count of uneven numbers while going down
        if (ungerade)
            countUngerade++;

        // if recursion is not done: recurse with index+1
        int[] ungeradeArray;

        if (index+1 < fullArray.length) {
        //  Recursion happens here
            ungeradeArray = cooleRekursion(index+1, countUngerade, fullArray);
        // if recursion is done: create the uneven array
        } else {
            ungeradeArray = new int[countUngerade];
        }


        // add the number to the uneven array if it is uneven
        if (ungerade) {
            ungeradeArray[countUngerade-1] = fullArray[index];
        }

        return ungeradeArray;

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
       print( cooleRekursion(0, 0, array));
    }

    static void print(int[] array){
        for (int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }
}