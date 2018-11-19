package e.saplyng.davesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
            login(1),
            password(2),
            success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = idLoginText
        val txtPassword = idPassword
        val btnLogin = idButtonLogin

        btnLogin.setOnClickListener {
            when (checkLogin(txtLogin.text.toString(), txtPassword.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_SHORT).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_SHORT).show()
                    txtPassword.requestFocus()
                }

                else -> Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "jeremy"
        val holdPass = "hunter2"

        if(holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            LoginSuccess.password
        }else LoginSuccess.success
    }

}
