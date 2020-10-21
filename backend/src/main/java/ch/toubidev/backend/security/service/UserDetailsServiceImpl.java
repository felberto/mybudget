package ch.toubidev.backend.security.service;

import ch.toubidev.backend.model.auth.User;
import ch.toubidev.backend.rest.BaseRestController;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static ch.toubidev.db.jooq.processing.tables.User.USER;

@Service
public class UserDetailsServiceImpl extends BaseRestController implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jooq.selectOne().from(USER).where(USER.USERNAME.eq(username)).fetchOneInto(User.class);

        return UserDetailsImpl.build(user);
    }
}
