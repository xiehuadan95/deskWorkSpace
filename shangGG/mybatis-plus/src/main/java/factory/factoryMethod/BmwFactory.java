package factory.factoryMethod;

public class BmwFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
