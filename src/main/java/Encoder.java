import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encoder {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите текст (для выхода введите 'q'): ");
            StringBuilder text = new StringBuilder();
            while (true) {
                String line = reader.readLine() + "\n";
                if (line.equals("q\n")) break;
                text.append(line);
            }
            System.out.println("Размер сдвига: ");
            int shift = Integer.parseInt(reader.readLine());
            System.out.println("Выберите номер действия:\n1 - зашифровать\n2 - расшифровать");
            String resultText = switch(reader.readLine()) {
                case "1" -> encrypt(text.toString(), shift);
                case "2" -> encrypt(text.toString(), -shift);
                default -> "Не удалось совершить требуемое действие";
            };
            System.out.println(resultText);

        } catch (IOException e) {
            System.out.println("Возникла ошибка! " + e);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неверное значеие сдвига!");
        }
    }

    private static String encrypt(String sourceText, int shift) {
        StringBuilder result = new StringBuilder();
        for(char c : sourceText.toCharArray()) {
            result.append((char) (c + shift));
        }
        return result.toString();
    }
}
