package com.example.simpleblog

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.simpleblog.ui.FragmentSaved
import com.example.simpleblog.ui.FragmetBlog

class SimpleFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    // This determines the fragment for each tab
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FragmetBlog()
        } else {
            FragmentSaved()
        }
    }

    // This determines the number of tabs
    override fun getCount(): Int {
        return 2
    }

    // This determines the title for each tab
    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return when (position) {
            0 -> "Blog"
            1 -> "Saved"
            else -> null
        }
    }

}