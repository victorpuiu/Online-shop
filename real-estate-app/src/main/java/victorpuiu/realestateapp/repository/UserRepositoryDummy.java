//package victorpuiu.realestateapp.repository;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//import victorpuiu.realestateapp.entity.User;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//@Profile("dummy")
//@Primary
//public class UserRepositoryDummy implements UserRepository {
//
//    @Override
//    public Optional<User> findByUsername(String username) {
//        User user = new User();
//        user.setUsername("test");
//        user.setId(1L);
//        user.setPassword("testpassword");
//        return Optional.of(user);
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends User> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<User> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public User getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public User getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public User getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends User> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<User> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(User entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends User> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<User> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        return null;
//    }
//}
