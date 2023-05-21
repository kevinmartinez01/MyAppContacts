package com.example.myappcontacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myappcontacts.ui.theme.MyAppContactsTheme

class Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppContactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppContactsTheme {
        Greeting("Android")
    }
}

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;

        import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    private EditText editTextFullName;
    private DatePicker datePicker;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private EditText editTextDescription;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        // Inicializar vistas
        editTextFullName = findViewById(R.id.editTextFullName);
        datePicker = findViewById(R.id.datePicker);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonNext = findViewById(R.id.buttonNext);

        // Acción del botón "Siguiente"
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String fullName = editTextFullName.getText().toString();
                String dateOfBirth = getDateOfBirth();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String description = editTextDescription.getText().toString();

                // Crear el intent para abrir la próxima actividad (Activity2)
                Intent intent = new Intent(Activity1.this, Activity2.class);
                // Pasar los datos a la próxima actividad usando el intent
                intent.putExtra("fullName", fullName);
                intent.putExtra("dateOfBirth", dateOfBirth);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                intent.putExtra("description", description);
                startActivity(intent);
            }
        });
    }

    private String getDateOfBirth() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // El mes comienza desde 0
        int year = datePicker.getYear();
        return day + "/" + month + "/" + year;
    }
}
