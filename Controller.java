import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

       
        view.addSortListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = view.getInput();
                    int[] array = Arrays.stream(input.split(","))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                    String selectedSorting = view.getSelectedSorting();
                    int[] sortedArray = null;

                    if (selectedSorting.equals("Bubble Sort")) {
                        sortedArray = model.bubbleSort(array);
                    } else if (selectedSorting.equals("Selection Sort")) {
                        sortedArray = model.selectionSort(array);
                    } else if (selectedSorting.equals("Insertion Sort")) {
                        sortedArray = model.insertionSort(array);
                    }

                    String result = Arrays.toString(sortedArray);
                    view.setResult("Array Terurut: " + result);
                    view.addHistory("Input: " + Arrays.toString(array) + " -> " + result + " (" + selectedSorting + ")");
                } catch (Exception ex) {
                    view.setResult("Input tidak valid. Pastikan Anda memasukkan angka dengan format benar!");
                }
            }
        });

        
        view.addClearHistoryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearHistory();
            }
        });
    }
}
