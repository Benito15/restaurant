package ac.za.cput.repositorytest.feedbacktest;

import ac.za.cput.domains.feedback.Feedback;
import ac.za.cput.factory.feedbackfactory.FeedbackFactory;
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

    @Before
    public void setUp() throws Exception {

        this.feedbackRepository = FeedbackRepositoryImpl.getRepository();
        nowDate = new Date();
        feedback = FeedbackFactory.getFeedback("This Restaurant is awesome", nowDate);
        instantDate = LocalDate.of(2019,06,1);
    }

    @Test
    public void getAll() {
        Set<Feedback> getAllFeedback = this.feedbackRepository.getAll();
        System.out.println("Get All FeedBack: " + getAllFeedback.size());
        Assert.assertNotNull(getAllFeedback);
    }

    @Test
    public void create() {
       feedbackRepository.create(feedback);
      //  System.out.println(feedback);
        System.out.println(feedbackRepository.getAll().size());
        Assert.assertEquals(1,feedbackRepository.getAll().size());

    }

@Test
public void update() {

    Instant instant = Instant.from(instantDate.atStartOfDay(ZoneId.of("GMT")));
    Date pastDate = Date.from(instant);

    Feedback feedback = FeedbackFactory.getFeedback("This is some Feedback to Update", nowDate);
    Feedback feedback2 = FeedbackFactory.getFeedback("Feedback 2", pastDate);

    feedbackRepository.create(feedback);
    //feedbackRepository.create(feedbackk);
    feedback.setGuestID("12");
    feedbackRepository.update(feedback);

    int repoSize = feedbackRepository.getAll().size();
    System.out.println(repoSize);
    Assert.assertTrue("Repository > 1 = ", feedbackRepository.getAll().size() > 1);

}

    @Test
    public void delete() {
        Feedback feedback = FeedbackFactory.getFeedback("Feedback", nowDate);
        Feedback feedback2 = FeedbackFactory.getFeedback("Feedback 2 ", nowDate);
        System.out.println("//////////");
        System.out.println(feedback);

        feedbackRepository.create(feedback);
        feedbackRepository.create(feedback2);

         feedback.setGuestID( "15");
        feedbackRepository.update(feedback);


        System.out.println(feedback);
        feedbackRepository.delete(feedback.getGuestID());

        int size = feedbackRepository.getAll().size();

        System.out.println(feedbackRepository.getAll());
    }

    @Test
    public void read() {
        Instant instant = Instant.from(instantDate.atStartOfDay(ZoneId.of("GMT")));
        Date pastDate = Date.from(instant);

        Feedback feedback = FeedbackFactory.getFeedback("This is some Feedback to Update", nowDate);

        feedbackRepository.create(feedback);
        Feedback readFeedback = this.feedbackRepository.read(feedback.getGuestID());

      //  System.out.println(readFeedback);
    }


}