# План тестирования мобильного приложения «Мобильный хоспис»

## Приложение представляет функционал по работе с информационными новостями хосписа  и включает в себя два основных блока:

1. Новостную сводку хосписа.
2. Тематические цитаты.

## Основная задача — проведение функционального тестирования.

1.Ручное тестирование

2. UI -тестирование.

## Тестовая документация на проекте:

Чек - лист ( с отметками о пройденных и не пройденных тестах)
https://docs.google.com/spreadsheets/d/1JiIKLwOiluFuJa45azyW_L7aJfRcRUFmZP-8ztDWkwA/edit#gid=0

Тест- кейсы с отметками о покрытии (либо с описанием почему тест-кейс не может быть покрыт)
https://docs.google.com/spreadsheets/d/1LpwUWX4G-I7MhoTJYtU3P8CnAIypJubzG70zeijCQoM/edit#gid=0

Отчет о тестировании.
Результат сравнения времени проверки приложения по чек-листу в ручном режиме и авто тестами.

## Виды тестирования:

1. Запуск приложения
2. Авторизация
3. Навигация в основном разделе приложения
4. Навигация в разделе News
5. Навигация и заполнение формы filter News
6. Создание новостей
7. Удаление новостей
8. Навигация в разделе About
9. Навигация в разделе цитат
10. Сворачивание и разворачивание приложения
11. Выход из приложения
12. Отсутствие соединения с интернетом
13. Ориентация экрана (альбомная\ портретная)
14. Тестирование прерываний
15. Нехватка памяти

## Окружение для тестирования на ПК

Процессор: Intel64 Family 6 Model 156 Stepping 0 Genuine Intel ~1997 МГц

Оперативная память: 8, 00 ГБ (доступно: 1 ГБ)

Тип системы: 64-разрядная операционная система, процессор х64-based PC

Окружение для тестирования на мобильном устройстве

Устройство: Pixel 7 Pro API 29

Модель:  PPixel 7 Pro 

Версия Android: 11

RAM: 4 ГБ

Память телефона: доступно 5,4 ГБ, всего 6 ГБ

Разрешение: 1080 x 2340

## Перечень используемых инструментов

Android Studio - это мощным инструмент для ручного тестирования. Встроенный эмулятор Android
позволяет создавать и управлять виртуальными устройствами, что упрощает проведение функциональных
тестов на различных Android конфигурациях. Дает возможность взаимодействовать с приложением в
эмуляторе, проверять элементы пользовательского интерфейса и оценивать поведение приложения на
разных размерах и разрешениях экрана. Предоставляет важные функции отладки, позволяющие эффективно
выявлять и устранять проблемы во время тестирования.

Эмулятор Pixel 4a API 30 (соответствует наиболее распространенным и современным Android -
устройствам)

Espresso - это фреймворк для тестирования. Писать тесты на Espresso очень удобно, так как много
функционала он берёт на себя. Позволяет работать с элементами приложения нативно и методом белого
ящика. Нужные элементы можно сначала находить на экране с помощью matcher'ов, а затем выполнять с
ними различные действия или проверки.

Allure report - это инструмент для создания отчетов о результатах тестирования в автоматизированных
тестовых сценариях. Предоставляет красиво оформленные и интерактивные отчеты, которые позволяют
легко анализировать результаты тестирования и принимать информированные решения на основе полученных
данных.

## Функционал для автоматизации

Запуск приложения

Вход/выход в личный кабинет

Навигация перемещения по разделам/страницам приложения

	раздел Основного меню
	раздел Новости
	раздел Цитат
	раздел About 

Использование и заполнение форм (в разделах) приложения

Создание/удаление элементов в приложении

Использование разной ориентация экрана (альбомная/портретная)