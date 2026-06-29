public class SumOfArrays {
    static int arr[] = { 12, 3, 4, 15 };

    static int arraySum()
    {
        int sum = 0;

        // Iterate through all elements and add them to sum
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return sum;


        // return Arrays.stream(arr).sum(); Using Stream
    }

    public static void main(String[] args)
    {
        System.out.println(arraySum());
    }
}