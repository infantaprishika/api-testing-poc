
package api.Vet;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Vet {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String id;

    @Expose
    private List<specialities> specialities;
/*
    @Override
    public String toString() {
        return "Vet{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", id=" + id +
                ", specialities=" + specialities +
                '}';


    }*/


}


