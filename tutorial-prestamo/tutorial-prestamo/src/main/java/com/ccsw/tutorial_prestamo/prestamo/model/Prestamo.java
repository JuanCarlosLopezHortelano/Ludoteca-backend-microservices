package com.ccsw.tutorial_prestamo.prestamo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author ccsw
 */

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_game", nullable = false)
    private Long id_game;

    @Column(name = "id_client", nullable = false)
    private Long id_client;

    @Column(name = "loanDate", nullable = false)
    private LocalDate loanDate;

    @Column(name = "returnDate", nullable = false)
    private LocalDate returnDate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id new value of {@link #getId}
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_game() {
        return this.id_game;
    }

    public void setId_game(Long id_game) {
        this.id_game = id_game;
    }

    public Long getId_client() {
        return this.id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    /**
     * @return loanDate
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate new value of {@link #getLoanDate}
     *
     */
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * @return returnDate
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate new value of {@link #getReturnDate}
     *
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
