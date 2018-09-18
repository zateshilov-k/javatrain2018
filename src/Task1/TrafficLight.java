package Task1;

public class TrafficLight {
    /* Task:
       Сделать светофор с выводом цвета в консоль. Вы вводите минуту
       (от нуля до n) и получаете какой свет горит на светофоре.
       Первые две минуты красный, потом три минуты желтый и пять минут зеленый.
    */

    public static String getColorAfterTime(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cant be negative.");
        }
        int modMinutes = minutes % 10;
        String result = "";
        if (modMinutes <= 1) {
            result = "red";
        } else if (modMinutes <= 4) {
            result = "yellow";
        } else if (modMinutes <= 9) {
            result = "green";
        }
        return result;
    }
}
