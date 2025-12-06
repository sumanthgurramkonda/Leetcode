class FooBar {
    private int n;
    private boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        synchronized(this){
            for (int i = 0; i < n; i++) {
                while(!isFoo) wait();
                printFoo.run();
                isFoo = false;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        synchronized(this){
            for (int i = 0; i < n; i++) {
                while(isFoo) wait();
                printBar.run();
                isFoo = true;
                notify();
            }
        }
    }
}