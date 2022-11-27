package factory.factoryAbstract;

import factory.factoryMethod.Auto;
import factory.factoryMethod.Car;

public class MiFactory implements ProductFactory {
    @Override
    public Phone createP() {
        return new MiPhone();
    }

    @Override
    public Computer createC() {
        return new MiComputer();
    }

    @Override
    public Car createCar() {
        return new Auto();
    }
}
