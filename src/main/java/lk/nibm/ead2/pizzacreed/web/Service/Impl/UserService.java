package lk.nibm.ead2.pizzacreed.web.Service.Impl;


import lk.nibm.ead2.pizzacreed.web.Service.IUserService;
import lk.nibm.ead2.pizzacreed.web.model.User;
import lk.nibm.ead2.pizzacreed.web.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    //find user by username
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    //save user
    @Override
    public User save(User user){
        User dao=null;
        if(user.getId()==null){
            dao=new User();
        }
        else{
            Optional<User> optionalUser=userRepository.findById(user.getId());
            if(optionalUser.isPresent()){
                dao=optionalUser.get();
            }
        }
        BeanUtils.copyProperties(user,dao);
        dao = userRepository.save(dao);
        user.setId(dao.getId());
        return user;
    }
}
