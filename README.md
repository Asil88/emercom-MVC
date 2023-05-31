# Тестовое задание

Необходимо разработать Web-приложение на Java с использованием базы данных MS SQL.  
Приложение должно иметь возможность регистрации и авторизации пользователей, использования сессий  
для сохранения идентификации пользователя на сайте, а также иметь функциональность для добавления,  
редактирования и удаления данных из базы данных. 

Основные требования:
- Форма регистрации должна содержать поля для ввода логина, пароля и email.
- Поля должны проходить валидацию на корректность введенных данных.
- Логин и email должны быть уникальными.
- После успешной регистрации система должна перенаправить пользователя на страницу авторизации.
- Форма авторизации должна содержать поля для ввода логина и пароля.
- Данные должны проходить валидацию на корректность введенных данных.
- Система должна проверять, что пользователя с таким логином и паролем существует в базе данных.
- После успешной авторизации система должна перенаправить пользователя на главную страницу, где должен быть информационный блок с приветствием и возможностью выйти из системы.
- Должна быть возможность добавлять, редактировать и удалять записи из базы данных.
- Записи в базе данных должны содержать информацию о пользователе, например, имя и фамилию.
- Система должна обеспечивать возможность фильтрации данных по различным критериям, таким как имя и фамилия.

Дополнительные требования:
- Любые изменения в системе должны быть записаны в log-файл.
- HTML-страницы должны быть выполнены в строгом соответствии с современными стандартами веб-разработки.
- Система должна использовать шаблон MVC для удобной разработки и поддержки в дальнейшем.(либо клиент-сервер)

# Использованы технологии:

* ЯП: Java 17
* Сборка и Управление зависимостями: Maven
* Фреймворк для разработки: Spring
* Веб-сервер: Apache Tomcat (Порт по-умолчанию:8080)
* Инициализация проекта: Spring Boot 3.0.4 

* Структура приложения: MVC

* Аутентификация и авторизация: Spring Security
* Алгоритм хеширования паролей: BCrypt

* Логирование: SLF4J
* Валидация: Java Bean Validation API

* База данных: MS SQL SERVER 2019 (Порт по-умолчанию:1433) 
* Работа с базой данных: Spring Data JPA

* Представление:  Thymeleaf + Bootstrap (http://localhost:8080/login)
  
