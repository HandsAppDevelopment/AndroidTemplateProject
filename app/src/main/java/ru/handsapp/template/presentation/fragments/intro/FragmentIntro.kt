package ru.handsapp.template.presentation.fragments.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import ru.handsapp.template.R
import ru.handsapp.template.presentation.MainViewModel

class FragmentIntro : Fragment() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(activity as FragmentActivity).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_intro, container, false)

        // Скрыть BottomNav для отображения
        mainViewModel.setBottomNavVisible(false)

        return view
    }
}