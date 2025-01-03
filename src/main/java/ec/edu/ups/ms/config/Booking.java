package ec.edu.ups.ms.config;

import ec.edu.ups.ms.exceptions.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

            var systemResource = ClassLoader.getSystemResource(reservationsFileName);

            if (null == systemResource) {
                throw new FileNotFoundException("File not found");
            }

            URI uri = systemResource.toURI();
            String path = Paths.get(uri).toString();

            return Files.readAllLines(Paths.get(path));

        } catch (IOException e) {
            throw new FileException("Error when try to read the reservations file", e, reservationsFileName);
        } catch (URISyntaxException e) {
            throw new FileException("URI error", e, reservationsFileName);
        }

    }

}
