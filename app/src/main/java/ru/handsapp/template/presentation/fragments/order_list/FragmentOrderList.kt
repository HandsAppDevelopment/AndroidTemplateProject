package ru.handsapp.template.presentation.fragments.order_list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.handsapp.template.R
import ru.handsapp.template.databinding.FragmentOrderListBinding
import ru.handsapp.template.presentation.MainViewModel

class FragmentOrderList : Fragment() {

    //region Properties

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private val orderListViewModel: OrderListViewModel by lazy {
        val viewModel = ViewModelProvider(this).get(OrderListViewModel::class.java)
        viewModel.setErrorHandler(mainViewModel)
        viewModel
    }

    private lateinit var binding: FragmentOrderListBinding

    //endregion

    //region Lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_list, container, false)
        binding.lifecycleOwner = this
        val view = binding.root
        binding.viewmodel = orderListViewModel

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        val toolbarOrderList = binding.toolbarOrderList
        (activity as AppCompatActivity).setSupportActionBar(toolbarOrderList)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbarOrderList.title = getString(R.string.title_order_list)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.isBottomNavVisible.value = true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.order_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.order_complaint -> {
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //endregion
}