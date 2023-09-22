public class test {
    public static void main(String args[]) {
        int n = 32;
        int count = 0;

        int sum = 0;
        count++;

        count++;
        for (int i = 1; i < n; i *=2) {
            count++;

            count++;
            for (int j = 0; j < n; j++) {
                count++;
                sum++;
                count++;
            }
            count++;
            count++;
        }
        count++;
        System.out.println(count);

    }

}
