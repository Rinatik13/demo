#### REST API серверное приложение для записи в бассейн.
swimming_pool26072022.sql - файл для формирования необходимых таблиц.
логин: root
пароль: Sozdatel1313

#### для заполнения БД датами GET (api/v0/pool/timetabl/)

### API для работы с клиентами

#### 1. GET getClients (/api/v0/pool/client/all)

##### Описание 
Получение списка клиентов бассейна

##### Структура ответа
```
{[
    "id": number,
    "name": string
]}
```

#### 2. GET getClient (/api/v0/pool/client/get)

##### Описание
Получение данных о клиенте 

##### Входные данные
```
    id: number
```

##### Структура ответа
```
{
    "id": number,
    "name": string,
    "phone": string,
    "email": string
}
```

#### 3. POST addClient (/api/v0/pool/client/add)

##### Описание
Добавление нового клиента

##### Структура входных данных (body) 
```
{
    "name": string,
    "phone": string,
    "email": string
}    
```

#### 4. POST updateClient (/api/v0/pool/client/update)

##### Описание
Обновление данных о клиенте

##### Структура входных данных (body)
```
{
    "id": number
    "name": string,
    "phone": string,
    "email": string
}    
```

### API для работы с записями

#### 1. GET getAll (/api/v0/pool/timetable/all)

##### Описание
Получение занятых записей на определенную дату

##### Входные данные
```
    date: string
```

##### Структура ответа
```
{[
    "time": string,
    "count": number //Количество занятых записей в указанное время
]}
```

#### 2. GET getAvailable (/api/v0/pool/timetable/available)

##### Описание
Получение доступных записей на определенную дату

##### Входные данные
```
    date: string
```

##### Выходные данные
```
{[
    "time": string,
    "count": number //Количество доступных записей в указанный время 
]}
```

#### 3. POST reserve (/api/v0/pool/timetable/reserve)

##### Описание
Добавить запись клиента на определенное время

##### Структура входных данных (body)
```
{
    "clientId": number,
    "datetime": string
}
```

##### Выходные данные
```
{
    "orderId": string //Идентификатор засиси
}
```

#### 4. GET cancel (/api/v0/pool/timetable/cancel)

##### Описание
Отмена записи клиента на определенное время

##### Структура входных данных (body)
```
{
    "clientId": number
    "orderId": string //Идентификатор записи
}
