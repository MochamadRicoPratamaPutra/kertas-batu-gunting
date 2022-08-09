package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rico.challenge4.databinding.ActivityChoosingEnemyBinding
import com.rico.challenge4.model.ExtraSource

class ChoosingEnemyActivity : AppCompatActivity() {

    var binding: ActivityChoosingEnemyBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosingEnemyBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.apply {
            ivLawanCpu.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_cpu))
            }
            tvLawanCpu.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_cpu))
            }
            ivLawanTeman.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_friend))
            }
            tvLawanTeman.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_friend))
            }
        }
    }

    fun choosingEnemy(enemyType: String) {
        var intentEnemy = Intent(this@ChoosingEnemyActivity, MainActivity::class.java)
        intentEnemy.putExtra(ExtraSource.ENEMY_TYPE, enemyType)
        startActivity(intentEnemy)
    }
}