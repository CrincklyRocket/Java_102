import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();



        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);

        int batchSize = 25;
        for (int i = 0; i < 4; i++) {
            executor.execute(new Proccess(list, evenNumbers, oddNumbers));
        }
            executor.shutdown();

        while (!executor.isTerminated()) {

        }
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
