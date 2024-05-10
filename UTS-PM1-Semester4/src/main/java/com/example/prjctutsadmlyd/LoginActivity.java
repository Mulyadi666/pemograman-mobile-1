package com.example.prjctutsadmlyd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_REGISTER = 1;
    //tag untuk mengetahui log even berada di activity mana
    private static final String TAG = "LoginActivity";
    private EditText usernameEditText, passwordEditText;
    private Button loginButton, registerButton;

    // Variabel untuk menyimpan data yang diterima dari RegisterActivity
    private String registeredUsername, registeredPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi elemen UI
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            registeredUsername = extras.getString("username");
            registeredPassword = extras.getString("password");

            // Masukkan data ke dalam EditText
            usernameEditText.setText(registeredUsername);
        }
        // Set event listener untuk tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //  validasi login
                if (username.equals("adiganteng") && password.equals("adiganteng")) {
                    // Jika login berhasil, arahkan ke activity berikutnya
                    Toast.makeText(LoginActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();
                    Intent dashboardIntent = new Intent(LoginActivity.this, NewsPortalDashboard.class);
                    //mengirim username ke newsportaldashboard
                    dashboardIntent.putExtra("username", username);

                    startActivity(dashboardIntent);
                    //Event log
                    Log.d(TAG, "login sukses");
                    finish(); // Tutup activity ini agar tidak dapat dikembalikan dengan tombol back

                //validasi login jiga register terlebih dahulu
                } else if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                    // Jika username dan password yang dimasukkan cocok dengan data yang didaftarkan
                    // Lakukan proses login
                    // Misalnya, arahkan pengguna ke halaman beranda aplikasi
                    Intent intent = new Intent(LoginActivity.this, NewsPortalDashboard.class);
                    intent.putExtra("username", username);

                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "login sukses");
                // validasi ketika textfield kosong
                } else if (username.isEmpty() || password.isEmpty()) {
                    // Jika ada field yang kosong, tampilkan pesan kesalahan
                    Toast.makeText(LoginActivity.this, "Isi semua kolom!!!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "text field tidak diisi");

                } else {
                    // Jika login gagal, tampilkan pesan kesalahan
                    Toast.makeText(LoginActivity.this, "Username atau password  salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
//saat button register di klik maka berpindah ke RegisterActivity
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke activity registrasi
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(registerIntent, REQUEST_REGISTER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == Activity.RESULT_OK) {
                // Proses jika registrasi berhasil
                Toast.makeText(LoginActivity.this, "Registrasi sukses", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
