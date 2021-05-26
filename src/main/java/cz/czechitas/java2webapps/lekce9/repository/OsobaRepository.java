package cz.czechitas.java2webapps.lekce9.repository;

import cz.czechitas.java2webapps.lekce9.entity.Osoba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Repository pro tabulku {@code osoba}.
 */
@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Long> {
  /**
   * Vyhledá všechny osoby s adresou v dané obci.
   */
  @Query("SELECT o FROM Osoba o JOIN o.adresa a WHERE a.obec = ?1")
  Page<Osoba> findByObec(String obec, Pageable pageable);

  /**
   * Vyhledá všechny osoby, které se narodily v daný den nebo dříve.
   */
  Page<Osoba> findByDatumNarozeniBefore(LocalDate datum, Pageable pageable);

  /**
   * Vyhledá všechny osoby, jejichž příjmení začíná na uveddený text.
   */
  Page<Osoba> findByPrijmeniStartingWithIgnoreCase(String prijmeni, Pageable pageable);

  /**
   * Vyhledá všechny osoby, které se narodily v rozmezí zadaných let.
   */
  @Query("SELECT o FROM Osoba o WHERE YEAR(o.datumNarozeni) BETWEEN :pocatecniRok AND :koncovyRok")
  Page<Osoba> findByRok(@Param("pocatecniRok") int pocatecniRok, @Param("koncovyRok") int koncovyRok, Pageable pageable);
}
