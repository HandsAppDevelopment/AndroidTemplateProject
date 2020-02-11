package ru.handsapp.template.presentation.fragments.order_list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_order_list.*
import ru.handsapp.template.R
import ru.handsapp.template.presentation.MainViewModel

class FragmentOrderList : Fragment() {

    //region Properties

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(activity as FragmentActivity).get(MainViewModel::class.java)
    }

    //endregion

    //region Lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_order_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        val toolbarOrderList = toolbar_order_list
        (activity as AppCompatActivity).setSupportActionBar(toolbarOrderList)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbarOrderList.title = getString(R.string.title_order_list)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.setBottomNavVisible(true)
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