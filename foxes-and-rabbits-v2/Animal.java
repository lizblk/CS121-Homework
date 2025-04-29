import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    //Animal's age
    private int age; //not owned by animal
    
    //one shared random number generator
    private static final Random RAND = Randomizer.getRandom();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;       // Exercise 12.45
    }
    
    //age helpers (12.45, 12.47
    protected int getAge()
    {   return age;
    }
    protected void setAge(int a)
    { age = a;
    }
    
    protected void incrementAge()   //exercise 12.47
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }
    //species-specific limits given by subclasses
    protected abstract int getMaxAge();
    
    //breeding helpers (12.46, 12.48)
    /** @return true if this animal is old enough to breed */
    protected boolean canBreed()    // exercise 12.46
    {
        return age >= getBreedingAge();
    }
    
    /** @return the number of offspring this step (can be 0) */
    protected int breed()   // exercise 12.48
    {
        int births = 0;
        if (canBreed() && RAND.nextDouble() <= getBreedingProbability()) {
            births = RAND.nextInt(getMaxLitterSize()) +1;
        }
        return births;
    }
    
    //species specific breeding facts from subclasses
    protected abstract int getBreedingAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    public abstract void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
