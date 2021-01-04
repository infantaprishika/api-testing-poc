package api.Vet;

import api.common.ApiClient;
import api.common.ApiRequest;
import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import com.google.gson.GsonBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapperType;

public class VetClient extends ApiClient {


    public VetClient(String baseUrl , String vetId){

        super(baseUrl, "/api/vets/"+vetId);
        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));

    }
    public VetClient (String baseUrl) {
        super(baseUrl, "/api/vets");

        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));
    }

    public Vet[] getVet() throws InvalidResponseException {
        ApiResponse<Vet[]> response = caller.executeRequest(getRequest(), Method.GET, Vet[].class);
        return  response.getContent();
    }


    public Vet createVet(Vet vet) throws InvalidResponseException {
        ApiRequest request = getRequest().withBody(vet).withHeader("Content-Type", "application/json");
        ApiResponse<Vet> response = caller.executeRequest(request, Method.POST, Vet.class);
        return response.getContent();
    }

    public ApiResponse<Vet[]> deleteId(){

        ApiResponse<Vet[]> response = caller.executeRequest(getRequest(), Method.DELETE, Vet[].class);
        return response;

    }


}
