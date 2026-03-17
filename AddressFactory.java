package za.ac.cput.Factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

import java.util.UUID;

public class AddressFactory {
    public static Address createAddress(String streetNumber,String streetName,
                                         int postalCode, String city, String province,String country){
        streetNumber = UUID.randomUUID().toString();

        if(Helper.isEmptyorNull(streetName)||Helper.isEmptyorNull(city)
                ||Helper.isEmptyorNull(province)||Helper.isEmptyorNull(country)){
            return null;
        }

        return new Address.Builder()
                .SetStreetName(streetName)
                .SetStreetNumber(streetNumber)
                .SetPostalCode(postalCode)
                .SetCity(city)
                .SetProvince(province)
                .SetCountry(country)
                .build();
    }
}
