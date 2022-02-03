package Home_work_1;

//Класс кот
public class Cat extends Gang {

    public Cat(String name, int maxRunning, int maxJump) {
        super(name, maxRunning, maxJump);
    }


    @Override
    public void runningTreadmill(Treadmill treadmill) {
        if (treadmill.getRunnig() <= getMaxRunning())
            System.out.println("Кот " + getName() + " пробежал " + treadmill.getRunnig() + " метров" );
        else System.out.println("Кот " + getName() + " не смог пробежать " + treadmill.getRunnig() + " метров");
    }

    @Override
    public void jumpingWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Кот " + getName() + " перепрыгнул препятствие высотой " + wall.getHeight() + " метра");
        else System.out.println("Кот " + getName() + " не смог перепрыгнуть препятствие высотой " + wall.getHeight());
    }
}
