import java.util.Random;

public class Main {
    static boolean isTrue;

    public static void main(String[] args) {

    Random random = new Random();
    int trueRandNumber = random.nextInt(0, 1_000_000_000);

    Thread thread0 = new Thread(new Runnable() {
        @Override
        public void run() {
        for (int i = 0; isTrue = false; i++){
            int secondTrueRandNum = random.nextInt(0, 1_000_000_000);
            if(trueRandNumber != secondTrueRandNum){
                isTrue = false;
            } else if (isTrue){
             break;
            }
        }
        }
    });
    thread0.start();

    Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isTrue != true){

                for (int i = 1; i < 100; i++){
                    System.out.println("Прошло " + i + " сек.");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ignore){

                    }
                }
            }
        }
    });
    timer.start();

    }
}