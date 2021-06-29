package _7_abstract_class_va_interface.animal;

public class AnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;
    public Animal get(int index){
        return this.animals[index];
    }
    public void add(Animal animal){
        if(nextIndex<animals.length){
            animals[nextIndex] = animal;
            System.out.println("Animal added at "+nextIndex);
            nextIndex++;
        }
    }
}
