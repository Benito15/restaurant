package ac.za.cput.controller.table;

import ac.za.cput.domains.table.Table;
import ac.za.cput.factory.tablefactory.TableFactory;
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
public class TableControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String url= "http://localhost:8080/table";

    private Table table;

    @Before
    public void setUp() throws Exception {
        table = TableFactory.getTable(4, true);
    }

    @Test
    public void create() {
        ResponseEntity<Table> postResponse = restTemplate.postForEntity(url + "/new", table, Table.class);
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void findID() {
        Table readTable = restTemplate.getForObject(url +"/find"+ table.getTableID() , Table.class);
        Assert.assertNotNull(readTable);
        System.out.println(readTable.getTableID());
    }

    @Test
    public void update() {
        Table table = restTemplate.getForObject(url+"/find" , Table.class);
        table.setCapacity(3);
        restTemplate.put(url + "/update" , table);
        Table updatedTable= restTemplate.getForObject(url +"/update/", Table.class);
        Assert.assertNotNull(updatedTable);
    }

    @Test
    public void delete() {
        table = restTemplate.getForObject(url + "/find/", Table.class);
        Assert.assertNotNull(table);
        restTemplate.delete(url + "/delete/" + table.getTableID());
        try{
            table = restTemplate.getForObject(url + "find" + table.getTableID(), Table.class);

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