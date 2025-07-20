class H2O {
    int numHydrogenReleased;
    public H2O() {
        numHydrogenReleased = 0;
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		while(numHydrogenReleased == 2) {
            wait();
        }
        numHydrogenReleased++;
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(numHydrogenReleased != 2) {
            wait();
        }
        numHydrogenReleased = 0;
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        notifyAll();
    }
}