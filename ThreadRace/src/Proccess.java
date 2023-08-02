import java.util.ArrayList;

public class Proccess implements Runnable {
    private final ArrayList<Integer> list;
    private final ArrayList<Integer> evenNumbers;
    private final ArrayList<Integer> oddNumbers;

    Proccess(ArrayList<Integer> list, ArrayList<Integer> evenNumbers, ArrayList<Integer> oddNumbers) {
        this.list = list;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (Integer num : list) {
                if (num % 2 == 0) {
                    synchronized (evenNumbers) {
                        evenNumbers.add(num);
                    }
                } else {
                    synchronized (oddNumbers) {
                        oddNumbers.add(num);
                    }
                }
            }
        }
    }
}
