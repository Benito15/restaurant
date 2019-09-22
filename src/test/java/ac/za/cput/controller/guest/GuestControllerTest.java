package ac.za.cput.controller.guest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.factory.guestfactory.GuestFactory;
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
public class GuestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String url= "http://localhost:8080/guest";
    private Guest guest;




    @Before
    public void setUp(){
        guest = GuestFactory.getGuest("Benito", "Kriel", 34);

    }

    @Test
    public void create(){
        ResponseEntity<Guest> postResponse = restTemplate.postForEntity(url + "/new", guest, Guest.class);
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void findByID(){
        Guest readGuest = restTemplate.getForObject(url +"/find"+ guest.getGuestId() , Guest.class);
        Assert.assertNotNull(readGuest);
        System.out.println(readGuest.getGuestId());
    }

    @Test
    public void update(){
        Guest getGuest= restTemplate.getForObject(url+"/find" , Guest.class);
        getGuest.setGuestSurname("Zorro");
        restTemplate.put(url + "/update" , getGuest);
        Guest updatedGuest = restTemplate.getForObject(url +"/update/", Guest.class);
        Assert.assertNotNull(updatedGuest);

    }

    @Test
    public void delete(){
        guest = restTemplate.getForObject(url + "/find/", Guest.class);
        Assert.assertNotNull(guest);
        restTemplate.delete(url + "/delete/" + guest.getGuestId());
        try{
            guest = restTemplate.getForObject(url + "find" + guest.getGuestId(), Guest.class);

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