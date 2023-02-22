package victorpuiu.realestateapp.repository;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.Account;

/**
 * The database connection with the basic CRUD compatibilities to the account table
 */

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @NonNull
    Boolean existsByEmailAndPassword(@NonNull String email, @NonNull String password);

    Account findByEmailAndPassword(@NonNull String email, @NonNull String password);







}
