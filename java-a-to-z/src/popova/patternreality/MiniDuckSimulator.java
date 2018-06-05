package popova.patternreality;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        Duck decoy = new DuckyDecoy();
        decoy.performFly();
        decoy.performQuack();
        decoy.setFlyBehavior(new FlyBehavoirRocket());
        decoy.performFly();
        decoy.performQuack();
    }
}
