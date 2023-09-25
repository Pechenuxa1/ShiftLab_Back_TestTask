# ShiftLab_Back_TestTask
В приложении используется система сборки maven, springframework и база данных H2. 
Все зависимости уже прописаны в maven, поэтому необходимости загружать что-то еще нет.

После запуска ShiftLabBackTestTask3Application.java сервер начнет слушать запросы. 

Отправлять запросы(например, с помощью Postman) нужно по адресу
 http://localhost:8080/intervals/
                            POST merge?kind=letters или merge?kind=digits
                            GET  min?kind=letters или min?kind=digits

Запрос POST отправляет массив интервалов чисел или букв в формате json

База данных доступна по адресу http://localhost:8080/h2. Чтобы подсоединиться введите:
Driver Class: org.h2.Driver
JDBC URL:  jdbc:h2:mem:test
User Name: sa
Password: password
(также все данные для входа описаны в файле application.properties в директории resources)
