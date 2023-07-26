import java.util.Scanner;
public class Main {
    enum Menu {
        INPUT,
        STAT,
        CHANGE,
        EXIT
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        printMenu();
        int userInput = scanner.nextInt();
        Menu userCommand = Menu.values()[userInput - 1];
        while (userCommand != Menu.EXIT) {
            switch (userCommand) {
                case INPUT:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case STAT:
                    stepTracker.printStatistic();
                    break;
                case CHANGE:
                    stepTracker.changeStepGoal();
                    break;
                //case EXIT:
                    //System.out.println("Пока!");
                    //scanner.close();
                    //return;
                    //break;
                default:
                    System.out.println("Такой команды нет");
                    break;

            }

             printMenu();
             userInput = scanner.nextInt();
             userCommand = Menu.values()[userInput - 1]; }

    System.out.println("Пока!");
    scanner.close();}
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}