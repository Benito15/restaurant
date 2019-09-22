package ac.za.cput.controller.burger;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BurgerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String url ="http://localhost:8080/";
    private Item burgerItem;




    @Before
    public void setUp() throws Exception {

        burgerItem = BurgerFactory.getBurger("Cheese Burger",2, 30);

    }

    @Test
    public void create() {
        ResponseEntity<Burger> postResponse = restTemplate.postForEntity(url + "/new", burgerItem, Burger.class);
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void findID() {
        Burger readBurger= restTemplate.getForObject(url +"/find"+ burgerItem.getItemID() , Burger.class);
        Assert.assertNotNull(readBurger);
        System.out.println(readBurger.getType());
    }

    @Test
    public void update() {
        Burger burger= restTemplate.getForObject(url+"/find" , Burger.class);
        burger.setDesc("Plain burger");
        restTemplate.put(url + "/update" , burger);
        Burger updatedBurger= restTemplate.getForObject(url +"/update/", Burger.class);
        Assert.assertNotNull(updatedBurger);

    }

    @Test
    public void delete() {
        burgerItem = restTemplate.getForObject(url + "/find/", Burger.class);
        Assert.assertNotNull(burgerItem);
        restTemplate.delete(url + "/delete/" + burgerItem.getItemID());
        try{
            burgerItem = restTemplate.getForObject(url + "find" + burgerItem.getItemID(), Burger.class);

        }catch (final HttpClientErrorException e){
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + "/getAll", HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }
}