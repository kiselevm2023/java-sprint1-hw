public class Converter {

    int convertToKm(int steps){
        return (int) (steps * 0.75 / 1000);
    }
    int convertStepsToKilocalories(int steps){
        return steps * 50 / 1000;
    }

}