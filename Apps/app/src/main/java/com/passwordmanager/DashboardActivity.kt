package com.passwordmanager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.passwordmanager.accountslist.AccountListFragment
import com.passwordmanager.addaccount.AddAccountActivity
import com.passwordmanager.utils.Constants
import com.passwordmanager.databinding.ActivityDashboardBinding
import com.passwordmanager.utils.PagerAdapter

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.dashboardTab.addTab(
            binding.dashboardTab.newTab().setText(getString(R.string.added_by_you))
        )
        binding.dashboardTab.addTab(
            binding.dashboardTab.newTab().setText(getString(R.string.shared_with_you))
        )
        binding.dashboardTab.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFrag(AccountListFragment.getInstance(Constants.Bundle.TYPE_YOURS),getString(R.string.added_by_you))
        adapter.addFrag(AccountListFragment.getInstance(Constants.Bundle.TYPE_SHARED),getString(R.string.shared_with_you))
        binding.dashboardViewPager.adapter = adapter

        binding.dashboardViewPager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                binding.dashboardTab
            )
        )
        binding.dashboardTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.dashboardViewPager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.dashboard_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_account ->{
                startActivity(Intent(this, AddAccountActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}