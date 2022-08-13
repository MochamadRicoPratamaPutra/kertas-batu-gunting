package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rico.challenge4.databinding.ActivityChoosingEnemyBinding
import com.rico.challenge4.model.ExtraSource.ENEMY_TYPE
import com.rico.challenge4.model.ExtraSource.USERNAME

class ChoosingEnemyActivity : AppCompatActivity() {

    var binding: ActivityChoosingEnemyBinding? = null
    var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosingEnemyBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        username = intent.getStringExtra(USERNAME).toString()
        binding?.apply {
            ivLawanCpu.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_cpu), username.toString())
            }
            tvLawanCpu.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_cpu), username.toString())
            }
            ivLawanTeman.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_friend), username.toString())
            }
            tvLawanTeman.setOnClickListener {
                choosingEnemy(getString(R.string.enemy_friend), username.toString())
            }
            val snackbar =
                Snackbar.make(ivLawanCpu, "Selamat datang $username", Snackbar.LENGTH_LONG)
            Log.d("TESTING RESULT", "$username")
            snackbar.setAction("Tutup") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
        tvEnemyChoice(username)
    }

    fun choosingEnemy(enemyType: String, username: String) {
        val intentEnemy = Intent(this@ChoosingEnemyActivity, MainActivity::class.java)
        intentEnemy.putExtra(ENEMY_TYPE, enemyType)
        intentEnemy.putExtra(USERNAME, username)
        startActivity(intentEnemy)
    }

    fun tvEnemyChoice(username: String) {
        binding?.tvLawanCpu?.text = String.format(getString(R.string.user_vs_cpu, username))
        binding?.tvLawanTeman?.text = String.format(getString(R.string.user_vs_teman, username))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USERNAME, username)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(USERNAME)?.let { tvEnemyChoice(it) }
    }
}