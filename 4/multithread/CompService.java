import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;


public class CompService {
    public class Counter {
        private int count = 10;

        public synchronized void increment() {
            count++;
        }
        public synchronized void decrement() {
            count--;
        }
        public int get() {
            return count;
        }
    }

    public class CounterProducer implements Callable<Counter> {

		private Counter counter;

        public CounterProducer(Counter counter) {
			this.counter = counter;
		}

        @Override
        public Counter call() throws Exception{
			int cnt = counter.get();
			System.out.println("producing counter aka increment: " + cnt);
			if ( cnt < 10){
				counter.increment();
			}			
			Thread.sleep(5000L);
			return counter;
        }

    }

	public class CounterConsumer implements Runnable {
		private CompletionService service;

		public CounterConsumer (CompletionService service){
			this.service = service;
		}

		@Override	
		public void run(){
			try {
				Future<Counter> result = service.take();
				Counter cnt = result.get();
				System.out.println("consuming counter aka decrement: "+cnt.get());
				if (cnt.get() > 5){
					cnt.decrement();
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	public class CompletionServiceProvider {

		private Executor exec = Executors.newCachedThreadPool();

		private CompletionService completionService = new ExecutorCompletionService(exec);
		public Executor getExec() {
			return exec;
		}
		public CompletionService getCompletionservice() {
			return completionService;
		}
	}
    
    public static void main(String[] args) {
        new CompService().start();
    }

    private void start() {
		Executor exec = Executors.newCachedThreadPool();
		CompletionService completionService = new ExecutorCompletionService(exec);
        Counter counter = new Counter();


		while (true) {
			CounterProducer prod = new CounterProducer(counter);
			completionService.submit(prod);
			new Thread(new CounterConsumer(completionService)).start();
		}

    }
}