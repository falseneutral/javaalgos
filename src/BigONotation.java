public class BigONotation {


    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;

    BigONotation(int size){
        arraySize = size;
        theArray = new int[size];
    }

    public static void main(String[] args){

        BigONotation test1 = new BigONotation(1000000);
        test1.generateRandomArray();

        BigONotation test2 = new BigONotation(2000000);
        test2.generateRandomArray();

        BigONotation test3 = new BigONotation(3000000);
        test3.generateRandomArray();

        BigONotation test4 = new BigONotation(4000000);
        test4.generateRandomArray();

        //test1.linearSearch(20);
        //test2.linearSearch(20);
        //test3.linearSearch(20);
        //test4.linearSearch(20);

        //test1.bubbleSort();
        //test2.bubbleSort();
        //test3.bubbleSort();
        //test4.bubbleSort();

        //test1.binarySearch(20);
        //test2.binarySearch(20);
        //test3.binarySearch(20);
        //test4.binarySearch(20);

        startTime = System.currentTimeMillis();
        test1.quickSort(0, test1.itemsInArray);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        test2.quickSort(0, test2.itemsInArray);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        test3.quickSort(0, test3.itemsInArray);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        test4.quickSort(0, test4.itemsInArray);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (endTime - startTime));


    }


    // example of O(1)
    public void addItemToArray(int newItem){
        theArray[itemsInArray++] = newItem;
    }

    // example of O(N)
    public void linearSearch(int value){
        boolean valueInArray = false;
        String indexWithValue = "";

        startTime = System.currentTimeMillis();

        for(int i = 0; i < arraySize; i++){
            if (theArray[i] == value){
                valueInArray = true;
                indexWithValue += " ";
            }
        }

        System.out.println("Value found: " + valueInArray);
        endTime = System.currentTimeMillis();
        System.out.println("Linear search took " + (endTime - startTime));

    }

    // example of O(N^2)
    public void bubbleSort(){
        startTime = System.currentTimeMillis();

        for(int i = arraySize - 1; i > 1; i--){
            for(int j = 0; j < i; j++){
                if(theArray[j] > theArray[j + 1]){
                    swapValues(j, j+1);
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort took " + (endTime - startTime));
    }


    //example of O(log N)
    public void binarySearch(int value){
        startTime = System.currentTimeMillis();

        int lowIndex = 0;
        int hiIndex = arraySize - 1;

        int timesThrough = 0;

        while(lowIndex <= hiIndex){
            int middleIndex = (hiIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value)
                hiIndex = middleIndex - 1;
            else {
                System.out.println("Found a match in index " + middleIndex);
                lowIndex = hiIndex + 1;
            }
            timesThrough++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("BinarySearch took " + (endTime - startTime));
        System.out.println("Times through " + timesThrough);
    }

    //example of O(N log N)
    public void quickSort(int left, int right){
        if (right - left <= 0){
            return;
        }

        else{
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);
        }
    }



    public void generateRandomArray(){
        for (int i = 0; i < arraySize; i++){
            theArray[i] = (int) (Math.random()*1000) + 10;
        }
        itemsInArray = arraySize - 1;
    }

    public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    public int partitionArray(int left, int right, int pivot){
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true){
            while(theArray[++leftPointer] < pivot)
                ;

            while(rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            if(leftPointer >= rightPointer){
                break;

            }else {
                swapValues(leftPointer, rightPointer);
            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }

}
