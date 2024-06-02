package com.example.prjctutsadmlyd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText;
    private Button registerButton;
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi elemen UI
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        // Set event listener untuk tombol register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // validasi sederhana
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    // Jika ada field yang kosong, tampilkan pesan kesalahan
                    Toast.makeText(RegisterActivity.this, "Isi semua kolom!!!", Toast.LENGTH_SHORT).show();
                    //event log
                    Log.d(TAG, "text field tidak diisi");

                } else {
                    Toast.makeText(getApplicationContext(), "Data Berhasil Di Simpan", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("username", usernameEditText.getText().toString());
                    intent.putExtra("password", passwordEditText.getText().toString());
                    //event log
                    Log.d(TAG, "Register Sukses");
                    startActivity(intent);
                    finish();

                }
            }

        });
    }
}
