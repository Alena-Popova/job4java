package popova.patternreality;

public class ModelDuck extends Duck {

    public ModelDuck(){
        quakBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("Im model Duck");
    }
}
