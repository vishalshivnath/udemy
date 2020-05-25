package functional;

public class FP09Threads {
    public static void main(String[] args) {



        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<1000;i++)
                System.out.println(Thread.currentThread().getId()+ ":" + i);
            }
        };

        Thread thread=new Thread(runnable);
        thread.start();

        Thread thread2=new Thread(runnable);
        thread2.start();

        Thread thread3=new Thread(runnable);
        thread3.start();


        Runnable runnable2=()->{
            for (int i =0;i<1000;i++)
                System.out.println(Thread.currentThread().getId()+ ":" + i);
        };

        Thread thread4=new Thread(runnable2);
        thread4.start();


    }
}
