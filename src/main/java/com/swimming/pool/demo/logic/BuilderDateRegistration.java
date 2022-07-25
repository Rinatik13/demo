package com.swimming.pool.demo.logic;

// Добавляем возможность записи на 30 дней
// проверяет есть ли созданные позиции в DateReg таблице.
// Если в таблице указана информация меньше 30 дней, то добавляем недостающие дни по порядку.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BuilderDateRegistration {
    public void createDateRegistration(){
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String dayOfWeekText = null;
        switch (dayOfWeek){
            case 1:
                dayOfWeekText = "Voskresenie";
                break;
            case 2:
                dayOfWeekText = "Ponedelnik";
                break;
            case 3:
                dayOfWeekText = "Vtornik";
                break;
            case 4:
                dayOfWeekText = "Sreda";
                break;
            case 5:
                dayOfWeekText = "Chetverg";
                break;
            case 6:
                dayOfWeekText = "Patnica";
                break;
            case 7:
                dayOfWeekText = "Subbota";
                break;
        }
        System.out.println(dayOfWeekText);
        System.out.println(day);
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm ");
        System.out.println(sf.format(calendar.getTime()) + "minute");
    }
}
