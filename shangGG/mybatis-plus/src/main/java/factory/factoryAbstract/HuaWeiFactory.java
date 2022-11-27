package factory.factoryAbstract;

import factory.factoryMethod.Bmw;
import factory.factoryMethod.Car;

public class HuaWeiFactory implements ProductFactory{
    @Override
    public Phone createP() {
        return new HuaWeiPhone();
    }

    @Override
    public Computer createC() {
        return new HuaWeiComputer();
    }

    @Override
    public Car createCar() {
        return new Bmw();
    }
}
