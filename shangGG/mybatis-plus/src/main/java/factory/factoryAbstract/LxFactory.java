package factory.factoryAbstract;

import factory.factoryMethod.Car;
import factory.factoryMethod.Tesla;

public class LxFactory implements ProductFactory{
    @Override
    public Phone createP() {
        return new LxPhone();
    }

    @Override
    public Computer createC() {
        return new LxComputer();
    }

    @Override
    public Car createCar() {
        return new Tesla();
    }
}
