package popova.patternreality;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuakBehavior quakBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void  performQuack() {
        quakBehavior.quack();
    }
    public void swim() {
        System.out.println("All ducks can swim");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuakBehavior(QuakBehavior qb) {
        this.quakBehavior = qb;
    }
}
