
package api.Vet;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class specialities {

    @Expose
    private String id;

    @Expose
    private String name;

}