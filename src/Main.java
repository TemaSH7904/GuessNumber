import java.util.Random;

public class Main {
    static boolean isTrue = false;

    public static void main(String[] args) {

    Random random = new Random();
    int trueRandNumber = random.nextInt(0, 1_000_000_000);

    Thread thread0 = new Thread(new Runnable() {
        @Override
        public void run() {
               for(int i = 0; !isTrue; i++){
                   int secondRandNumber = random.nextInt(0, 1_000_000_000);
                   if(secondRandNumber == trueRandNumber){
                   System.out.println(secondRandNumber);
                       isTrue = true;
                   }
               }
            }
         });
    thread0.start();

    Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
                for (int i = 1; i < 100; i++) {

                    if (!isTrue) {
                        System.out.println("Прошло - "+ i + " сек.");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignore) {

                        }
                    } else {
                        System.out.println("Прошло - "+ i + " сек.");
                        break;
                    }
                }
            }
    });
    timer.start();

    }
}