package com.naufal.mvvm.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.naufal.mvvm.AppPreferences
import com.naufal.mvvm.API.Model.LoginRequest
import com.naufal.mvvm.ViewModel.LoginViewModel
import com.naufal.mvvm.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment() {

    private val mainNavController: NavController? by lazy { activity?.findNavController(R.id.nav_main) }
    private val vm: LoginViewModel by sharedViewModel()
    private lateinit var captcha: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()
        initObserver()
    }

    private fun initAction() {
        btn_login.setOnClickListener {
            login()
        }
    }

    private fun initObserver() {
        vm.loginResponse.observe(viewLifecycleOwner) {
            if (it != null) {
                AppPreferences.token = it.token
                AppPreferences.name = it.nama
                Log.d("Verify Token", AppPreferences.token)
//                Do Something
            }
        }
    }

    private fun login() {
        val nip = et_nip.text.toString()
        val fingerid = et_fingerid.text.toString()
        val recaptcha = "true"
        vm.login(LoginRequest(nip, fingerid, recaptcha))
    }

    private fun isFormEmpty(): Boolean =
        et_nip.text.isNullOrEmpty() || et_fingerid.text.isNullOrEmpty()

    // Move to home screen
//    private fun moveToDashboard() {
//        val direction = R.id.action_LoginFragment_to_DashboardFragment
//        mainNavController?.navigate(direction)
//    }

    override fun onDestroy() {
        super.onDestroy()
        vm.clearVM()
    }
}