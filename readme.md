# Программа для сложения целых чисел

Привет! Это тестовая заглушка (эмулятор) на Spring Boot, которая предоставляет API для сложения двух целых чисел.

## Запуск программы

Для работы программе необходимы установленные в системе (и прописанные в PATH) *Java Development Kit (JDK)* версии 8 или выше, а также *Apache Maven*

Чтобы запустить программу, неоходимо выполнить следующие шаги:

1. Склонируйте репозиторий на свой компьютер введя в командной строке команду
- через HTTPS-протокол:
   ```
   git clone https://github.com/ikhairulin/spr_boot_emul.git
   ```
- через SSH-протокол:
   ```
   git@github.com:ikhairulin/spr_boot_emul.git
   ```

2. Перейдите в каталог в который установили проект (как ориентир в папке должен быть файл pom.xml):
   ```
   cd <repository-name>
   ```
3. Скомпилируйте и запустите проект с помощью команды Maven:
   ```
   mvn spring-boot:run
   ```
   Либо если в системе не установлен Maven можно скачать скомпилированный jar-файл по ссылке:
   https://drive.google.com/file/d/1u5q3de3V55RnOmsqaWR-1slJ8tE8bC0E/view?usp=sharing
   и запустить программу командой
   ```
   java -jar <путь до файла>/MockTest-1.jar
   ```

4. После успешного запуска, программа будет доступна по адресу `http://localhost:8080`.

5. Прервать работу программы можно комбинацией клавиш CTRL+C (либо cmd + c на маке).

## Методы API 
Метод / (Адрес)

### GET /ok (http://localhost:8080/ok)

Возвращает приветственное сообщение "Hello World!".

### GET /test (http://localhost:8080/test)

Возвращает информацию о программе и пример данных для запроса методом POST.

### POST /test (http://localhost:8080/test)

Принимает данные в формате JSON для сложения двух чисел. Пример тела запроса:

```json
{
  "name": "John",
  "first_num": 5,
  "second_num": 2
}
```

Ответ содержит приветствие и сумму двух чисел:

```json
{
  "message": "message": "Здравствуйте, John! Сумма ваших чисел 60"
}
```

## Запуск и работа с программным комплексом Kafka с использованием контейнеров docker
1. Запускаем командой *docker-compose up* файл docker-compose.yml
2. Будут скачаны и запущены контейнеры с zookeeper, kafka и kowl (как элемент UI)
3. Командой docker exec -it <имя контейнера с kafka> bash переходим в командную строку внутри контейнера с kafka, в моем случае это
   ```bash
   docker exec -it spr_boot_emul-kafka-1 bash
   ```
4. Создаем топик командой 
   ```bash
   /opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic
   ```
5. Для проверки работы топика можем отправить в него сообщение командой
```bash
echo "Hello World" | kafka-console-producer.sh --broker-list localhost:9092 --topic my_topic
   ```