package com.example.lifecycle.viewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.lifecycle.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //usando o binding com viewmodels (tambem é delegate)
    //private val viewModel by viewModels<MainViewModel>()

    //com delegate
    private val viewModel by activityViewModels<MainViewModel>()
    // o activityViewModels usa o msm codigo do view model abaixo
    //aqui o viewModelProvider nao esta recebendo fragmente (this)  e sim uma activity
    //viewModel = ViewModelProvider(activity as AppCompatActivity).get()

   // SEM DELEGATE (REALIZAMOS O VIEWPROVIDER PRIMEIRAMENTE COM O LATEINIT
    // private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.counter.observe(viewLifecycleOwner){ counter ->
            binding.counter.text = counter.toString()

        }

        binding.buttonSecond.setOnClickListener {
            viewModel.increment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}