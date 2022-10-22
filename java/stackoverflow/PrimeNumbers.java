package stackoverflow;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println("Prime numbers between 1 to 100 are: ");
        for(int i = 1; i <= 100; i++){
            if(isPrimeNumber(i))
            {
                System.out.print(" " + i);
            }
        }
    }

    public static boolean isPrimeNumber(int number){
        if (number <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}
