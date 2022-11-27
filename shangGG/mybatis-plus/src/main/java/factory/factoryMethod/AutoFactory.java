package factory.factoryMethod;

public class AutoFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Auto();
    }
}
