package hw2_21000709_hoangtuantu.exercise01;

public class SortSolution {
    Sort solution;
    int[] numbers;
    boolean ascending = true;
    boolean stepByStep = false;

    public SortSolution() {
    }

    public SortSolution(Sort solution, int[] numbers, boolean ascending, boolean stepByStep) {
        this.solution = solution;
        this.numbers = numbers;
        this.ascending = ascending;
        this.stepByStep = stepByStep;
    }

    public void setNewSort(Sort solution, int[] numbers){
        this.solution = solution;
        this.numbers = numbers;
    }

    public void sort(){
        solution.sort(numbers, ascending, stepByStep);
    }

    public void sort(boolean ascending){
        solution.sort(numbers, ascending, false);
    }

    public void sort(boolean ascending, boolean stepByStep){
        solution.sort(numbers, ascending, stepByStep);
    }

    public void setSolution(Sort solution) {
        this.solution = solution;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++){
            result.append(numbers[i]);
            if (i < numbers.length - 1){
                result.append(", ");
            }
        }
        return result.toString();
    }
}
