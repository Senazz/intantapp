package com.example.intantapp
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.app.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone : Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnMoveWithResult : Button = findViewById(R.id.btn_move_activity_with_result)
        btnMoveWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

        if (intent.extras != null){
            val hasil = intent.getIntExtra(move_for_result.EXTRA_SELECTED_VALUE,0)
            val text = "Hasil : $hasil"
            tvResult.setText(text)
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity->{
                val moveIntent = Intent(this@MainActivity,move::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data->{
                val moveWithDataIntent = Intent(this@MainActivity,
                    move_with_data::class.java)
                moveWithDataIntent.putExtra(move_with_data.EXTRA_NAME, "Amalia")
                moveWithDataIntent.putExtra(move_with_data.EXTRA_AGE, 20)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number->{
                val phoneNumber = "081331671057"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_activity_with_object->{
                val person = person("amalia","amalia@gmail.com","malang")
                val moveWithObjectActivity = Intent(this@MainActivity,
                    move_with_object::class.java)
                moveWithObjectActivity.putExtra(move_with_object.EXTRA_PERSON, person)
                startActivity(moveWithObjectActivity)
            }
            R.id.btn_move_activity_with_result-> {
                val moveForResultIntent =
                    Intent(this@MainActivity,
                        move_for_result::class.java)
                startActivity(moveForResultIntent)
            }
        }
    }
}