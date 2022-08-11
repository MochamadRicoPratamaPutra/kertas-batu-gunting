package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rico.challenge4.databinding.ActivityChoosingEnemyBinding
import com.rico.challenge4.model.ExtraSource
import com.rico.challenge4.model.ExtraSource.USERNAME

class ChoosingEnemyActivity : AppCompatActivity() {

    var binding: ActivityChoosingEnemyBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosingEnemyBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val username = intent.getStringExtra(USERNAME)
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
            var snackbar = Snackbar.make(ivLawanCpu, "Selamat datang $username", Snackbar.LENGTH_LONG)
            Log.d("TESTING RESULT", "$username")
            snackbar.setAction("Tutup") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
        binding?.tvLawanCpu?.text = "$username vs CPU"
    }

    fun choosingEnemy(enemyType: String) {
        var intentEnemy = Intent(this@ChoosingEnemyActivity, MainActivity::class.java)
        intentEnemy.putExtra(ExtraSource.ENEMY_TYPE, enemyType)
        startActivity(intentEnemy)
    }
}