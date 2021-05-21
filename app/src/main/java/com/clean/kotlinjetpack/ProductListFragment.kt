package com.clean.kotlinjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean.kotlinjetpack.adapter.ProductAdapter
import com.clean.kotlinjetpack.databinding.FragmentProductDetailBinding
import com.clean.kotlinjetpack.databinding.FragmentProductListBinding
import com.clean.kotlinjetpack.util.OnDisableTimeClickListener
import com.clean.kotlinjetpack.util.Status

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : BaseFragment(),ProductAdapter.OnAdapter {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentProductListBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductListViewModel
    private lateinit var adapter: ProductAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding.root
        return getPersistentView(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(hasInitializedRootView){
            return
        }

       binding. rvList.layoutManager = LinearLayoutManager(context)
        adapter = ProductAdapter()
        adapter.setListener(this)



        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        setupViewModel()



        binding.imgRefresh.setOnClickListener(OnDisableTimeClickListener({
setupViewModel()

        }))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemCLick(item: Product) {
      val action=ProductListFragmentDirections.listToDetail(item)
    findNavController().navigate(action)
    }
    fun setupViewModel(){
        viewModel.getProducts().observe(requireActivity(), Observer {resource->
            when (resource.status) {
                Status.SUCCESS -> {
                    binding.rvList.visibility = View.VISIBLE
                    binding.pbLoading.visibility = View.GONE

                    adapter.setList(resource.data as MutableList<Product>)
                    binding.rvList.adapter=adapter
                    resource.message

                }
                Status.ERROR -> {
                    binding.rvList.visibility = View.GONE
                    binding.pbLoading.visibility = View.GONE
                    binding.txtError.visibility=View.VISIBLE
                    binding.txtError.text=resource.message
                    binding.imgRefresh.visibility=View.VISIBLE
                }
                Status.LOADING -> {
                    binding.txtError.visibility=View.GONE
                    binding.imgRefresh.visibility=View.GONE
                    binding.rvList.visibility=View.GONE

                    binding.pbLoading.visibility = View.VISIBLE

                }
            }

        })
    }


}