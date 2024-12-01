package com.biblioteca.reservation_service.service;

import com.biblioteca.reservation_service.dto.ReservationDto;
import com.biblioteca.reservation_service.entity.Reservation;
import com.biblioteca.reservation_service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationDto> getActiveReservations(Long userId) {
        return reservationRepository.findByUserIdAndCanceledFalse(userId).stream()
                .map(reservation -> new ReservationDto(reservation.getId(), reservation.getUserId(), reservation.getBookId(),
                        reservation.getReservationDate(), reservation.getExpirationDate(), reservation.isCanceled()))
                .collect(Collectors.toList());
    }

    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = Reservation.builder()
                .userId(reservationDto.getUserId())
                .bookId(reservationDto.getBookId())
                .reservationDate(LocalDate.now())
                .expirationDate(LocalDate.now().plusDays(7))
                .canceled(false)
                .build();
        Reservation savedReservation = reservationRepository.save(reservation);
        return new ReservationDto(savedReservation.getId(), savedReservation.getUserId(), savedReservation.getBookId(),
                savedReservation.getReservationDate(), savedReservation.getExpirationDate(), savedReservation.isCanceled());
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setCanceled(true);
        reservationRepository.save(reservation);
    }
}
