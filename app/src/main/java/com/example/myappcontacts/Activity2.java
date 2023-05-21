package com.example.myappcontacts;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myappcontacts.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private Activity2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_2);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private TextView textViewFullName;
    private TextView textViewDateOfBirth;
    private TextView textViewPhone;
    private TextView textViewEmail;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        // Inicializar vistas
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewDateOfBirth = findViewById(R.id.textViewDateOfBirth);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewDescription = findViewById(R.id.textViewDescription);

        // Obtener los datos enviados desde la Activity1
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String dateOfBirth = intent.getStringExtra("dateOfBirth");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String description = intent.getStringExtra("description");

        // Mostrar los datos en las vistas correspondientes
        textViewFullName.setText("Nombre completo: " + fullName);
        textViewDateOfBirth.setText("Fecha de nacimiento: " + dateOfBirth);
        textViewPhone.setText("Teléfono: " + phone);
        textViewEmail.setText("Email: " + email);
        textViewDescription.setText("Descripción del contacto: " + description);
    }
}
