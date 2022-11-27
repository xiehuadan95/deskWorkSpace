package factory.factoryMethod;

public class Tesla implements Car{
    @Override
    public void speedUp() {
        System.out.println("150迈");
    }

    @Override
    public void carName() {
        System.out.println("Tesla");
    }
}
