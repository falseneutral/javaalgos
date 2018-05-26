public class ArrayHandler {

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

    public void insertValue(int value){
        if(arraySize < 50){
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    public String linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexsWithValue = "";

        System.out.println("The value was found in the following:" );

        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == value){
                valueInArray = true;
                System.out.println(i + " ");
                indexsWithValue += i + " ";
            }
        }

        if(!valueInArray){
            indexsWithValue = "None";
            System.out.print(indexsWithValue);
        }
        System.out.println();

        return indexsWithValue;
    }

    public static void main(String[] args){

        ArrayHandler algo = new ArrayHandler();
        algo.generateRandomArray();
        algo.printArray();
        System.out.println("Value at 3: " + algo.getValueAtIndex(3));
        System.out.println("Array contains 13: " + algo.doesArrayContainValue(13));
        algo.deleteIndex(4);
        algo.printArray();
        algo.insertValue(14);
        algo.printArray();
        algo.linearSearchForValue(12);
    }


}
