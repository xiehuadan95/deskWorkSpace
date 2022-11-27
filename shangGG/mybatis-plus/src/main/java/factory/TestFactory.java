package factory;

import factory.factoryAbstract.Computer;
import factory.factoryAbstract.LxFactory;
import factory.factoryAbstract.MiFactory;
import factory.factoryAbstract.Phone;
import factory.factoryMethod.BmwFactory;
import factory.factoryMethod.Car;
import factory.factoryMethod.TeslaFactory;
import factory.simpleFactory.Person;
import factory.simpleFactory.SimpleFactory;

public class TestFactory {
    public static void main(String[] args) {
        //静态工厂模式
        Person man = SimpleFactory.getPerson("man");
        man.run();
        Person woman = SimpleFactory.getPerson("woman");
        woman.eat();
        //二.方法
        Person user = SimpleFactory.getUser();
        user.run();
        //工厂方法模式
        Car tesla = new TeslaFactory().getCar();
        tesla.carName();
        Car bmw = new BmwFactory().getCar();
        bmw.carName();
        bmw.speedUp();
        //根据设计原则，工厂方法模式便于扩展 满足开闭原则
        //实际：简单工厂模式更加符合需求
       //抽象工厂模式
        Phone p = new MiFactory().createP();
        p.name();

        Phone p1 = new LxFactory().createP();
        p1.name();
        Computer c = new LxFactory().createC();
        c.name();
    }
}
