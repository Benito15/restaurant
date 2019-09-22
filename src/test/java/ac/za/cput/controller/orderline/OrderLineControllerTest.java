package ac.za.cput.controller.orderline;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
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
public class OrderLineControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String url= "http://localhost:8080/orderLine";

    private Employee waiter;
    private Guest guest;
    private Order order;
    private Item burgerItem;
    private OrderLine orderLine;



    @Before
    public void setUp() throws Exception {
        waiter = WaiterFactory.getWaiter("Lela", "Sji", 0);
        guest = GuestFactory.getGuest("Lorenzo", "Kola", 24);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        burgerItem = BurgerFactory.getBurger("This is a burger", 2, 70.00);
        orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), burgerItem.getItemID(), burgerItem.getDesc(), burgerItem.getQty());

    }

    @Test
    public void create() {
        ResponseEntity<OrderLine> postResponse = restTemplate.postForEntity(url + "/new", orderLine, OrderLine.class);
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void findID() {
        OrderLine readorderline = restTemplate.getForObject(url +"/find"+ orderLine.getOrderID() + orderLine.getItemID(), OrderLine.class);
        Assert.assertNotNull(readorderline);
        System.out.println(readorderline.getOrderID());
    }

    @Test
    public void update() {
        OrderLine readorderLine= restTemplate.getForObject(url+"/find" , OrderLine.class);
        readorderLine.setQty(6);
        restTemplate.put(url + "/update" , readorderLine);
        OrderLine updatedOrderLine = restTemplate.getForObject(url +"/update/", OrderLine.class);
        Assert.assertNotNull(updatedOrderLine );
    }

    @Test
    public void delete() {
        orderLine = restTemplate.getForObject(url + "/find/", OrderLine.class);
        Assert.assertNotNull(orderLine);
        restTemplate.delete(url + "/delete/" + orderLine.getOrderID()+orderLine.getItemID());
        try{
            orderLine = restTemplate.getForObject(url + "find" + orderLine.getOrderID()+ orderLine.getItemID(), OrderLine.class);

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