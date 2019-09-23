package ac.za.cput.securitytest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.factory.guestfactory.GuestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantSecurityTest {

//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String url = "http://localhost:8080/guest";
//
//    @Before
//    public void addBeforeData(){
//        Guest guest = GuestFactory.getGuest("Bennie", "Kriel", 25);
//        ResponseEntity<Guest> postResponse = restTemplate.postForEntity(url + "/new", guest, Guest.class);
//
//    }

//    @Test
//    public void correctCredentials200Ok() throws Exception{
//        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","admin").getForEntity(url + "/getall", String.class);
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getBody());
//        System.out.println("fdnkfn");
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void innCorrectCredentials401() throws Exception{
//        ResponseEntity<String> response = restTemplate.withBasicAuth("administrator","admins").getForEntity(url + "/getall",String.class);
//
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getBody());
//
//        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//
//    }

}
