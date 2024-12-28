package ec.edu.ups.ms.builder;

import ec.edu.ups.ms.domain.enums.IdentificationType;
import ec.edu.ups.ms.domain.model.Passenger;

public interface PassengerBuilder {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setIdentificationNumber(String identificationNumber);

    void setIdentificationType(IdentificationType identificationType);

    void setEmail(String email);

    void setDocumentIssuingCountry(String documentIssuingCountry);

    void setCreditCardNumber(Long creditCardNumber);

    void setCreditCardNumber(String creditCardNumber);

    Passenger build();

}
