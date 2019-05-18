package repositorytest.receipttest;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.factory.receiptfactory.ReceiptFactory;
import ac.za.cput.repositories.receiptrepository.ReceiptRepository;
import ac.za.cput.repositories.receiptrepository.impl.ReceiptRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class ReceiptRepositoryImplTest {

    private ReceiptRepository repository;
    Date dte;

    @Before
    public void setUp() throws Exception {
        repository = ReceiptRepositoryImpl.getRepository();
        dte = new Date();
    }


    @Test
    public void getAll() {
        Set<Receipt> getAllReceipts = this.repository.getAll();
        System.out.println("GetAll Receipts: \n"+repository.getAll().size());

    }

    @Test
    public void create() {
        Receipt receipt = ReceiptFactory.getReceipt(dte, "this is the Receipt", 200);
        this.repository.create(receipt);
        int size = this.repository.getAll().size();
        System.out.println(size);
        assertTrue("This repository is not 0: ", this.repository.getAll().size()>0);
    }

    @Test
    public void update() {
        double updateTotal = 400;

        Receipt receipt = ReceiptFactory.getReceipt(dte, "Number 1", 200);
        Receipt receipt1 = ReceiptFactory.getReceipt(dte, "Number 1", 1000);

        this.repository.create(receipt);
        this.repository.create(receipt1);

        System.out.println("Objects in repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        receipt.setTotal(updateTotal);
        this.repository.update(receipt);
        System.out.println("Updated Repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        System.out.println("Updated to: " + receipt.getTotal());


    }

    @Test
    public void delete() {
        System.out.println("Start");
        System.out.println(this.repository.getAll().size());
        System.out.println("------------------------------------");
        Receipt receipt = ReceiptFactory.getReceipt(dte, "Number 1", 200);
        Receipt receipt1 = ReceiptFactory.getReceipt(dte, "Number 1", 1000);

        this.repository.create(receipt);
        this.repository.create(receipt1);

        this.repository.delete(receipt1.getRecID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll().size());


    }

    @Test
    public void read() {

        Receipt receipt = ReceiptFactory.getReceipt(dte, "Number 1", 200);
        Receipt receipt1 = ReceiptFactory.getReceipt(dte, "Number 1", 1000);

        this.repository.create(receipt);
        this.repository.create(receipt1);

        Receipt readReceipt = this.repository.read(receipt.getRecID());
        System.out.println(readReceipt.getRecID());
        System.out.println("--------Objects In Repository:------------");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotEquals(readReceipt.getRecID(), receipt1.getRecID());
    }



}