package _7_abstract_class_va_interface.animal;

public class DogTestDrive {
    public static void main(String[] args) {
        AnimalList animalList = new AnimalList();
        Dog dog = new Dog();
        Animal animal = new Animal();
        dog = (Dog) animal;
        animal = dog;
        System.out.println(animal.getClass());
    }
}
