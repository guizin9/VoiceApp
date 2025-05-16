package com.example.voiceapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.voiceapp.databinding.ActivityMainBinding
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shortcutIntent = Intent(Intent.ACTION_VIEW, "voiceapp://abrir".toUri())
        val shortcutInfo = ShortcutInfoCompat.Builder(this, "voiceapp.help_shortcut")
            .setShortLabel("Abrir")
            .setLongLabel("Abrir o app via comando")
            .addCapabilityBinding("actions.intent.OPEN_APP_FEATURE")
            .setIntent(shortcutIntent)
            .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher))
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(this, shortcutInfo)

        Log.d("MainActivity", "Deeplink recebido: ${shortcutIntent.data}")
    }
}