package ac.za.cput.servicetest.bill;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
import ac.za.cput.service.bill.impl.BillServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceImplTest {
@Autowired
    private BillServiceImpl service;



    @Test
    public void getAll() throws Exception{
        Bill bill = BillFactory.getBill(null, "Bill 1" , 200);
        service.create(bill);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create()  throws Exception {
        Bill bill = BillFactory.getBill(null, "Bill 1" , 200);
        service.create(bill);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() throws Exception {
       String updateDescription = "Updated Description";
        Bill bill = BillFactory.getBill(null, "Bill 1" , 200);
        service.create(bill);
        Bill updateBill = BillFactory.getBill(null, updateDescription,200);
        this.service.update(updateBill);
        Assert.assertTrue(updateBill.getDesc().contains(updateDescription));


    }

    @Test
    public void delete() throws Exception {
        Bill bill = BillFactory.getBill(null, "Bill 1" , 200);
        Bill bill2 = BillFactory.getBill(null, "Bill 2" , 400);
        service.create(bill);
        service.create(bill2);
        this.service.delete(bill2.getBillID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read()  throws Exception{
        Bill bill = BillFactory.getBill(null, "Bill 1" , 200);
        Bill bill2 = BillFactory.getBill(null, "Bill 2" , 400);
        service.create(bill);
        service.create(bill2);
        Bill readBill = this.service.read(bill.getBillID());
        Assert.assertNotEquals(readBill.getDesc(),bill2.getDesc());


    }
}