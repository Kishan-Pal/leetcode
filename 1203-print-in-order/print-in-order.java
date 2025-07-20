class Foo {
    boolean isFirst, isSecond;
    public Foo() {
        this.isFirst = false;
        this.isSecond = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this) {
            printFirst.run();
            isFirst = true;
            notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this) {
            while(!isFirst) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecond = true;
            notifyAll();
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this) {
            while(!isSecond) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
        
    }
}