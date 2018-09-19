package task1;

/* Task:
 * Сделать светофор с выводом цвета в консоль. Вы вводите минуту
 * (от нуля до n) и получаете какой свет горит на светофоре.
 * Первые две минуты красный, потом три минуты желтый и пять минут зеленый.
 */
public class TrafficLight {
    static final int FULL_CYCLE_TIME = 10;
    static final int RED_TIME = 2;
    static final int YELLOW_TIME = 3;
    static final int GREEN_TIME = 5;

    public static String getColorAfterTime(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cant be negative.");
        }
        int modMinutes = minutes % FULL_CYCLE_TIME;
        String result = "";
        if (modMinutes < RED_TIME) {
            result = "red";
        } else if (modMinutes < RED_TIME + YELLOW_TIME) {
            result = "yellow";
        } else if (modMinutes < RED_TIME + YELLOW_TIME + GREEN_TIME) {
            result = "green";
        } else {
            throw new IllegalArgumentException("Wrong argument value");
        }
        return result;
    }
}
