package ac.za.cput.servicetest.receipt;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.factory.receiptfactory.ReceiptFactory;
import ac.za.cput.service.receipt.impl.ReceiptServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptServiceImplTest {

    @Autowired
    private ReceiptServiceImpl service;


    @Test
    public void getAll() {
        Receipt receipt = ReceiptFactory.getReceipt(null, "RECEIPT",200);
        service.create(receipt);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);

    }

    @Test
    public void create() {
        Receipt receipt = ReceiptFactory.getReceipt(null, "RECEIPT",200);
        service.create(receipt);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String updatedDescription = "Updated";
        Receipt receipt = ReceiptFactory.getReceipt(null, "this is receipt",200);
        service.create(receipt);
        Receipt updateReceipt = ReceiptFactory.getReceipt(null,updatedDescription,receipt.getTotal());
        this.service.update(updateReceipt);
        Assert.assertTrue(updateReceipt.getDesc().contains(updatedDescription));
    }

    @Test
    public void delete() {
        Receipt receipt = ReceiptFactory.getReceipt(null, "this is receipt",200);
        Receipt receipt2 = ReceiptFactory.getReceipt(null, "Some receipt2",100);
        service.create(receipt);
        service.create(receipt2);
        this.service.delete(receipt2.getRecID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Receipt receipt = ReceiptFactory.getReceipt(null, "this is receipt",200);
        Receipt receipt2 = ReceiptFactory.getReceipt(null, "Some receipt2",100);
        service.create(receipt);
        service.create(receipt2);
        Receipt readReceipt = this.service.read(receipt.getRecID());
        Assert.assertNotEquals(readReceipt.getRecID(), receipt2.getRecID());

    }
}