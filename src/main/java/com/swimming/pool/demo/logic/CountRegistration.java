package com.swimming.pool.demo.logic;

import com.swimming.pool.demo.entity.TimeTable;

// проверяем количество записей в заданный промежуток
// по умолчанию 10 записей
// если количество записей равно 10 то выдаём false (то-есть сообщаем что список полон)
public class CountRegistration {
    public static boolean verification(TimeTable date){
        if (date.getCount()==10){
            return false;
        }
        else {
            return true;
        }
    }
}
