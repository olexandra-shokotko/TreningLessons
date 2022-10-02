package HW12.Task1;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread secondThread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Пройшло 5 секунд");
                }
            }
        };

        secondThread.start();

        while (!Thread.currentThread().isInterrupted()) {
            int delta = (int) (System.currentTimeMillis() - startTime) / 1000;
            System.out.println(delta);
            Thread.sleep(1000);
        }
    }
}
