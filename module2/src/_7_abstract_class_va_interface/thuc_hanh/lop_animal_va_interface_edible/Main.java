package _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible;

import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.animal.Animal;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.animal.Chicken;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.animal.Tiger;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.edible.Edible;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.fruit.Apple;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.fruit.Fruit;
import _7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.fruit.Orangle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if(animal instanceof Chicken){
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howtoEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orangle();
        fruits[1] = new Apple();
        for(Fruit fruit : fruits){
            System.out.println(fruit.howtoEat());
        }
    }
}
