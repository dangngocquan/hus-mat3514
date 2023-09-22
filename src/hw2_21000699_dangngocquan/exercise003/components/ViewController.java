package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.App;
import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.services.Service;
import hw2_21000699_dangngocquan.exercise003.services.sort.Sort;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Timer;

public class ViewController extends Panel {
    private Timer timer;

    private Panel inputSlowerScalePanel;
    private TextField inputSlowerScaleField;
    private Panel inputNumberCardsPanel;
    private TextField inputNumberCardsField;
    private Panel inputMaxRankCardPanel;
    private TextField inputMaxRankCardField;
    private boolean isChangedInput = false;

    private Button buttonShuffle;
    private Button buttonGenerateRandom;

    private boolean[] isRunningAlgorithm;
    private Button buttonPlayBubbleSort;
    private Button buttonPlaySelectionSort;
    private Button buttonPlayInsertionSort;
    private Button buttonPlayMergeSort;
    private Button buttonPlayQuickSort;

    public ViewController(int x, int y, int width, int height, Color backgroundColor, ImageIcon backgroundImage, String text) {
        super(x, y, width, height, backgroundColor, backgroundImage, text);
        isRunningAlgorithm = new boolean[5];
        addTextFields();
        addFocusListenerForInputFields();
        addDocumentListenerForInputFields();
        addButtons();
        addActionListenerForButtons();
    }

    public boolean isChangedInput() {
        return isChangedInput;
    }

    public void setChangedInput(boolean changedInput) {
        isChangedInput = changedInput;
    }

    public App getApp() {
        return (App) Service.getFrame(this);
    }

    public void addTextFields() {
        if (inputMaxRankCardPanel == null) {
            inputMaxRankCardPanel = new Panel(
                    20, 10,
                    150, 40,
                    getBackground(), null, "Max rank of card [0-12]:"
            );
            add(inputMaxRankCardPanel);
        }
        if (inputMaxRankCardField == null) {
            inputMaxRankCardField = new TextField(
                    inputMaxRankCardPanel.getX() + inputMaxRankCardPanel.getWidth() + 10,
                    inputMaxRankCardPanel.getY(),
                    50, 40,
                    "12", Color.WHITE,
                    1, 0, 0
            );
            add(inputMaxRankCardField);
        }

        if (inputNumberCardsPanel == null) {
            inputNumberCardsPanel = new Panel(
                    inputMaxRankCardPanel.getX(),
                    inputMaxRankCardPanel.getY() + inputMaxRankCardPanel.getHeight() + 10,
                    inputMaxRankCardPanel.getWidth(),
                    inputMaxRankCardPanel.getHeight(),
                    getBackground(), null, String.format("Number of cards [1-%d]:", (getMaxRankCard() + 1) * 4)
            );
            add(inputNumberCardsPanel);
        }
        if (inputNumberCardsField == null) {
            inputNumberCardsField = new TextField(
                    inputNumberCardsPanel.getX() + inputNumberCardsPanel.getWidth() + 10,
                    inputNumberCardsPanel.getY(),
                    inputMaxRankCardField.getWidth(), inputMaxRankCardField.getHeight(),
                    "52", Color.WHITE,
                    1, 0, 0
            );
            add(inputNumberCardsField);
        }

        if (inputSlowerScalePanel == null) {
            inputSlowerScalePanel = new Panel(
                    inputNumberCardsPanel.getX(),
                    inputNumberCardsPanel.getY() + inputNumberCardsPanel.getHeight() + 10,
                    inputNumberCardsPanel.getWidth(),
                    inputNumberCardsPanel.getHeight(),
                    getBackground(), null, String.format("Slower speech scale [1- ]:")
            );
            add(inputSlowerScalePanel);
        }
        if (inputSlowerScaleField == null) {
            inputSlowerScaleField = new TextField(
                    inputSlowerScalePanel.getX() + inputSlowerScalePanel.getWidth() + 10,
                    inputSlowerScalePanel.getY(),
                    inputNumberCardsField.getWidth(), inputNumberCardsField.getHeight(),
                    "5", Color.WHITE,
                    1, 0, 0
            );
            add(inputSlowerScaleField);
        }
    }

    public void addFocusListenerForInputFields() {
        inputMaxRankCardField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                int maxRank = getMaxRankCard();
                inputNumberCardsPanel.setText(String.format("Number of cards [1-%d]:", (maxRank + 1) * 4));
                getNumberCards();
            }
        });

        inputNumberCardsField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                getNumberCards();
            }
        });

        inputSlowerScaleField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                getSlowerScale();
            }
        });
    }

    public void addDocumentListenerForInputFields() {
        inputMaxRankCardField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setChangedInput(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setChangedInput(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        inputNumberCardsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setChangedInput(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setChangedInput(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        inputSlowerScaleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    public void addButtons() {
        if (buttonShuffle == null) {
            buttonShuffle = new Button(
                    300, 10, 150, 65, "Shuffle Cards"
            );
            add(buttonShuffle);
        }
        if (buttonGenerateRandom == null) {
            buttonGenerateRandom = new Button(
                    buttonShuffle.getX(),
                    buttonShuffle.getY() + buttonShuffle.getHeight() + 10,
                    buttonShuffle.getWidth(),
                    buttonShuffle.getHeight(),
                    "Generate random ..."
            );
            add(buttonGenerateRandom);
        }
        if (buttonPlayBubbleSort == null) {
            buttonPlayBubbleSort = new Button(
                    buttonShuffle.getX() + buttonShuffle.getWidth() + 100,
                    10, 150, 40, "Run Bubble Sort"
            );
            add(buttonPlayBubbleSort);
        }
        if (buttonPlaySelectionSort == null) {
            buttonPlaySelectionSort = new Button(
                    buttonPlayBubbleSort.getX(),
                    buttonPlayBubbleSort.getY() + buttonPlayBubbleSort.getHeight() + 10,
                    150, 40, "Run Selection Sort"
            );
            add(buttonPlaySelectionSort);
        }
        if (buttonPlayInsertionSort == null) {
            buttonPlayInsertionSort = new Button(
                    buttonPlaySelectionSort.getX(),
                    buttonPlaySelectionSort.getY() + buttonPlaySelectionSort.getHeight() + 10,
                    150, 40, "Run Insertion Sort"
            );
            add(buttonPlayInsertionSort);
        }
        if (buttonPlayMergeSort == null) {
            buttonPlayMergeSort = new Button(
                    buttonPlayBubbleSort.getX() + buttonPlayBubbleSort.getWidth() + 20,
                    35, 150, 40, "Run Merge Sort"
            );
            add(buttonPlayMergeSort);
        }
        if (buttonPlayQuickSort == null) {
            buttonPlayQuickSort = new Button(
                    buttonPlayMergeSort.getX(),
                    buttonPlayMergeSort.getY() + buttonPlayMergeSort.getHeight() + 10,
                    150, 40, "Run Quick Sort"
            );
            add(buttonPlayQuickSort);
        }
    }

    public void addActionListenerForButtons() {
        buttonShuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                if (isChangedInput()) {
                    setChangedInput(false);
                    viewCards.addViewCards(
                            getNumberCards(),
                            getMaxRankCard()
                    );
                }
                viewCards.shuffleCards();
            }
        });

        buttonGenerateRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                viewCards.addViewCards(
                        getNumberCards(),
                        getMaxRankCard()
                );
                viewCards.shuffleCards();
                setChangedInput(false);
            }
        });

        buttonPlayBubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                if (isChangedInput()) {
                    setChangedInput(false);
                    viewCards.addViewCards(
                            getNumberCards(),
                            getMaxRankCard()
                    );
                    viewCards.shuffleCards();
                }

                if (isRunningAlgorithm[0]) {
                    setEnableAllButton(true);
                    setEnableAllInput(true);
                    isRunningAlgorithm[0] = false;
                    buttonPlayBubbleSort.setText("Run Bubble Sort");
                    timer.cancel();
                    timer.purge();
                } else {
                    setEnableAllButton(false);
                    setEnableAllInput(false);
                    buttonPlayBubbleSort.setEnabled(true);
                    isRunningAlgorithm[0] = true;
                    buttonPlayBubbleSort.setText("Stop Bubble Sort");
                    timer = new Timer();
                    Sort.bubbleSortWithAnimation(timer, viewCards, Config.MILLISECONDS_PER_ACTION * getSlowerScale());
                }
            }
        });

        buttonPlaySelectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                if (isChangedInput()) {
                    setChangedInput(false);
                    viewCards.addViewCards(
                            getNumberCards(),
                            getMaxRankCard()
                    );
                    viewCards.shuffleCards();
                }

                if (isRunningAlgorithm[1]) {
                    setEnableAllButton(true);
                    setEnableAllInput(true);
                    isRunningAlgorithm[1] = false;
                    buttonPlaySelectionSort.setText("Run Selection Sort");
                    timer.cancel();
                    timer.purge();
                } else {
                    setEnableAllButton(false);
                    setEnableAllInput(false);
                    buttonPlaySelectionSort.setEnabled(true);
                    isRunningAlgorithm[1] = true;
                    buttonPlaySelectionSort.setText("Stop Selection Sort");
                    timer = new Timer();
                    Sort.selectionSortWithAnimation(timer, viewCards, Config.MILLISECONDS_PER_ACTION * getSlowerScale());
                }
            }
        });

        buttonPlayInsertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                if (isChangedInput()) {
                    setChangedInput(false);
                    viewCards.addViewCards(
                            getNumberCards(),
                            getMaxRankCard()
                    );
                    viewCards.shuffleCards();
                }

                if (isRunningAlgorithm[2]) {
                    setEnableAllButton(true);
                    setEnableAllInput(true);
                    isRunningAlgorithm[2] = false;
                    buttonPlayInsertionSort.setText("Run Insertion Sort");
                    timer.cancel();
                    timer.purge();
                } else {
                    setEnableAllButton(false);
                    setEnableAllInput(false);
                    buttonPlayInsertionSort.setEnabled(true);
                    isRunningAlgorithm[2] = true;
                    buttonPlayInsertionSort.setText("Stop Insertion Sort");
                    timer = new Timer();
                    Sort.insertionSortWithAnimation(timer, viewCards, Config.MILLISECONDS_PER_ACTION * getSlowerScale());
                }
            }
        });

        buttonPlayMergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                Sort.mergeSort(viewCards.getViewCards());
                ((ViewCards) getApp().getViewCards()).updateViewCards();
            }
        });

        buttonPlayQuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCards viewCards = (ViewCards) getApp().getViewCards();
                if (isChangedInput()) {
                    setChangedInput(false);
                    viewCards.addViewCards(
                            getNumberCards(),
                            getMaxRankCard()
                    );
                    viewCards.shuffleCards();
                }

                if (isRunningAlgorithm[4]) {
                    setEnableAllButton(true);
                    setEnableAllInput(true);
                    isRunningAlgorithm[4] = false;
                    buttonPlayQuickSort.setText("Run Quick Sort");
                    timer.cancel();
                    timer.purge();
                } else {
                    setEnableAllButton(false);
                    setEnableAllInput(false);
                    buttonPlayQuickSort.setEnabled(true);
                    isRunningAlgorithm[4] = true;
                    buttonPlayQuickSort.setText("Stop Quick Sort");
                    timer = new Timer();
                    Sort.quickSortWithAnimation(timer, viewCards, Config.MILLISECONDS_PER_ACTION * getSlowerScale());
                }
            }
        });

    }

    public void setEnableAllButton(boolean flag) {
        buttonShuffle.setEnabled(flag);
        buttonGenerateRandom.setEnabled(flag);
        buttonPlayBubbleSort.setEnabled(flag);
        buttonPlaySelectionSort.setEnabled(flag);
        buttonPlayInsertionSort.setEnabled(flag);
        buttonPlayMergeSort.setEnabled(flag);
        buttonPlayQuickSort.setEnabled(flag);
    }

    public void setEnableAllInput(boolean flag) {
        inputMaxRankCardField.setEnabled(flag);
        inputNumberCardsField.setEnabled(flag);
        inputSlowerScaleField.setEnabled(flag);
    }

    public int getMaxRankCard() {
        String regex = "[0-9]+";
        String data = inputMaxRankCardField.getText();
        if (data.matches(regex)) {
            Integer maxRank = Integer.parseInt(data);
            if (maxRank > 12) {
                maxRank = 12;
                inputMaxRankCardField.setText("12");
            }
            return maxRank;
        } else {
            inputMaxRankCardField.setText("12");
            return 12;
        }
    }

    public int getNumberCards() {
        String regex = "[0-9]+";
        String data = inputNumberCardsField.getText();
        Integer maxRank = getMaxRankCard();
        if (data.matches(regex)) {
            Integer numberCards = Integer.parseInt(data);
            if (numberCards > (maxRank + 1) * 4) {
                numberCards = (maxRank + 1) * 4;
                inputNumberCardsField.setText(numberCards + "");
            } else if (numberCards < 1) {
                numberCards = 1;
                inputNumberCardsField.setText(numberCards + "");
            }
            return numberCards;
        } else {
            inputNumberCardsField.setText((maxRank + 1) * 4 + "");
            return (maxRank + 1) * 4;
        }
    }

    public int getSlowerScale() {
        String regex = "[0-9]+";
        String data = inputSlowerScaleField.getText();
        if (data.matches(regex)) {
            Integer slowerScale = Integer.parseInt(data);
            if (slowerScale < 1) {
                slowerScale = 1;
                inputSlowerScaleField.setText("1");
            }
            return slowerScale;
        } else {
            inputSlowerScaleField.setText("1");
            return 1;
        }
    }

}
