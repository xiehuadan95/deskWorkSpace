package factory.simpleFactory;


public class Woman implements Person{
    @Override
    public void run() {
        System.out.println("woman run slower");
    }

    @Override
    public void eat() {
        System.out.println("woman eat food");
    }

    @Override
    public void think() {
        System.out.println("woman like think");
    }
}
