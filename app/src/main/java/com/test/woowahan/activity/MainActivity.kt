package com.test.woowahan.activity

import MainListAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.test.woowahan.data.Menus
import com.test.woowahan.databinding.ActivityMainBinding
import com.test.woowahan.repo.RequestRepository
import com.test.woowahan.request.ImageDownloadManager
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = requireNotNull(_binding)
    var menuList = arrayListOf<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * API 호출예제
         * 예제는 삭제/수정 가능합니다.
         *
         * 예제코드의 모든 코드는 변경, 수정 가능합니다.
         */
        lifecycleScope.launch { val shopdata = RequestRepository().requestData()
            binding.restaurantMainTitleTextView.text = shopdata.data.shopInfo.shopName

            binding.ratingBar.rating = shopdata.data.shopInfo.statisticsInfo.starAveragePoint.toFloat()

            val recentReview = shopdata.data.shopInfo.statisticsInfo.reviewCountLatest.toString()

            binding.recentReviewNumber.text = "최근 리뷰 : $recentReview"

            binding.deliveryTipText.text = shopdata.data.shopInfo.deliveryTipInfo.deliveryTipPrice

            binding.deliveryTimeText.text = shopdata.data.shopInfo.deliveryTimeInfo.deliveryTimeInfo

            binding.restaurantImage.setImageBitmap(ImageDownloadManager.getImage(shopdata.data.shopInfo.headerImages[0].url))

            var menuList =
                shopdata.data.shopMenu.groupMenus




        }

        val menuAdapter = MainListAdapter(this, menuList)
        binding.recyclerView.adapter = menuAdapter










        binding.callButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0000000000")
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }




        fun startDetailActivity() {
            DetailActivity.getIntent(this@MainActivity)
        }
    }
}