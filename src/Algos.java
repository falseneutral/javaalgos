import java.util.Random;

public class Algos {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray(){
        for(int i = 0 ; i < arraySize; i++){
            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    public void printArray(){
        System.out.println("----------");
        for(int i = 0; i < arraySize; i++){
            System.out.print("| " + i + " |");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    public int getValueAtIndex(int index){
        if (index < arraySize)
            return theArray[index];
        else
            return 0;
    }

    public boolean doesArrayContainValue(int searchValue){
        boolean contained = false;
        for (int i = 0; i < arraySize; i++){
            if (theArray[i] == searchValue) {
                contained = true;
            }
        }
        return contained;
    }

    public void deleteIndex(int deleteIndex){
        if (deleteIndex < arraySize) {
            for (int i = deleteIndex; i < arraySize; i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }


    public static void main(String[] args){

        Algos algo = new Algos();
        algo.generateRandomArray();
        algo.printArray();
        System.out.println("Value at 3: " + algo.getValueAtIndex(3));
        System.out.println("Array contains 13: " + algo.doesArrayContainValue(13));
        algo.deleteIndex(9);
        algo.printArray();
    }


}
