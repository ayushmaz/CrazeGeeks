package android.example.crazegeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isLoggedIn = true;
    String getUsername;
    String getPassword;
    private EditText usernameText;
    private EditText passwordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        usernameText = findViewById(R.id.login_username);
        passwordText = findViewById(R.id.login_Password);
        loginButton = findViewById(R.id.login_login);


        TextView signUpText = findViewById(R.id.signup_textview);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupPage = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signupPage);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsername = usernameText.getText().toString();
                getPassword = passwordText.getText().toString();

                if (getUsername.equals("abc") && getPassword.equals("123")) {
                    isLoggedIn = true;
                    Intent homePage = new Intent(MainActivity.this, HomePage.class);
                    startActivity(homePage);
                } else {
                    isLoggedIn = false;
                }

            }
        });

    }
}
