package hw6_21000709_hoangtuantu.excercise01;

public class People {
    private String id;
    private int age;
    private String name;

    public People(String id , int age , String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s(%s yo) - id: %s", name, age, id);
    }
}
