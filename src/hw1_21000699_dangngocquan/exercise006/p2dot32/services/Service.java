package hw1_21000699_dangngocquan.exercise006.p2dot32.services;


import hw1_21000699_dangngocquan.exercise006.p2dot32.models.Animal;
import hw1_21000699_dangngocquan.exercise006.p2dot32.models.Bear;
import hw1_21000699_dangngocquan.exercise006.p2dot32.models.Fish;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
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
            int gender = getRandomNumber(0, 2);
            double strength = 1;
            Bear bear = new Bear(location, gender, strength);
            animals[location] = bear;
            bears.add(bear);
        }

        for (int i = 0; i < numberFish; i++) {
            Integer location = getRandomValueOfList(locations);
            locations.remove(Integer.valueOf(location));
            int gender = getRandomNumber(0, 2);
            double strength = 1;
            Fish fish = new Fish(location, gender, strength);
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
        numberBearIncrease = Math.min(numberBearIncrease, indexes.size());
        for (int i = 0; i < numberBearIncrease; i++) {
            Integer index = getRandomValueOfList(indexes);
            if (index != null) {
                indexes.remove(Integer.valueOf(index));
                int gender = getRandomNumber(0, 2);
                double strength = 1;
                Bear bear = new Bear(index, gender, strength);
                bears.add(bear);
                animals[index] = bear;
            }
        }
    }

    public static void addNewFishes(
            Animal[] animals, List<Fish> fishes,
            List<Integer> indexes, int numberFishIncrease) {
        numberFishIncrease = Math.min(numberFishIncrease, indexes.size());
        for (int i = 0; i < numberFishIncrease; i++) {
            Integer index = getRandomValueOfList(indexes);
            if (index != null) {
                indexes.remove(Integer.valueOf(index));
                int gender = getRandomNumber(0, 2);
                double strength = 1;
                Fish fish = new Fish(index, gender, strength);
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
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].size() > 1) {
                List<Animal> tempBears0 = new LinkedList<>();
                List<Animal> tempBears1 = new LinkedList<>();
                List<Animal> tempFishes0 = new LinkedList<>();
                List<Animal> tempFishes1 = new LinkedList<>();
                for (Animal animal : locations[i]) {
                    if (animal instanceof Bear) {
                        if (animal.getGender() == 0) {
                            tempBears0.add(animal);
                        } else {
                            tempBears1.add(animal);
                        }
                    } else if (animal instanceof Fish) {
                        if (animal.getGender() == 0) {
                            tempFishes0.add(animal);
                        } else {
                            tempFishes1.add(animal);
                        }
                    }
                }

                // Calculate number bear increase, number fish increase, number fish died to use later
                if (tempBears0.size() > 0 && tempBears1.size() > 0) {
                    numberBearIncrease++;
                }
                if (tempFishes0.size() > 0 && tempFishes1.size() > 0) {
                    numberFishIncrease++;
                }

                // Solve
                Collections.sort(tempBears0);
                Collections.sort(tempBears1);
                Collections.sort(tempFishes0);
                Collections.sort(tempFishes1);
                if (tempBears0.size() > 1) {
                    List<Animal> weakBears = tempBears0.subList(0, tempBears0.size()-1);
                    locations[i].removeAll(weakBears);
                    bears.removeAll(weakBears);
                    tempBears0 = tempBears0.subList(tempBears0.size()-1, tempBears0.size());
                }
                if (tempBears1.size() > 1) {
                    List<Animal> weakBears = tempBears1.subList(0, tempBears1.size()-1);
                    locations[i].removeAll(weakBears);
                    bears.removeAll(weakBears);
                    tempBears1 = tempBears1.subList(tempBears1.size()-1, tempBears1.size());
                }
                if (tempBears0.size() + tempBears1.size() == 0) {
                    if (tempFishes0.size() > 1) {
                        List<Animal> weakFishes = tempFishes0.subList(0, tempFishes0.size()-1);
                        locations[i].removeAll(weakFishes);
                        fishes.removeAll(weakFishes);
                        tempFishes0 = tempFishes0.subList(tempFishes0.size()-1, tempFishes0.size());
                        tempFishes0.get(0).setStrength(
                                tempFishes0.get(0).getStrength() + weakFishes.size()
                        );
                    }
                    if (tempFishes1.size() > 1) {
                        List<Animal> weakFishes = tempFishes1.subList(0, tempFishes1.size()-1);
                        locations[i].removeAll(weakFishes);
                        fishes.removeAll(weakFishes);
                        tempFishes1 = tempFishes1.subList(tempFishes1.size()-1, tempFishes1.size());
                        tempFishes1.get(0).setStrength(
                                tempFishes1.get(0).getStrength() + weakFishes.size()
                        );
                    }
                    if (tempFishes0.size() + tempFishes1.size() > 1) {
                        locations[i].removeAll(tempFishes0);
                        locations[i].removeAll(tempFishes1);
                        locations[tempFishes0.get(0).getLocation()].add(tempFishes0.get(0));
                        locations[tempFishes1.get(0).getLocation()].add(tempFishes1.get(0));
                    }
                } else if (tempBears0.size() + tempBears1.size() == 1) {
                    Animal strongestBear = null;
                    if (tempBears0.size() > 0) {
                        strongestBear = tempBears0.get(0);
                    } else {
                        strongestBear = tempBears1.get(0);
                    }
                    strongestBear.setStrength(
                            strongestBear.getStrength() + tempFishes0.size() + tempFishes1.size()
                    );
                    locations[i].removeAll(tempFishes0);
                    locations[i].removeAll(tempFishes1);
                    fishes.removeAll(tempFishes0);
                    fishes.removeAll(tempFishes1);
                } else {
                    int numberFishes = tempFishes0.size() + tempFishes1.size();
                    tempBears0.get(0).setStrength(
                            tempBears0.get(0).getStrength() + numberFishes * 0.5
                    );
                    tempBears1.get(0).setStrength(
                            tempBears1.get(0).getStrength() + numberFishes * 0.5
                    );
                    locations[i].removeAll(tempFishes0);
                    locations[i].removeAll(tempFishes1);
                    fishes.removeAll(tempFishes0);
                    fishes.removeAll(tempFishes1);
                    locations[i].removeAll(tempBears0);
                    locations[i].removeAll(tempBears1);
                    locations[tempBears0.get(0).getLocation()].add(tempBears0.get(0));
                    locations[tempBears1.get(0).getLocation()].add(tempBears1.get(0));
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
