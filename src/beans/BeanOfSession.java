package beans;

import java.util.ArrayList;

/*
Данный класс характеризует состояние "Сессии"
Если number = 1, то показ еще не закончен
Если number = 2, то, все, показ закончен
history - содержит историю показанных фотографий
 */
public class BeanOfSession {
    private int number;
    private ArrayList<Integer> history;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public ArrayList<Integer> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Integer> history) {
        this.history = history;
    }
}
