package com.clean.kotlinjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clean.kotlinjetpack.databinding.FragmentProductDetailBinding
import com.clean.kotlinjetpack.databinding.FragmentProductListBinding
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailFragment : BaseFragment() {

    private var _binding: FragmentProductDetailBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val product:Product=ProductDetailFragmentArgs.fromBundle(requireArguments()).product

        Picasso.with(context).load(product.imgUrl).resize(100,100).into(binding.imgProduct)
        binding.txtName.text=product.name
        binding.txtDescription.text=product.description






    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}