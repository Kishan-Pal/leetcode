class ZeroEvenOdd {
    private int n;
    private int index;
    private boolean turnOdd;
    private boolean turnEven;
    private int evenNumber;
    private int oddNumber;
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.index = 0;
        this.turnOdd = true;
        this.turnEven = false;
        this.evenNumber = 2;
        this.oddNumber = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(index < 2 * n) {
            if(index%2 != 0) {
                wait();
                continue;
            }
            printNumber.accept(0);
            index++;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(index < 2 * n) {
            if(turnOdd || index%2 == 0) {
                wait();
                continue;
            }
            printNumber.accept(evenNumber);
            evenNumber += 2;
            index++;
            turnOdd = !turnOdd;
            turnEven = !turnEven;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(index < 2 * n) {
            if(turnEven || index%2 == 0) {
                wait();
                continue;
            }
            printNumber.accept(oddNumber);
            oddNumber += 2;
            index++;
            turnOdd = !turnOdd;
            turnEven = !turnEven;
            notifyAll();
        }
    }
}