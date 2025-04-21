# Java File Manager

Файловый менеджер, написанный на Java, работающий через консоль. Поддерживает основные команды работы с файловой системой и использует многопоточность для операций копирования и перемещения.

## Возможности

- cp <source> <target> — копирование файла (асинхронно)
- mv <source> <target> — перемещение файла (асинхронно)
- rm <path> — удаление файла
- find <start_dir> <filename> — поиск файла по имени
- cd <path> — переход в директорию (.., ./, абсолютный или относительный путь)
- ls — просмотр содержимого текущей директории
- pwd — показать текущую директорию
- history — история выполненных команд

## Примеры команд

`bash
> cp ./test.txt ../backup/

> mv ./image.png D:/media/

> rm ./old_file.log

> find ./ docs.txt

> cd ../src

> ls

> pwd

> history

## Установка и запуск

`bash
> git@github.com:SasiKudasi/FileManager.git
> cd FileManager
>
> ./gradlew build
>
> java -jar build/libs/FileManager-1.0-SNAPSHOT.jar 
