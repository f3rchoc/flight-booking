package ec.edu.ups.ms.config;

import ec.edu.ups.ms.exceptions.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Booking {

    static final Logger logger = LoggerFactory.getLogger(Booking.class);

    private static final Booking INSTANCE = new Booking();

    private Booking() {}

    public static Booking getInstance() {
        return INSTANCE;
    }

    public List<String> readBookings(String reservationsFileName) {

        logger.info("Read bookings");

        try {

            ClassLoader classLoader = Booking.class.getClassLoader();
            String path = Objects.requireNonNull(classLoader.getResource(reservationsFileName)).getPath();
            return Files.readAllLines(Paths.get(path));

        } catch (IOException e) {
            throw new FileException("Error when try to read the reservations file", e, reservationsFileName);
        }

    }

}
