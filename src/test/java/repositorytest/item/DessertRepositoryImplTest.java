package repositorytest.item;

import ac.za.cput.domains.item.Dessert;
import ac.za.cput.factory.itemfactory.DessertFactory;
import ac.za.cput.repositories.item.DessertRepository;
import ac.za.cput.repositories.item.impl.DessertRepositoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DessertRepositoryImplTest {

    private DessertRepository repository = null;

    @Before
    public void setUp() throws Exception {
        this.repository = DessertRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Dessert dessert = DessertFactory.getDessert("Jelly", 5,50);
        this.repository.create(dessert);
        Assert.assertNotNull(this.repository.getAll());
    }

    @Test
    public void update() {
        Dessert dessert = DessertFactory.getDessert("Jelly", 5,50);
        this.repository.create(dessert);
        Dessert updateDessert = DessertFactory.getDessert("Malva Pudding", 3 , 200);
        updateDessert.setItemID(dessert.getItemID());
        this.repository.update(updateDessert);
        Dessert updatedDessert = this.repository.read(updateDessert.getItemID());
        Assert.assertEquals(dessert, updatedDessert);




    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Dessert dessert = DessertFactory.getDessert("Jelly", 5,50);
        Dessert dessert1 = DessertFactory.getDessert("Malva Pudding", 10,500);
        this.repository.create(dessert);
        this.repository.create(dessert1);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(dessert.getItemID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);
    }

    @Test
    public void read() {
        Dessert dessert = DessertFactory.getDessert("Jelly", 5,50);
        this.repository.create(dessert);
        Dessert readDessert = this.repository.read(dessert.getItemID());
        Assert.assertEquals(readDessert, dessert);

    }
}