package hw1_21000699_dangngocquan.exercise006.p1dot31.services;


import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Animal;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Bear;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Fish;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Service {
    public static JFrame getFrame(Component theComponent) {
        Component currParent = theComponent;
        JFrame theFrame = null;
        while (currParent != null) {
            if (currParent instanceof JFrame) {
                theFrame = (JFrame) currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return theFrame;
    }

    public static int getRandomNumber(int from, int to) {
        int range = to - from;
        int randomNum = (int) (Math.floor(Math.random() * range)) + from;
        return randomNum;
    }

    public static Integer getRandomValueOfList(List<Integer> values) {
        if (values.size() == 0) return null;
        int randomIndex = getRandomNumber(0, values.size());
        int value = values.get(randomIndex);
        return value;
    }

    public static void createRandomAnimals(
            int numberBear, int numberFish,
            Animal[] animals, List<Bear> bears, List<Fish> fishes) {
        List<Integer> locations = new LinkedList<>();
        for (int i = 0; i < animals.length; i++) locations.add(i);

        for (int i = 0; i < numberBear; i++) {
            Integer location = getRandomValueOfList(locations);
            locations.remove(Integer.valueOf(location));
            Bear bear = new Bear(location);
            animals[location] = bear;
            bears.add(bear);
        }

        for (int i = 0; i < numberFish; i++) {
            Integer location = getRandomValueOfList(locations);
            locations.remove(Integer.valueOf(location));
            Fish fish = new Fish(location);
            animals[location] = fish;
            fishes.add(fish);
        }
    }

    public static Integer getNextRandomLocation(Integer currentLocation, int ecosystemSize) {
        List<Integer> locations = new LinkedList<>();
        int row = currentLocation / ecosystemSize;
        int column = currentLocation % ecosystemSize;
        if (row-1 >= 0 && column-1 >= 0) locations.add(currentLocation-ecosystemSize-1);
        if (row-1 >= 0) locations.add(currentLocation-ecosystemSize);
        if (row-1 >= 0 && column+1 < ecosystemSize) locations.add(currentLocation-ecosystemSize+1);
        if (column-1 >= 0) locations.add(currentLocation-1);
        if (column+1 < ecosystemSize) locations.add(currentLocation + 1);
        if (row+1 < ecosystemSize && column-1 >= 0) locations.add(currentLocation+ecosystemSize-1);
        if (row+1 < ecosystemSize) locations.add(currentLocation+ecosystemSize);
        if (row+1 < ecosystemSize && column+1 < ecosystemSize) locations.add(currentLocation+ecosystemSize+1);
        int nextLocation = getRandomValueOfList(locations);
        return nextLocation;
    }

    public static void addNewBears(
            Animal[] animals, List<Bear> bears,
            List<Integer> indexes, int numberBearIncrease) {
        for (int i = 0; i < numberBearIncrease; i++) {
            Integer index = getRandomValueOfList(indexes);
            if (index != null) {
                indexes.remove(Integer.valueOf(index));
                Bear bear = new Bear(index);
                bears.add(bear);
                animals[index] = bear;
            }
        }
    }

    public static void addNewFishes(
            Animal[] animals, List<Fish> fishes,
            List<Integer> indexes, int numberFishIncrease) {
        for (int i = 0; i < numberFishIncrease; i++) {
            Integer index = getRandomValueOfList(indexes);
            if (index != null) {
                indexes.remove(Integer.valueOf(index));
                Fish fish = new Fish(index);
                fishes.add(fish);
                animals[index] = fish;
            }
        }
    }

    public static void nextStepEcosystem(
            int ecosystemSize,
            Animal[] animals,
            List<Bear> bears,
            List<Fish> fishes) {
        // location of animals in next step
        // index: is location
        // locations[index]: is a list of animal in this location
        List<Animal>[] locations = new List[animals.length];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = new LinkedList<>();
        }
        for (Bear bear : bears) {
            int nextLocation = getNextRandomLocation(bear.getLocation(), ecosystemSize);
            locations[nextLocation].add(bear);
        }
        for (Fish fish : fishes) {
            int nextLocation = getNextRandomLocation(fish.getLocation(), ecosystemSize);
            locations[nextLocation].add(fish);
        }

        // Solve when has disputed area (a location has more animals)
        int numberBearIncrease = 0;
        int numberFishIncrease = 0;
        int numberBearDied = 0;
        int numberFishDied = 0;
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].size() > 1) {
                List<Animal> tempBears = new LinkedList<>();
                List<Animal> tempFishes = new LinkedList<>();
                for (Animal animal : locations[i]) {
                    if (animal instanceof Bear) {
                        tempBears.add(animal);
                    } else if (animal instanceof Fish) {
                        tempFishes.add(animal);
                    }
                }

                // Calculate number bear increase, number fish increase, number fish died to use later
                if (tempBears.size() > 0) {
                    numberBearIncrease += (tempBears.size() * (tempBears.size()-1))/2;
                    if (tempFishes.size() > 0) {
                        numberFishIncrease += (tempFishes.size() * (tempFishes.size()-1))/2;
                        numberFishDied += tempFishes.size();
                    }
                } else {
                    if (tempFishes.size() > 0) {
                        numberFishIncrease += (tempFishes.size() * (tempFishes.size()-1))/2;
                    }
                }


                // Solve
                if (tempBears.size() > 0) {
                    if (tempBears.size() > 1) {
                        locations[i].removeAll(tempBears);
                        for (Animal bear : tempBears) {
                            locations[bear.getLocation()].add(bear);
                        }
                    }
                    if (tempFishes.size() > 0) {
                        fishes.removeAll(tempFishes);
                        locations[i].removeAll(tempFishes);
                    }
                } else {
                    if (tempFishes.size() > 0) {
                        locations[i].removeAll(tempFishes);
                        for (Animal fish : tempFishes) {
                            locations[fish.getLocation()].add(fish);
                        }
                    }
                }

            }
        }

        boolean hasDisputedLocation = true;
        while (hasDisputedLocation) {
            hasDisputedLocation = false;
            for (int i = 0; i < locations.length; i++) {
                if (locations[i].size() > 1) {
                    hasDisputedLocation = true;
                    for (Animal animal : locations[i]) {
                        locations[i].remove(animal);
                        locations[animal.getLocation()].add(animal);
                    }
                }
            }
        }


        // Correct location for each object animal
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].size() == 1) {
                locations[i].get(0).setLocation(i);
            }
        }

        // Create new animals and update array 'animals'
        List<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < animals.length; i++) {
            indexes.add(i);
            animals[i] = null;
        }
        for (Bear bear : bears) {
            animals[bear.getLocation()] = bear;
            indexes.remove(Integer.valueOf(bear.getLocation()));
        }
        for (Fish fish : fishes) {
            animals[fish.getLocation()] = fish;
            indexes.remove(Integer.valueOf(fish.getLocation()));
        }

        addNewBears(animals, bears, indexes, numberBearIncrease);
        addNewFishes(animals, fishes, indexes, numberFishIncrease);

    }

}
