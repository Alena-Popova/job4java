import java.util.List;

/**
 * Нужно реализовать класс.
 *
 * class Store {
 *
 *
 *    Info diff(List<User> previoues, List<User> current)
 *
 *    static class User {
 *       int id;
 *       String name;
 *
 * }
 *
 * метод должен возвращать статистику об изменении коллекции.
 *
 * Сколько добавлено новых.
 *
 * Сколько изменено. Изменено считается объект в котором изменилось имя. а id осталось одинаковым.
 *
 * Сколько удалено.
 *
 * @author HelenaPopova
 */
public class Store {

    public Info diff(List<User> previoues, List<User> current) {
        Info info = new Info(previoues, current);
        return info.getStore();
    }
}
