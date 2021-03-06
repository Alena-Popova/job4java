package popova.condition;

/**
 * Класс выч-щий расстояние между точками в системе координат
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */

public class Point {
    private int x;
    private int y;

    /**
     * Конструктор для класса Point.
     * @param x
     * @param y
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Выводит координаты точек.
     * @param that
     */
    public void showCoordinates(Point that) {
        Point a = this;
        Point b = that;
        // сделаем вывод на консоль.
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
    }

    /**
     * метод distanseTo.
     * рассчитывает дистанцию до точки.
     * @param that_point
     * @return double distanse
     */
    public double distanceTo(Point that_point) {
        double chapterOne = Math.pow(that_point.x - this.x,2);
        double chapterTwo = Math.pow(that_point.y - this.y,2);
     return Math.sqrt(chapterOne + chapterTwo);
    }

    /**
     * Main метод для класса Point
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(2,3);
        Point b = new Point(5,6);
        a.showCoordinates(b);
        System.out.println(a.distanceTo(b));
    }

}
