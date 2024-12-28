package ec.edu.ups.ms.domain.model;

import ec.edu.ups.ms.domain.enums.IdentificationType;

public class Passenger {

    private String firstName;
    private String lastName;
    private String identificationNumber;
    private IdentificationType identificationType;
    private String email;
    private String documentIssuingCountry;

    private Long creditCardNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentIssuingCountry() {
        return documentIssuingCountry;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDocumentIssuingCountry(String documentIssuingCountry) {
        this.documentIssuingCountry = documentIssuingCountry;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
