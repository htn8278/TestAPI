package guru.springframework.commands;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import java.util.Date;

public class UserForm {


    private String email;
    private String password;



    public UserForm(String email, String password)
    {
        this.email=email;
        this.password=password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
