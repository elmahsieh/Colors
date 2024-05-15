import android.content.Context
import org.json.JSONArray
import java.io.Serializable

class ColorDataParser(private val context: Context) {

    fun parseData(): List<ColorSpec> {
        val jsonString = loadJSONFromAsset("data.json")
        val jsonArray = JSONArray(jsonString)

        val colorList = mutableListOf<ColorSpec>()

        for (i in 0 until jsonArray.length()) {
            val colorObject = jsonArray.getJSONObject(i)
            val colorId = colorObject.getInt("colorId")
            val name = colorObject.getString("name")
            val hex = colorObject.getString("hexString")
            val rgbObject = colorObject.getJSONObject("rgb")
            val rgb = RGB(rgbObject.getInt("r"), rgbObject.getInt("g"), rgbObject.getInt("b"))
            val hslObject = colorObject.getJSONObject(("hsl"))
            val hsl = HSL(hslObject.getInt("h"), hslObject.getInt("s"), hslObject.getInt("l"))

            val colorSpec = ColorSpec(colorId, name, hex, rgb, hsl)
            colorList.add(colorSpec)
        }

        return colorList
    }

    private fun loadJSONFromAsset(filename: String): String {
        return context.assets.open(filename).bufferedReader().use {
            it.readText()
        }
    }
}

data class ColorSpec(
    val colorId: Int,
    val name: String,
    val hex: String,
    val rgb: RGB,
    val hsl: HSL
) : Serializable

data class RGB(
    val r: Int,
    val g: Int,
    val b: Int
) : Serializable

data class HSL(
    val h: Int,
    val s: Int,
    val l: Int
) : Serializable