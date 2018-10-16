public class Test {
    public static void main(String args[]) {
        int arr[] = {2,4,5,6,7,8,2,3,6,0};
        for (int i = 9; i >= 0; i--) {
//            System.out.println(arr[i]);
        }
        for (int i : arr) {
            System.out.println(arr[i]);
        }
    }
}
