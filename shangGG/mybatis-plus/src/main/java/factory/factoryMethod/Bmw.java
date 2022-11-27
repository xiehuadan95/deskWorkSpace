package factory.factoryMethod;

public class Bmw implements Car{
    @Override
    public void speedUp() {
        System.out.println("180迈");
    }

    @Override
    public void carName() {
        System.out.println("BMW");
    }
}
