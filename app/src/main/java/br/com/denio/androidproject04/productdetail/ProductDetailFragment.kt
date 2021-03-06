package br.com.denio.androidproject04.productdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.denio.androidproject04.databinding.FragmentProductDetailBinding

private const val TAG = "ProductDetailFragment"
class ProductDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i(TAG, "Creating ProductDetailFragment")
        val binding = br.com.denio.androidproject04.databinding.FragmentProductDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
//Fetch the product code and create the ViewModel here
        val productCode = ProductDetailFragmentArgs.fromBundle(requireArguments()).productCode
        val productDetailViewModelFactory = ProductDetailViewModelFactory(productCode)
        binding.productDetailViewModel = ViewModelProvider(this, productDetailViewModelFactory).get(ProductDetailViewModel::class.java)

        return binding.root
    }
}
