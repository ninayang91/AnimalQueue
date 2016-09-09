import java.util.LinkedList;

public class AnimalQueue {
	
	LinkedList<Dog> dogs=new LinkedList<>();
	LinkedList<Cat> cats=new LinkedList<>();
	
	private int order;
	
	public void enqueue(Animal x){
		x.setOrder(order);
		order++;
		if(x instanceof Dog){
			dogs.add((Dog)x);
		}else if(x instanceof Cat){
			cats.add((Cat)x);
		}
	}
	
	public Dog dequeueDog(){
		if(dogs.isEmpty()) return null;
		return dogs.removeFirst();
	}
	
	public Cat dequeueCat(){
		if(cats.isEmpty()) return null;
		return cats.removeFirst();
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty()){
			return dequeueCat();
		}
		if(cats.isEmpty()){
			return dequeueDog();
		}
		Dog dog=dogs.getFirst();
		Cat cat=cats.getFirst();
		if(dog.isOlderThan(cat)){
			return dequeueDog();
		}else{
			return dequeueCat();
		}
	}

}
