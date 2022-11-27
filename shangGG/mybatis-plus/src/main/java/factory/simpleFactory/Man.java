package factory.simpleFactory;


public class Man implements Person{
    @Override
    public void run() {
        System.out.println("man run fast");
    }

    @Override
    public void eat() {
        System.out.println("man like eat meat");
    }

    @Override
    public void think() {
        System.out.println("man like think");
    }
}
