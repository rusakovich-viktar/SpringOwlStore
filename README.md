![OWL-store-logo](src/main/resources/static/images/screenshots-readme/about.png)

<!-- Table of Contents -->

# :notebook_with_decorative_cover: Состав проекта

- [Оглавление](#star2-about-the-project)
- [About the Project](#star2-about-the-project)
    * [О проекте](#camera-about)
    * [Скриншоты](#camera-screenshots)
    * [Стек технологий](#space_invader-tech-stack)
    * [Фичи](#dart-features)
    * [Что нужно для локального запуска](#running-run-locally)
    * [Структура базы данных](#key-database-structure)
- [Contact](#handshake-contact)


<!-- About the Project -->

## :star2: About the Project
## :star2: О проекте OWLstore {#star2-about-the-project}

Java приложение OWLstore представляет собой простую версию онлайн-магазина с необходимым для работы функционалом. 
Приложение предусматривает взаимодействие пользователя с онлайн-каталогом (выборка, поиск, сортировка, добавление в корзину, оформление заказа), взаимодействие со вспомогательными пользовательскими интерфейсом (регистрация, авторизация, аутентификация, редактирование данных профиля), взаимодействие с интерфейсом администратора (выдача ролей, восстановление и изменение паролей, активация аккаунта, обратная связь). 

Приложение написано на Java 17, задействован функционал Spring фреймворка (Boot, MVC, Security). Веб часть написана с использованием Thymeleaf. 
Более подробно стек технологий представлен ниже.

### Скриншоты {#camera-screenshots}
<details>
  <summary><strong>Показать список</strong></summary>
  
    *Домашняя страница*
  ![Домашняя страница](src/main/resources/static/images/screenshots-readme/home.png)

    *Страница продукта*
  ![Продукт](src/main/resources/static/images/screenshots-readme/product.png)

    *Страница профиля*
  ![Профиль](src/main/resources/static/images/screenshots-readme/profile.png)

    *Страница входа*
  ![Вход](src/main/resources/static/images/screenshots-readme/signin.png)

    *Страница регистрации*
  ![Регистрация](src/main/resources/static/images/screenshots-readme/signup.png)

    *Страница администратора*

  ![Админ](src/main/resources/static/images/screenshots-readme/admin.png)
  
    *Страница "О нас"*
  ![О нас](src/main/resources/static/images/screenshots-readme/about.png)

</details>

 ### Стек технологий {#space_invader-tech-stack}
 
<details>
 <summary><strong>Показать список</strong></summary>

**Java 17 LTS**

**Фреймворки и библиотеки:**
Spring Boot 3.1.0,
Spring MVC;

**Работа с данными:**
Spring Data JPA,
Hibernate,
Flyway Core;

**Веб-технологии:**
Thymeleaf,
Thymeleaf Extras Spring Security 6,
Spring Boot Starter Mail;

**Валидация и безопасность:**
Spring Security,
Spring Validation;

**Инструменты разработки:**
Lombok,
MapStruct;

**Тестирование:**
JUnit 5;

**Дополнительные инструменты:**
Spring Boot DevTools;

**Логирование:**
Log4j2;

**Базы данных:**
PostgreSQL;

**Плагины сборки:**
Maven Compiler Plugin,
Maven PMD Plugin,
SpotBugs Maven Plugin,
Maven Checkstyle Plugin,
Flyway Maven Plugin;

**Визуал:**
HTML, CSS, Bootstrap;
</details>

Clone the project

```bash
  git clone https://github.com/rusakovich-viktar/SpringOwlStore.git
```

### :key: Database structure

![DB_structure](src/main/resources/static/images/screenshots-readme/dbStructure.jpg)

## :handshake: Contact

Viktar Rusakovich - Java developer 
[Linkedin](https://www.linkedin.com/in/rusakovich/)
[EMail] mrisviz.rus@gmail.com
[Telegram] @Vitek11
[Phone] +375447764651
