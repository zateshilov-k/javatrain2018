package main.java.task1;
// TODO: move test to test (maven)
// TODO: strings to enum


/* Task:
 * Сделать светофор с выводом цвета в консоль. Вы вводите минуту
 * (от нуля до n) и получаете какой свет горит на светофоре.
 * Первые две минуты красный, потом три минуты желтый и пять минут зеленый.
 */
public class TrafficLight {
    static final int RED_TIME = 2;
    static final int YELLOW_TIME = 3;
    static final int GREEN_TIME = 5;
    static final int FULL_CYCLE_TIME = RED_TIME + YELLOW_TIME + GREEN_TIME;

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