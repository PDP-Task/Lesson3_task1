package uz.manifest.lesson3_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.manifest.lesson3_task1.adapter.ViewPagerAdapter
import uz.manifest.lesson3_task1.fragments.ChatsFragment
import uz.manifest.lesson3_task1.fragments.ContactFragment
import uz.manifest.lesson3_task1.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        viewPager = findViewById(R.id.view_pager)
        bottomNavigationView = findViewById(R.id.bottom_nav_menu)
        viewPagerAdapter = ViewPagerAdapter(fragmentList(), supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.contacts -> {
                    viewPager.currentItem = 0
                }
                R.id.chats -> {
                    viewPager.currentItem = 1
                }
                R.id.settings -> {
                    viewPager.currentItem = 2
                }
            }
            true
        }

        bottomNavigationView.getOrCreateBadge(R.id.chats).number = 9

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun fragmentList(): ArrayList<Fragment> {
        return arrayListOf(
            ContactFragment(),
            ChatsFragment(),
            SettingFragment()
        )
    }
}