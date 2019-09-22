package ac.za.cput.repositorytest.feedbacktest;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.factory.feedbackfactory.FeedbackFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.repositories.feedback.FeedbackRepository;
import ac.za.cput.repositories.feedback.impl.FeedbackRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackRepositoryImplTest {

    @Autowired
    private FeedbackRepository feedbackRepository;
    Feedback feedback;
    Date nowDate;
    LocalDate instantDate;
    Guest guest;

    @Before
    public void setUp() throws Exception {

        this.feedbackRepository = FeedbackRepositoryImpl.getRepository();
        nowDate = new Date();
        guest = GuestFactory.getGuest("zola", "Kriel", 20);
        instantDate = LocalDate.of(2019,06,1);
        feedback = FeedbackFactory.getFeedback("This is awesome", null,guest.getGuestId());
    }

    @Test
    public void getAll() {
        Set<Feedback> getAllFeedback = this.feedbackRepository.getAll();
        System.out.println("Get All FeedBack: " + getAllFeedback.size());
        Assert.assertNotNull(getAllFeedback);
    }

    @Test
    public void create() {
       Feedback createFeedback= feedbackRepository.create(feedback);
      //  System.out.println(feedback);
        System.out.println(feedbackRepository.getAll().size());
        Assert.assertNotNull(createFeedback);

    }

@Test
public void update() {

    Feedback createFeedback= feedbackRepository.create(feedback);
    Feedback readFeedback = feedbackRepository.read(createFeedback);
    Feedback updateFeedback = new Feedback.Builder().copy(readFeedback).desc("This is NOT nice").build();
    this.feedbackRepository.update(updateFeedback);
    Assert.assertNotNull(updateFeedback);



}

    @Test
    public void delete() {
        Feedback createFeedback= feedbackRepository.create(feedback);
        this.feedbackRepository.delete(createFeedback);
        Feedback deleteFeedback = this.feedbackRepository.read(createFeedback);
        Assert.assertNull(deleteFeedback);
    }

    @Test
    public void read() {


        Feedback createFeedback= feedbackRepository.create(feedback);
        Feedback readFeedback = feedbackRepository.read(createFeedback);
        Assert.assertNotNull(readFeedback.getGuestID());

      //  System.out.println(readFeedback);
    }


}