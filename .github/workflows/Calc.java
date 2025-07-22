public class Calc {
    public int addNums(int a, int b) {
        return a + b;
    }

    public int doSomething(int x) {
        return x * 42;
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        System.out.println(c.addNums(5, 10));
        System.out.println(c.doSomething(3));
    }
}
