package StackTrace;

public class StackTraceTest {

    public static int factorial(int n){
        System.out.printf("Factorial (%d) \n", n);
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement frame : frames){
            System.out.println(frame);
        }
        int r;
        if (n<=1) r = 1;
        else r = n * factorial(n-1);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(StackTraceTest.factorial(4));
    }
}
