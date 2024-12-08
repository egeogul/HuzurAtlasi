import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.acm431.huzuratlasi.R

class AcilDurumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acil_durum)

        // Polis Görseline Tıklanıldığında
        val polisImage = findViewById<ImageView>(R.id.polisImage)
        polisImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:155") // Polis numarası
            startActivity(intent)
        }

        // İtfaiye Görseline Tıklanıldığında
        val itfaiyeImage = findViewById<ImageView>(R.id.itfaiyeImage)
        itfaiyeImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:110") // İtfaiye numarası
            startActivity(intent)
        }

        // Ambulans Görseline Tıklanıldığında
        val ambulansImage = findViewById<ImageView>(R.id.ambulansImage)
        ambulansImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:112") // Ambulans numarası
            startActivity(intent)
        }
    }
}

