class Foo {

    public Foo() {
        
    }
    volatile boolean first = false;
    volatile boolean second = false;

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(this){
            first = true;
            printFirst.run();
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(this){
            while(true){
                if(!first)wait();
                else{
                    printSecond.run();
                    second = true;
                    notifyAll();
                    break;
                }
            }
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        synchronized(this){
            while(true){
                if(!(first && second)) wait();
                else{
                    printThird.run();
                    break;
                }
            }
        }
        
    }
}