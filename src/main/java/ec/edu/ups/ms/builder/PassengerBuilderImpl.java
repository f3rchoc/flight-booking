package ec.edu.ups.ms.builder;

import ec.edu.ups.ms.domain.enums.IdentificationType;
import ec.edu.ups.ms.domain.model.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class PassengerBuilderImpl implements PassengerBuilder {

    static final Logger logger = LoggerFactory.getLogger(PassengerBuilderImpl.class);

    private final Passenger passenger;

    public PassengerBuilderImpl() {
        this.passenger = new Passenger();
    }

    @Override
    public void setFirstName(String firstName) {

        if (Objects.isNull(firstName) || firstName.isEmpty() || firstName.length() > 50) {
            throw new IllegalArgumentException("First name cannot be null or longer than 50 characters");
        }

        if (!firstName.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("First name contains invalid characters");
        }

        this.passenger.setFirstName(firstName);

    }

    @Override
    public void setLastName(String lastName) {
        this.passenger.setLastName(lastName);
    }

    @Override
    public void setIdentificationNumber(String identificationNumber) {
        this.passenger.setIdentificationNumber(identificationNumber);
    }

    @Override
    public void setIdentificationType(IdentificationType identificationType) {
        this.passenger.setIdentificationType(identificationType);
    }

    @Override
    public void setEmail(String email) {
        this.passenger.setEmail(email);
    }

    @Override
    public void setDocumentIssuingCountry(String documentIssuingCountry) {
        this.passenger.setDocumentIssuingCountry(documentIssuingCountry);
    }

    @Override
    public void setCreditCardNumber(Long creditCardNumber) {
        this.passenger.setCreditCardNumber(creditCardNumber);
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {

        try {
            var carNumber = Long.valueOf(creditCardNumber);
            this.passenger.setCreditCardNumber(carNumber);
        } catch (NumberFormatException e) {
            logger.error("Failed to parse val = {}", creditCardNumber);
        }

    }

    @Override
    public Passenger build() {
        return this.passenger;
    }


}
