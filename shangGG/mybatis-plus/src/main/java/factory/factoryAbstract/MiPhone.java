package factory.factoryAbstract;

public class MiPhone implements Phone{
    @Override
    public void talk() {
        System.out.println("phone can talk");
    }

    @Override
    public void open() {
        System.out.println("phone can open");
    }

    @Override
    public void name() {
        System.out.println("i am xiaomi Phone");
    }


}
