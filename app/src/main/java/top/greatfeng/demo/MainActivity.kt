package top.greatfeng.demo

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import top.greatfeng.base.app.BaseActivity
import top.greatfeng.demo.databinding.ActivityMainBinding
import top.greatfeng.user.UserFragment

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, UserFragment())
            .commitNowAllowingStateLoss()

    }
}