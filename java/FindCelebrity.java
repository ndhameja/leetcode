public class FindCelebrity {

    public int findCelebrity(int n) {
        boolean[] normal = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (normal[i] == true) {
                continue;
            }
            boolean cele = true;

            for (int j = 0; j < n; j ++) {
                if (j == i) {
                    continue;
                }
                if (knows(j, i)) {
                    normal[j] = true;
                }
                if (!knows(j, i) || knows(i, j)) {
                    cele = false;
                    break;
                }
            }
            if (cele == true) {
                return i;
            }
        }
return 1;
    }

    public boolean knows(int i, int j){
        return true;
    }
}
