package ec.edu.ups.ms;

import ec.edu.ups.ms.builder.PassengerBuilder;
import ec.edu.ups.ms.builder.PassengerBuilderImpl;
import ec.edu.ups.ms.config.Booking;
import ec.edu.ups.ms.config.Constants;
import ec.edu.ups.ms.exceptions.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Main {

    static final Logger logger = LoggerFactory.getLogger(Main.class);

    static final Booking BOOKING = Booking.getInstance();

    public static void main(String[] args) {

        MDC.put("app-name", "flight-booking");

        Constants.RESERVATIONS_FILE_NAME.forEach(fileName -> {

            MDC.put("file-name", fileName);

            try {

                logger.info("Application started");

                var reservations = BOOKING.readBookings(fileName);

                logger.info("There are {} reservations", reservations.size());

                reservations.forEach(reservation -> {

                    PassengerBuilder passengerBuilder = new PassengerBuilderImpl();
                    var input = reservation.split("\\|");
                    passengerBuilder.setCreditCardNumber(input[0]);
                    passengerBuilder.build();

                });

                logger.info("Application finished");

            } catch (FileException e) {
                logger.error("FileException: File name {}, cause: {}", e.getFileName(), e);
            } catch (Exception e) {
                logger.error("General exception", e);
            }

        });

        MDC.clear();

    }
}