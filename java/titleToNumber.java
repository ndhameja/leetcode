public class titleToNumber {


    //https://www.geeksforgeeks.org/find-excel-column-number-column-title/
    public int titleToNumberCalculation(String s){
        int result=0;
        for(int i=0;i<s.length();i++){
            result*=26;
            result+=s.charAt(i)-'A'+1;
        }

        return result;
    }

    // function that reverses array and stores it
    // in another array
    //https://www.geeksforgeeks.org/reverse-an-array-in-java/
    public void reverse(int a[], int n){
        int[] b =new int[n];
        int j = n;

        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }
}
