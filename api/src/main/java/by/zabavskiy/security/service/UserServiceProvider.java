package by.zabavskiy.security.service;

import by.zabavskiy.domain.Role;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.SystemRoles;
import by.zabavskiy.service.RoleService;
import by.zabavskiy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceProvider implements UserDetailsService {

    private final RoleService roleService;

    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<User> searchResult = userService.findByLogin(username); //переделано через service
            if (searchResult.isPresent()) {
                User user = searchResult.get();
                return new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(roleService.findUserRoles(user.getId()).stream().map(Role::getRoleName).map(SystemRoles::name).collect(Collectors.joining(",")))
                );
            } else {
                throw new UsernameNotFoundException(String.format("No user found with login '%s'.", username));
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User with this login not found");
        }
    }
}