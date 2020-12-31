
package api.Vet;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class specialities {

    @Expose
    private Long id;

    @Expose
    private String name;

   /* @Override
    public String toString() {
        return "specialities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/
}