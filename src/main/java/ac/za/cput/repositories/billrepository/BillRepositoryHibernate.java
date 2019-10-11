package ac.za.cput.repositories.billrepository;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepositoryHibernate extends CrudRepository <Bill, String > {
}
