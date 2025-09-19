import java.util.Arrays;

public class soln {
    public static void main(String args[]){
        double arr[][] = new double[2][2];
        int target = 12;
        arr[0][0] = 5;
        arr[0][1] = 2;
        arr[1][0] = 6;
        arr[1][1] = 1;
        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));
        for(double[] car : arr){
            // System.out.println(car[1]);
            System.out.println(car[0]);

        }
    }
}
