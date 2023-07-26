package HW2;

public class exs2 {
    public static void main(String[] args) {
        
    
    
    try {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int d = 0;
        //чтобы не попадать в исключение можно добавить / (double) d
        double catchedRes1 = intArray[8] /  d;
        System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
        System.out.println("Поймано исключение: " + e);
    }

   } 
}
