package ac.za.cput.controller.order;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String url= "http://localhost:8080/order";
    private Guest guest;
    private Employee waiter;
    private Order order;


    @Before
    public void setUp(){
        guest = GuestFactory.getGuest("Benito", "Kriel", 34);
        waiter = WaiterFactory.getWaiter("Veka", "lovemore", 4799);
        order = OrderFactory.getOrder(guest.getGuestId(), waiter.getEmpid(), null, 382);

    }

    @Test
    public void create(){
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url + "/new", order, Order.class);
        Assert.assertNotNull(postResponse);
       }

   @Test
    public void findByID(){
    Order readorder = restTemplate.getForObject(url +"/find"+ order.getOrderID() + order.getEmpID(), Order.class);
    Assert.assertNotNull(readorder);
       System.out.println(readorder.getOrderID());
   }

   @Test
   public void update(){
        Order order= restTemplate.getForObject(url+"/find" , Order.class);
        order.setTotal(250);
        restTemplate.put(url + "/update" , order);
        Order updatedOrder= restTemplate.getForObject(url +"/update/", Order.class);
        Assert.assertNotNull(updatedOrder);

   }

   @Test
    public void delete(){
        order = restTemplate.getForObject(url + "/find/", Order.class);
        Assert.assertNotNull(order);
        restTemplate.delete(url + "/delete/" + order.getOrderID());
        try{
            order = restTemplate.getForObject(url + "find" + order.getOrderID(), Order.class);

        }catch (final HttpClientErrorException e){
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + "/getAll", HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }

}
