import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData monthToData[] = new MonthData[12];
    Converter conv = new Converter();
    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12){
            System.out.println("Вы ввели некорректный месяц");
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNum = scanner.nextInt();
        if(dayNum < 1 || dayNum > 30){
            System.out.println("Вы ввели некорректный день");
        }

        System.out.println("Введите количество шагов");
        int stepNum = scanner.nextInt();
        if(stepNum < 0){
            System.out.println("Вы ввели некорректное количество шагов: отрицательное число");
        }

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNum - 1];
        // Сохранение полученных данных
        monthData.days[dayNum - 1] = stepNum;
    }
    void changeStepGoal(){
        System.out.println("Введите цель шагов");
        int stepGoal = scanner.nextInt();
        if(stepGoal <= 0 ){
            System.out.println("Вы ввели некорректную цель: ноль или отрицательное число");
        }
        else {
            goalByStepsPerDay = stepGoal;
            System.out.println("Ваша цель: " + goalByStepsPerDay);
        }
    }
    void  printStatistic(){
        System.out.println("Введите число месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum >= 12){
            System.out.println("Вы ввели неккоректный месяц");
        }
        monthToData[monthNum - 1].printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц " + monthToData[monthNum - 1].sumStepsFromMonth());
        System.out.println("Максимальное колчиество шагов за месяц: " + monthToData[monthNum - 1].maxSteps());
        System.out.println("Среднее количесвто шагов за месяц: " + monthToData[monthNum - 1].sumStepsFromMonth()/30);
        System.out.println("Пройденное расстояние в км: " + conv.convertToKm(monthToData[monthNum - 1].sumStepsFromMonth()));
        System.out.println("Количество сожженых калорий: " + conv.convertStepsToKilocalories(monthToData[monthNum - 1].sumStepsFromMonth()));
        System.out.println("Вывод лучшей серии: " + monthToData[monthNum - 1].bestSeries(goalByStepsPerDay) + " дней");

    }
}