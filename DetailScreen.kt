import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color

class DetailScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_detail)

        // Retrieve the selected color information from the intent extras
        val selectedColor = intent.getSerializableExtra("color") as ColorSpec

        // Set background color
        val detailLayout = findViewById<RelativeLayout>(R.id.detailLayout)
        val backgroundColor = android.graphics.Color.parseColor(selectedColor.hex)
        detailLayout.setBackgroundColor(backgroundColor)

        // Set up TextViews to display color details
        val colorIDTextView = findViewById<TextView>(R.id.colorIdTextView)
        val colorNameTextView = findViewById<TextView>(R.id.colorNameTextView)
        val colorHexTextView = findViewById<TextView>(R.id.colorHexTextView)
        val colorRgbTextView = findViewById<TextView>(R.id.colorRgbTextView)
        val colorHslTextView = findViewById<TextView>(R.id.colorHslTextView)

        // Set the text of TextViews with color details
        colorIDTextView.text = selectedColor.colorId.toString()
        colorNameTextView.text = selectedColor.name
        colorHexTextView.text = selectedColor.hex
        colorRgbTextView.text = "RGB: ${selectedColor.rgb.r}, ${selectedColor.rgb.g}, ${selectedColor.rgb.b}"
        colorHslTextView.text = "HSL: ${selectedColor.hsl.h}, ${selectedColor.hsl.s}, ${selectedColor.hsl.l}"

        // Handle back button click
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
