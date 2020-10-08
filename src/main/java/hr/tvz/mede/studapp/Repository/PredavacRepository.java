package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Predavac;

public interface PredavacRepository {
    Iterable<Predavac> findAll();
    Predavac findOne(String id);
    Predavac save(Predavac predavac);
}
