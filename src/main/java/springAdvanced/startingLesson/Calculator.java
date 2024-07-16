package springAdvanced.startingLesson;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b <0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return a / b;
    }

}
