# employee-profile
</br>
Реализация простого WEB приложения, которое позволяет добавлять информацию о работнике.
В приложении реализовано логирование всех методов репозитория.
</br>
![All Employees](https://user-images.githubusercontent.com/88871075/176116815-4131b04e-e8f7-4a4f-9573-d310b813d09a.jpg)
Для работы приложения необходимо:
- установить [MySQL](https://dev.mysql.com/downloads/mysql/);
- создать в MySQL пользователя, connection, базу данных;
- созать таблицу **employees** в MySQL:
```MySQL
USE mvc_hiber_aop_db;

CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int,
  PRIMARY KEY (id)
) ;

INSERT INTO mvc_hiber_aop_db.employees (name, surname, department, salary)
VALUES
	('Ivan', 'Ivanov', 'IT', 500),
	('Oleg', 'Petrov', 'Sales', 700),
	('Nina', 'Sidorova', 'HR', 850);
```
- Все необходимые конфигурации и зависимости присутсвует в файлах applicationContext.xml, web.xml, pom.xml.
