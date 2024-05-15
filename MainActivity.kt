import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.colorListView)

        val colorDataParser = ColorDataParser(this)
        val colorList = colorDataParser.parseData()

        val colorListAdapter = ColorListAdapter(this, colorList)
        listView.adapter = colorListAdapter

        // Set click listener for each color cell
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedColor = colorList[position]

            // Start DetailScreen activity and pass the selected color information
            val intent = Intent(this, DetailScreen::class.java)
            intent.putExtra("color", selectedColor as Serializable)
            startActivity(intent)
        }
    }
}
