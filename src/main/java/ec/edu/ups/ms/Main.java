package ec.edu.ups.ms;

import ec.edu.ups.ms.builder.PassengerBuilder;
import ec.edu.ups.ms.builder.PassengerBuilderImpl;
import ec.edu.ups.ms.config.Booking;
import ec.edu.ups.ms.config.Constants;
import ec.edu.ups.ms.domain.enums.IdentificationType;
import ec.edu.ups.ms.domain.model.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final Logger logger = LoggerFactory.getLogger(Main.class);

    static final Booking BOOKING = Booking.getInstance();

    public static void main(String[] args) {

        logger.info("Hello, World!");

        try {

            List<Passenger> passengers = new ArrayList<>();

            var reservations = BOOKING.readBookings(Constants.RESERVATIONS_FILE_NAME);
            reservations.forEach(reservation -> {
                PassengerBuilder passengerBuilder = new PassengerBuilderImpl();
                logger.info(reservation);
                var input = reservation.split("\\|");
                passengerBuilder.setIdentificationNumber(input[1]);
                passengerBuilder.setIdentificationType(IdentificationType.valueOf(input[2]));
                passengerBuilder.setDocumentIssuingCountry(input[3]);
                passengerBuilder.setFirstName(input[4]);
                passengerBuilder.setLastName(input[5]);
                passengerBuilder.setEmail(input[6]);
                var passenger = passengerBuilder.build();
                logger.info("IdentificationNumber: {}", passenger.getIdentificationNumber());

                passengers.add(passenger);
            });

            passengers.toString();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}