package lk.ijse.gdse63.aad.user_authorized_service.advisor;

import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class ExceptionHandler {

    @Autowired
    private Response response;

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public Response handleException(Exception exception){
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Server throw an exception : "+exception.getLocalizedMessage());
        response.setData(null);
        return response;
    }
}
