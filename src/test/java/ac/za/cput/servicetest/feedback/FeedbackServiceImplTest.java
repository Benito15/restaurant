//package ac.za.cput.servicetest.feedback;
//
//import ac.za.cput.domains.feedback.Feedback;
//import ac.za.cput.domains.guest.Guest;
//import ac.za.cput.factory.feedbackfactory.FeedbackFactory;
//import ac.za.cput.factory.guestfactory.GuestFactory;
//import ac.za.cput.service.feedback.FeedbackService;
//import ac.za.cput.service.feedback.impl.FeedbackServiceImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FeedbackServiceImplTest {
//
//   @Autowired
//   private FeedbackService service;
//    private Feedback feedback;
//    private Guest guest;
//
//    @Before
//    public void setUp() throws Exception {
//        this.service = FeedbackServiceImpl.getService();
//        guest = GuestFactory.getGuest("HELLO", "BYE", 20);
//        feedback = FeedbackFactory.getFeedback("This restaurant is AWESOME", null,guest.getGuestId());
//    }
//
//    @Test
//    public void getAll() {
//
//        Set<Feedback>feedbackSet = this.service.getAll();
//        Assert.assertNotNull(feedbackSet);
//    }
//
//    @Test
//    public void create() {
//
//        Feedback createFeedback= service.create(feedback);
//        //  System.out.println(feedback);
//        System.out.println(service.getAll().size());
//        Assert.assertNotNull(createFeedback);
//    }
//
//    @Test
//    public void update() {
//        Feedback createFeedback= service.create(feedback);
//        Feedback readFeedback = service.read(createFeedback.getGuestID());
//        Feedback updateFeedback = new Feedback.Builder().copy(readFeedback).desc("This is NOT nice").build();
//        this.service.update(updateFeedback);
//        Assert.assertNotNull(updateFeedback);
//    }
//
//    @Test
//    public void delete() {
//        Feedback createFeedback= service.create(feedback);
//        this.service.delete(createFeedback.getFeedbackID());
//        Feedback deleteFeedback = this.service.read(createFeedback.getFeedbackID());
//        Assert.assertNull(deleteFeedback);
//    }
//
//    @Test
//    public void read() {
//        Feedback createFeedback= service.create(feedback);
//        Feedback readFeedback = service.read(createFeedback);
//        Assert.assertNotNull(readFeedback.getGuestID());
//    }
//}