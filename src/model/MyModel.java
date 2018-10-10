package model;

import beans.BeanOfSession;
import beans.BeanOfURL;

import java.util.ArrayList;

/*
Самая недороботанная часть

Можно запилить разную логику в зависимости от целей
В зависимости от нажатой кнопки создается или вытягивается из БД  новый бин фотографии и новый бин сессии
реализации данных методов тестовая.
 */
public class MyModel {

    public BeanOfURL getBeenOfUrlIfYes(BeanOfSession beenOfSession){
        BeanOfURL beenOfURL = new BeanOfURL();
        beenOfURL.setId(3);
        beenOfURL.setNumberOfImg(2);
        return beenOfURL;
    }

    public BeanOfURL getBeenOfUrlIfNo(BeanOfSession beenOfSession){
        BeanOfURL beenOfURL = new BeanOfURL();
        beenOfURL.setId(4);
        beenOfURL.setNumberOfImg(2);
        return beenOfURL;
    }

    public BeanOfURL getFirstBeenOfUrlOnSession(){
        BeanOfURL beenOfURL = new BeanOfURL();
        beenOfURL.setId(2);
        beenOfURL.setNumberOfImg(1);
        return beenOfURL;
    }

    public BeanOfSession getBeenOfSession(BeanOfSession beenOfSession, BeanOfURL beenOfURL){
        BeanOfSession newBeenOfSession = new BeanOfSession();
        if (beenOfSession != null){
            ArrayList<Integer> history = beenOfSession.getHistory();
            history.add(beenOfURL.getId());
            int number = beenOfURL.getNumberOfImg();
            newBeenOfSession.setHistory(history);
            newBeenOfSession.setNumber(number);
        }
        else{
            ArrayList<Integer> history = new ArrayList<>();
            history.add(beenOfURL.getId());
            int number = beenOfURL.getNumberOfImg();
            newBeenOfSession.setHistory(history);
            newBeenOfSession.setNumber(number);
        }
        return newBeenOfSession;
    }
}
