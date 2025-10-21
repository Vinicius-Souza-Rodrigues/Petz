package Backend.Backend.Auth;

import Backend.Backend.User.Model.UserFisico;
import Backend.Backend.User.Repository.UserFisicoRepository;
import Backend.Backend.User.Repository.UserJuridicoRepository;
import Backend.Backend.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserFisicoRepository repositoryFisico;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = repository.findByEmail(email);
        if (user != null) return user;

        UserDetails fisico = repositoryFisico.findByCpf(email);

        if (fisico != null) return fisico;

        throw new RuntimeException("Usuario nao encontrado");
    }
}

