import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ColorListAdapter(context: Context, private val colorList: List<ColorSpec>) :
    ArrayAdapter<ColorSpec>(context, R.layout.color_item_layout, colorList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.color_item_layout, parent, false)

        val colorSpec = colorList[position]

        // Set background color
        view.setBackgroundColor(Color.parseColor(colorSpec.hex))

        // Set color name
        val colorNameTextView = view.findViewById<TextView>(R.id.colorNameTextView)
        colorNameTextView.text = colorSpec.name

        // Set hex string
        val colorHexTextView = view.findViewById<TextView>(R.id.colorHexTextView)
        colorHexTextView.text = colorSpec.hex

        return view
    }
}
