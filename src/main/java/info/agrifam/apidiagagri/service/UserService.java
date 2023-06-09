package info.agrifam.apidiagagri.service;


import info.agrifam.apidiagagri.dto.UserDTO;
import info.agrifam.apidiagagri.dto.UserResponseDTO;
import info.agrifam.apidiagagri.entity.User;
import info.agrifam.apidiagagri.exceptions.NoItemException;
import info.agrifam.apidiagagri.repository.UserRepository;
import info.agrifam.apidiagagri.security.SecurityConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final ModelMapper mapper = new ModelMapper();

    public List<UserResponseDTO> findAll(){
        return userRepository.findAll().stream().map(user ->
                new UserResponseDTO(user.getId(), user.getName(), user.getUsername(), user.getIsEnabled()))
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO user){
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        User userToSave = mapper.map(user, User.class);
        userRepository.save(userToSave);
        return new UserDTO(userToSave.getId(), userToSave.getName(), userToSave.getUsername(), userToSave.getPassword(),
                userToSave.getIsEnabled());
    }

    public UserDTO findById(long id){
        Optional<User> optional = userRepository.findById(id);

        if(optional.isEmpty()){
            throw new NoItemException("Usuário não encontrado!");
        }
        User user = optional.get();
        return new UserDTO(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getIsEnabled());
    }

    public UserDTO update(UserDTO user){
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        User userToSave = mapper.map(user, User.class);
        Optional<User> userToEdit = userRepository.findById(userToSave.getId());

        if(userToEdit.isEmpty()){
            throw new NoItemException("Usuário não encontrado!");
        }

        userRepository.save(userToSave);
        return new UserDTO(userToSave.getId(), userToSave.getName(), user.getUsername(), user.getPassword(),
                userToSave.getIsEnabled());
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public User getByUserName(String username){
        return userRepository.findUserByUsername(username);
    }
}
