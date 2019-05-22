package ac.za.cput.servicetest.feedback;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.factory.feedbackfactory.FeedbackFactory;
import ac.za.cput.service.feedback.impl.FeedbackServiceImpl;
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
public class FeedbackServiceImplTest {

   @Autowired
   private FeedbackServiceImpl service;


    @Test
    public void getAll() {
        Feedback feedback = FeedbackFactory.getFeedback("This is some feedback", null);
        this.service.create(feedback);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);

    }

    @Test
    public void create() {
        Feedback feedback = FeedbackFactory.getFeedback("This is some feedback", null);
        this.service.create(feedback);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String newDesc = "Updated";
        Feedback feedback = FeedbackFactory.getFeedback("This is some feedback", null);
        Feedback feedback2 = FeedbackFactory.getFeedback("This is some feedback 2", null);
        this.service.create(feedback);
        this.service.create(feedback2);
        Feedback updateFeedback = FeedbackFactory.getFeedback(newDesc,null);
        this.service.update(updateFeedback);
        Assert.assertTrue(updateFeedback.getDesc().contains(newDesc));

    }

    @Test
    public void delete() {
        Feedback feedback = FeedbackFactory.getFeedback("This is some feedback", null);
        Feedback feedback2 = FeedbackFactory.getFeedback("This is some feedback 2", null);
        this.service.create(feedback);
        this.service.create(feedback2);
        this.service.delete(feedback2.getGuestID());
        Assert.assertTrue(this.service.getAll().size()>=1);


    }

    @Test
    public void read() {
        Feedback feedback = FeedbackFactory.getFeedback("This is some feedback", null);
        Feedback feedback2 = FeedbackFactory.getFeedback("This is some feedback 2", null);
        this.service.create(feedback);
        this.service.create(feedback2);
        Feedback readFeedback = FeedbackFactory.getFeedback(feedback.getGuestID(),null);
        Assert.assertNotEquals(readFeedback.getDesc(), feedback2.getDesc());
    }
}