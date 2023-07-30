package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityEight44Binding
import com.example.ylearn.educational.sharedClass.SyllabusMaterials

class Eight44 : AppCompatActivity() {
    private lateinit var binding: ActivityEight44Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEight44Binding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //primary
        binding.btnMathPri.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnEnglishPri.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnKiswahili1Pri.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnSci.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnSocialStudies.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnIrePri.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnCrePrimary.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnRevisionPrimary.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }

        //secondary
        binding.btnMath.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnEnglish.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnKiswahili1.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnBio.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnChem.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnPhy.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnBiz.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnComp.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnAgriculture.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnIre.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnCre.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }
        binding.btnRevisionSecondary.setOnClickListener {
            startActivity(Intent(this, EightFour4::class.java))
        }


    }
}