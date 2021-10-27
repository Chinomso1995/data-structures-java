public class array {

    public static void reverse (int[] numbers, int start, int end){
        while(start < end){
            int temp = numbers [start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void main (String[] args){
        int[] numbers = {2, 1, 4, 5, 6, 7};
        reverse(numbers, 0, numbers.length-1);
    }

    public static void moveZeroes (int[] arr, int n){
        int j = 0;
        for (int i = 0; i<n; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
    }
}
