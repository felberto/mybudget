package ch.toubidev.backend.rest.auth;

import ch.toubidev.backend.model.auth.request.LoginRequest;
import ch.toubidev.backend.model.auth.request.SignupRequest;
import ch.toubidev.backend.model.auth.response.JwtResponse;
import ch.toubidev.backend.model.auth.response.MessageResponse;
import ch.toubidev.backend.rest.BaseRestController;
import ch.toubidev.backend.rest.MyBudgetApi;
import ch.toubidev.backend.security.jwt.JwtUtils;
import ch.toubidev.backend.security.service.UserDetailsImpl;
import ch.toubidev.db.jooq.processing.tables.records.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static ch.toubidev.db.jooq.processing.tables.User.USER;

@RestController
@RequestMapping(path = "/api/auth/")
@Transactional
public class AuthResource extends BaseRestController {

    private static final Logger logger = LoggerFactory.getLogger(AuthResource.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping(path = "signin", method = {RequestMethod.POST}, produces = {MyBudgetApi.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername()));
    }

    @RequestMapping(path = "signup", method = {RequestMethod.POST}, produces = {MyBudgetApi.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (jooq.fetchExists(jooq.selectFrom(USER).where(USER.USERNAME.eq(signUpRequest.getUsername())))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        UserRecord userRecord = jooq.newRecord(USER);
        userRecord.setUsername(signUpRequest.getUsername());
        userRecord.setEmail(signUpRequest.getEmail());
        userRecord.setPassword(encoder.encode(signUpRequest.getPassword()));
        userRecord.store();

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

        //TODO after signup to login page and test login
        //TODO frontend message (toast) successfully registered
    }
}
