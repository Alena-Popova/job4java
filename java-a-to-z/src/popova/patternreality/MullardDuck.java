package popova.patternreality;

public class MullardDuck extends Duck {

    public MullardDuck(){
        quakBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("Im mullard duck");
    }
}
