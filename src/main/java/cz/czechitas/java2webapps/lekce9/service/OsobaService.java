package cz.czechitas.java2webapps.lekce9.service;

import cz.czechitas.java2webapps.lekce9.entity.Osoba;
import cz.czechitas.java2webapps.lekce9.repository.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

/**
 * Služba pro práci s osobami a adresami.
 */
@Service
public class OsobaService {
  private final OsobaRepository osobaRepository;

  @Autowired
  public OsobaService(OsobaRepository osobaRepository) {
    this.osobaRepository = osobaRepository;
  }

  /**
   * Vrací stránkovaný seznam všech osob v databázi.
   */
  public Page<Osoba> seznamOsob(Pageable pageable) {
    return osobaRepository.findAll(pageable);
  }

  /**
   * Vrací stránkovaný seznam všech osob v databázi, které se narodili mezi uvedenými roky.
   */
  public Page<Osoba> seznamDleRokuNarozeni(int rokOd, int rokDo, Pageable pageable) {
    return osobaRepository.findByRok(rokOd, rokDo, pageable);
  }

  /**
   * Vrací stránkovaný seznam všech osob v databázi, jejichž příjmení začíná uvedeným textem.
   */
  public Page<Osoba> seznamDlePrijmeni(String prijmeni, Pageable pageable) {
    return osobaRepository.findByPrijmeniStartingWithIgnoreCase(prijmeni, pageable);
  }

  /**
   * Vrací stránkovaný seznam všech osob v databázi, které bydlí v uvedené obci.
   */
  public Page<Osoba> seznamDleObce(String obec, Pageable pageable) {
    return osobaRepository.findByObec(obec, pageable);
  }

  /**
   * Vrací stránkovaný seznam všech osob v databázi, které dosáhli zadaného věku.
   */
  public Page<Osoba> seznamDleVeku(int vek, Pageable pageable) {
    LocalDate date = LocalDate.now().minusYears(vek);
    return osobaRepository.findByDatumNarozeniBefore(date, pageable);
  }

}
