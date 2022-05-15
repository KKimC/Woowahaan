import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.test.woowahan.R
import com.test.woowahan.data.GroupMenus
import com.test.woowahan.data.Menus
import com.test.woowahan.request.ImageDownloadManager

class MainListAdapter(val context: Context, val menuList: ArrayList<Menu>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.main_recyclerview_item, null)

        val menuTitle = view.findViewById<TextView>(R.id.foodTitleText)
        val menuDes = view.findViewById<TextView>(R.id.foodDescriptionText)

        val menu = menuList[position]
        //menuTitle.text = menu.name
        //menuDes.text = menu.description

        return view
    }

    override fun getItem(position: Int): Any {
        return menuList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return menuList.size
    }
}