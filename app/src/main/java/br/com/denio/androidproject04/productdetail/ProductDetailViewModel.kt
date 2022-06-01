package br.com.denio.androidproject04.productdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.denio.androidproject04.persistence.Product
import br.com.denio.androidproject04.persistence.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
private const val TAG = "ProductDetailViewModel"

class ProductDetailViewModel(code: String?): ViewModel() {

    lateinit var product : MutableLiveData<Product>


    init {

        if (code != null) {
            getProduct(code)
        } else {
            product = MutableLiveData<Product>()
            product.value = Product()
        }
    }

    private fun getProduct(productCode: String) {
        product = ProductRepository.getProductByCode(productCode)
    }

    override fun onCleared() {
        if (product.value != null
            && product.value!!.code != null
            && product.value!!.code!!.isNotBlank()) {
            ProductRepository.saveProduct(product.value!!)
        }
        super.onCleared()

    }

}
