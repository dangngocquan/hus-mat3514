package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.App;
import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Animal;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Bear;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Fish;
import hw1_21000699_dangngocquan.exercise006.p1dot31.services.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

public class EcosystemTable extends BasicPanel {
    private int size;
    private Animal[] animals;
    private List<Bear> bears;
    private List<Fish> fishes;
    private EcosystemCell[][] ecosystemCells = null;
    private Timer timer = null;
    public EcosystemTable(
            int x, int y, int width, int height, int size,
            int initialNumberBear, int initialNumberFish) {
        super(x, y, width/size * size, height / size * size);
        this.size = size;

        createRandomAnimals(size, initialNumberBear, initialNumberFish);
        addEcosystemCells();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_TABLE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void createRandomAnimals(
            int ecosystemSize,
            int initialNumberBear,
            int initialNumberFish) {
        animals = new Animal[ecosystemSize * ecosystemSize];

        if (bears == null) {
            bears = new LinkedList<>();
        } else {
            bears.clear();
        }
        if (fishes == null) {
            fishes = new LinkedList<>();
        } else {
            fishes.clear();
        }
        Service.createRandomAnimals(
                initialNumberBear, initialNumberFish,
                animals, bears, fishes);
    }

    public void addEcosystemCells() {
        if (ecosystemCells == null) {
            ecosystemCells = new EcosystemCell[size][size];
        }
        int sizeCell = getWidth() / size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ecosystemCells[i][j] == null) {
                    ecosystemCells[i][j] = new EcosystemCell(
                            j * sizeCell,
                            i * sizeCell,
                            sizeCell,
                            sizeCell,
                            animals[i*size+j]
                    );
                    this.add(ecosystemCells[i][j]);
                } else {
                    ecosystemCells[i][j].setAnimal(animals[i*size+j]);
                    ecosystemCells[i][j].repaint();
                }

            }
        }
        repaint();
    }

    public void runEcosystem() {
        App app = (App) Service.getFrame(this);
        int millisecondPerStep = app.getMillisecondPerStep();
        this.timer = new Timer();
        timer.schedule(new Task(), 0, millisecondPerStep);
    }

    public void stopEcosystem() {
        timer.cancel();
        timer.purge();
    }

    public App getApp() {
        return (App) Service.getFrame(this);
    }

    private class Task extends TimerTask {
        public static int i = 0;
        @Override
        public void run() {
            Service.nextStepEcosystem(
                    size,
                    animals,
                    bears,
                    fishes
            );
            addEcosystemCells();
            getApp().rerenderControllerStatusPanels(
                    bears.size(),
                    fishes.size()
            );
        }
    }
}
