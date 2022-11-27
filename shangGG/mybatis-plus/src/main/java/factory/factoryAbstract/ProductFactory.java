package factory.factoryAbstract;

import factory.factoryMethod.Car;

public interface ProductFactory {
    Phone createP();
    Computer createC();
    Car  createCar();
}
