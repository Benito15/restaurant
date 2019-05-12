package ac.za.cput.repositories.feedback

import ac.za.cput.domains.feedback.Feedback
import ac.za.cput.repositories.IRepository

interface FeedbackRepository extends IRepository<Feedback,String> {

    Set<Feedback>getAll();


}