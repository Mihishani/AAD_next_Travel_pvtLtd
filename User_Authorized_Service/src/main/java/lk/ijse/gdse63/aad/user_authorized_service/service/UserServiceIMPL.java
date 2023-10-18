package lk.ijse.gdse63.aad.user_authorized_service.service;

import jakarta.transaction.Transactional;

import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDTO;

import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailsControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.User;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserDetailsService,UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageDetailsControllerInterface packageDetailsControllerInterface;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByUserName(username);
        return user.isPresent()? user.get():user.orElseThrow(()->new UsernameNotFoundException("User Not found!"));
    }

    @Override
    public Response save(UserDTO userDTO) {
        if (search(userDTO.getUserId()).getData() == null) {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully saved!", null);
        }
        throw new RuntimeException("User already exists!");

    }

    @Override
    public Response update(UserDTO userDTO) {
        if (search(userDTO.getUserId()).getData() != null) {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully updated!", null);
        }
        throw new RuntimeException("User does not exists!");

    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            userRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully deleted!", null);
        }
        throw new RuntimeException("User does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<User> user = userRepo.findById(s);
        if (user.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "User Successfully retrieved!", modelMapper.map(user.get(), User.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User does not exists!", null);

    }

    @Override
    public UserDTO getUserDetails(String s) {
        Optional<User> user = userRepo.findById(s);

        if (user.isPresent()) {
            System.out.println(user.get());
            return modelMapper.map(user.get(), UserDTO.class);
        }
        throw new RuntimeException("userdetail cannot found!!!");

    }

    @Override
    public Response getAll() {
        List<User> users = userRepo.findAll();
        if (!users.isEmpty()) {
            ArrayList<UserDTO> userDto = new ArrayList<>();
            users.forEach((userDetails) -> {
                userDto.add(modelMapper.map(userDetails, UserDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Users Successfully retrieved!", userDto);
        }
        throw new RuntimeException("No Users found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
