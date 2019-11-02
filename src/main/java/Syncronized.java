public class Syncronized {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterThread thread = new CounterThread(counter);
        thread.setName("first Thread");

        CounterThread anotherThread = new CounterThread(counter);
        anotherThread.setName("second Thread");

        thread.start();
        anotherThread.start();
    }
}

class CounterThread extends Thread {
    Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(counter.add());
            //System.out.println(counter.addWithSynchornized());
        }
    }
}

class Counter {
    int counter = 0;

    int add() {
        System.out.println(Thread.currentThread().getName());
        this.counter++;

        return counter;
    }

    synchronized int addWithSynchornized() {
        System.out.println(Thread.currentThread().getName());
        this.counter++;

        return counter;
    }
}