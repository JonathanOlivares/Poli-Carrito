import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.myaplication.policarrito.Frutas
import com.myaplication.policarrito.R



class AgregarCarritoActivity : AppCompatActivity() {
    private lateinit var frutas: Frutas
    private var cantidad: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_carrito)

        frutas = intent.getSerializableExtra("fruta") as Frutas

        val cantidadEditText = findViewById<EditText>(R.id.editTextCantidad) // Reemplaza "editTextCantidad" con el ID correcto del EditText
        val agregarCarritoButton = findViewById<Button>(R.id.buttonAgregarCarrito) // Reemplaza "buttonAgregarCarrito" con el ID correcto del Button

        //agregarCarritoButton.setOnClickListener {
           // val editTextCantidad: EditText = findViewById(R.id.editTextCantidad)
           // if (cantidad != null && cantidad > 0 && cantidad <= frutas.Cantidad.toInt()) {
             //   cantidad = editTextCantidad.text.toString().toInt()


                // Aquí puedes agregar la lógica para agregar la cantidad al carrito
                // Puedes utilizar la variable "frutas" para obtener la información necesaria
                // Por ejemplo, puedes enviar los datos a Firebase Realtime Database o guardarlos localmente
                // También puedes mostrar un mensaje de éxito o redireccionar al usuario a otra actividad
         //   } else {
                // Mostrar un mensaje de error si la cantidad no es válida
            }
     //   }
   // }
}
