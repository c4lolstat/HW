import java.util.Random;
import java.util.concurrent.Phaser;

public class Opposition {
    public class Counter {
        private int count = 10;

        public void increment() {
            count++;
        }
        public void decrement() {
			// BEGIN: change to prevent below zero
			//if (count == 0) return;
			// END
            count--;
        }
        public int get() {
            return count;
        }
    }

    public class Wrestler implements Runnable {
        private Counter counter;
        private boolean increment;
        private Random rand;
		private Phaser phaser;

        public Wrestler(Counter counter, boolean increment, final Phaser phaser) {
            this.counter = counter;
            this.increment = increment;
			this.phaser = phaser;
            rand = new Random();
        }
        @Override
        public void run() {
			phaser.arriveAndAwaitAdvance();
                if (increment) {
                    counter.increment();
                } else {
                    counter.decrement();
                }

                int x = counter.get();
                if (x < 0) {
                    t1.interrupt();
                    t2.interrupt();
                    throw new IllegalStateException("We have below zero!");
                }

                System.out.println("Wrestler" + Thread.currentThread().getName() + " " + x);
                try {
					/**
					* If the increment thread sleep more then the decrement below zero can appear.	
					*/
                    Thread.sleep(rand.nextInt(100));
                } catch (InterruptedException e) {
                   System.out.println(e.getMessage());
                }
        }

    }

    private Thread t1, t2;
    public static void main(String[] args) {

        
		new Opposition().start();
    }
    private void start() {
		Phaser phaser = new Phaser();
		phaser.register();

        Counter counter = new Counter();
        
        try {
            while (true) {
                Thread.sleep(100);
		t1 = new Thread(new Wrestler(counter, true, phaser));
        t2 = new Thread(new Wrestler(counter, false, phaser));
        t1.start();
        t2.start();
                if (!(t1.isAlive() && t2.isAlive())) {
                    break;
                }
phaser.arriveAndDeregister();
            }
        } catch (InterruptedException e) {
        }
		
        System.out.println("Finished");
    }
}