package victorpuiu.realestateapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import victorpuiu.realestateapp.entity.Property;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PropertyRepositoryDefault implements PropertyRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Property> findByPriceLessThanOrEqual(Double max) {
        return entityManager.createQuery("SELECT p FROM property p WHERE p.price <= :max", Property.class)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public List<Property> findByPriceGreaterThanOrEqual(Double min) {
        return null;
    }

    @Override
    public List<Property> findByPriceBetween(Double min, Double max) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Property> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Property> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Property> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Property getOne(Long aLong) {
        return null;
    }

    @Override
    public Property getById(Long aLong) {
        return null;
    }

    @Override
    public Property getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Property> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Property> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Property> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Property> findAll() {
        return null;
    }

    @Override
    public List<Property> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Property> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Property> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Property entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Property> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Property> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Property> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Property> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Property> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Property> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Property> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Property, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
