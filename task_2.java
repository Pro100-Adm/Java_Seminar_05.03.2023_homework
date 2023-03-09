import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
public class task_2 {
public static void main(String[] args) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get("students_database.txt"))) {
        lines.forEach(line -> MyParse(line));
        lines.close();
}
}

public static void MyParse(String line) {
    StringBuilder outLine = new StringBuilder();
    outLine.append("Студент ").append(line.split(",")[0].split(":")[1]).append(" получил(-a) ")
    .append(line.split(",")[1].split(":")[1]).append(" по предмету ")
    .append(line.split(",")[2].split(":")[1]).append(".\n");
    System.out.print(outLine);
}
}