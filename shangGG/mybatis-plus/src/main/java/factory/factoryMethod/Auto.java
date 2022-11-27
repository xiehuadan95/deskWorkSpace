package factory.factoryMethod;

public class Auto implements Car {
    @Override
    public void speedUp() {
        System.out.println("200迈");
    }

    @Override
    public void carName() {
        System.out.println("Auto");
    }
}
