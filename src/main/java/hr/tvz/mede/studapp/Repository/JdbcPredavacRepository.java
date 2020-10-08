package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Predavac;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Primary
@Repository
public class JdbcPredavacRepository implements PredavacRepository {
    private JdbcTemplate jdbc;
    private SimpleJdbcInsert predavacInserter;

    public JdbcPredavacRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.predavacInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Predavac")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Iterable<Predavac> findAll() {
        return jdbc.query("select id, ime, pozicija from Predavac",
                this::mapRowToPredavac);
    }

    @Override
    public Predavac findOne(String id) {
        return jdbc.queryForObject("select id, ime, pozicija from Predavac where id = ?",
                this::mapRowToPredavac, id);
    }

    @Override
    public Predavac save(Predavac predavac) {
        predavac.setDatumUpisa("1900");
        predavac.setId(savePredavacDetails(predavac));
        return predavac;
    }
    private long savePredavacDetails(Predavac predavac) {
        Map<String, Object> values = new HashMap<>();
        values.put("ime", predavac.getIme());
        values.put("pozicija", predavac.getPozicija());
        values.put("datumUpisa", predavac.getDatumUpisa());
        return predavacInserter.executeAndReturnKey(values).longValue();
    }

    private Predavac mapRowToPredavac(ResultSet rs, int rowNum) throws SQLException {
        Predavac predavac = new Predavac();
        predavac.setId(rs.getLong("id"));
        predavac.setIme(rs.getString("ime"));
        predavac.setPozicija(rs.getString("pozicija"));
        return predavac;
    }

}
