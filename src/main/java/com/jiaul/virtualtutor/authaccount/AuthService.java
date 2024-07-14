package com.jiaul.virtualtutor.authaccount;

import com.jiaul.virtualtutor.authaccount.dto.AuthResponse;
import com.jiaul.virtualtutor.authaccount.dto.LoginRequest;
import com.jiaul.virtualtutor.authaccount.dto.LogoutRequest;
import com.jiaul.virtualtutor.authaccount.dto.RegistrationRequest;
import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.entities.admin.Admin;
import com.jiaul.virtualtutor.entities.jwt.JwtToken;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenService;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import com.jiaul.virtualtutor.enums.RoleEnum;
import com.jiaul.virtualtutor.user.UserCredential;
import com.jiaul.virtualtutor.user.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private UserCredentialService userCredentialService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    /*
    checking user authentication
    checking user current login status through JWT
    providing login access and updating JWT
     */
    public AuthResponse logIn(LoginRequest loginRequest) {
        AuthResponse authResponse = new AuthResponse();
        try {
            UserCredential userCredential = (UserCredential) authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())).getPrincipal();

            JwtToken newJwtToken = new JwtToken();

            if (userCredential.getJwtToken() == null) {     // first login try after SignUp
                newJwtToken = jwtTokenService.createJwtTokenByUserCredential(userCredential);
                userCredential.setJwtToken(newJwtToken);
            }
//            else if (userCredential.getJwtToken().isNonRevoked() &&             // have to revoke and not expire
//                    !jwtService.isTokenExpired(userCredential.getJwtToken().getTokenValue())) {
//                authResponse.setMessage("Already login with a Device");
//                return authResponse;
//            }
            else {
                newJwtToken = jwtTokenService.updateTokenValueByUserCredential(userCredential);
            }

            JwtToken jwtToken = jwtTokenService.saveToken(newJwtToken);
            if (jwtToken != null) {
                String message = "User Login Successfully";
                authResponse = makeAuthResponse(userCredential, jwtToken, message);
            }
        } catch (Exception e) {
            authResponse.setMessage("Bad Credential ! Try Right User & Password. " + e.getMessage());
        }
        return authResponse;
    }

    /*
    creating User credential
    creating Role based profile
     */
    public String signUp(RegistrationRequest registrationRequest) {

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(registrationRequest.getEmail());
        userCredential.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userCredential.setRole(registrationRequest.getRole());
        userCredential.setRegistrationDate(new Date());
        userCredential.setAccountNonExpired(true);
        userCredential.setAccountNonLocked(true);
        userCredential.setCredentialsNonExpired(true);
        userCredential.setEnabled(true);

        if (userCredential.getRole().equals(RoleEnum.STUDENT.toString())) {
            Student newStudent = new Student();
            newStudent.setFirstName(registrationRequest.getName());
            newStudent.setUserCredential(userCredential);
            userCredential.setStudent(newStudent);
        } else if (userCredential.getRole().equals(RoleEnum.TEACHER.toString())) {
            Teacher newTeacher = new Teacher();
            newTeacher.setFirstName(registrationRequest.getName());
            newTeacher.setUserCredential(userCredential);
            userCredential.setTeacher(newTeacher);
        } else if (userCredential.getRole().equals(RoleEnum.ADMIN.toString())) {
            Admin newAdmin = new Admin();
            newAdmin.setFirstName(registrationRequest.getName());
            newAdmin.setUserCredential(userCredential);
            userCredential.setAdmin(newAdmin);
        } else {
            return "role must needed";
        }

        try {
            UserCredential userCredential1 = userCredentialService.createUserCredential(userCredential);
            if (userCredential1 != null) {
                return "Registration Complete";
            }
        } catch (Exception e) {
            return "Internal Server Error. " + e.getMessage();
        }
        return "Registration Failed";
    }

    public String logOut(LogoutRequest logoutRequest,String header){
        UserCredential userCredential=userCredentialService.getUserCredentialByEmail(logoutRequest.getEmail());
        if(logoutRequest.getToken().equals(header.substring(7)) &&
                userCredential!=null &&
                userCredential.getJwtToken().getTokenValue().equals(logoutRequest.getToken())){
            jwtTokenService.revokeToken(userCredential.getJwtToken());
            return "Logout Successfully";
        }
        return "Logout Failed";
    }

    /*
    making login response based on the role
     */
    public AuthResponse makeAuthResponse(UserCredential userCredential, JwtToken jwtToken, String message) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(userCredential.getEmail());
        authResponse.setRole(userCredential.getRole());
        if (authResponse.getRole().equals(RoleEnum.STUDENT.toString())) {
            authResponse.setId(userCredential.getStudent().getId());
            authResponse.setName(userCredential.getStudent().getFirstName());
            authResponse.setPhoto(userCredential.getStudent().getPhoto());
        } else if (authResponse.getRole().equals(RoleEnum.TEACHER.toString())) {
            authResponse.setId(userCredential.getTeacher().getId());
            authResponse.setName(userCredential.getTeacher().getFirstName());
            authResponse.setPhoto(userCredential.getTeacher().getPhoto());
        } else if (authResponse.getRole().equals(RoleEnum.ADMIN.toString())) {
            authResponse.setId(userCredential.getAdmin().getId());
            authResponse.setName(userCredential.getAdmin().getFirstName());
            authResponse.setPhoto(userCredential.getAdmin().getPhoto());
        }
        authResponse.setMessage(message);
        authResponse.setJwtToken(jwtToken.getTokenValue());
        authResponse.setJwtTokenType(jwtToken.getTokenType());
        return authResponse;
    }
}
