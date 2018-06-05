package popova.patternreality;

public class DuckyDecoy extends Duck {

    public DuckyDecoy(){
        quakBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    private  final void setFlyBehavior() {
    }

    private final void setQuakBehavior() {
    }
    public void display() {
        System.out.println("Ducky Decoy!");
    }
}
