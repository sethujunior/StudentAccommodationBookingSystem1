package za.ac.cput.Factory;

import za.ac.cput.domain.Accomodation;

public class AccomodationFactory {
    public static Accomodation createAccomodation(String AccomodationId, String Name, String Gender, String ContactNumber, String Location, Accomodation accomodationStatus) {
        return new Accomodation.Builder()
                .setAccomodationId(AccomodationId)
                .setName(Name)
                .setGender(Gender)
                .setContactNumber(ContactNumber)
                .setLocation(Location)
                .setAccomodationStatus(accomodationStatus.getAccomodationStatus())
                .build();
    }
}