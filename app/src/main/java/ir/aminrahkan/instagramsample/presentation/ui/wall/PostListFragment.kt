package ir.aminrahkan.instagramsample.presentation.ui.wall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.aminrahkan.instagramsample.databinding.FragmentWallBinding
import ir.aminrahkan.instagramsample.presentation.ui.adapter.PostListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/11/22 - 2022
// Project name : Instagram Sample

@AndroidEntryPoint
class PostListFragment : Fragment() {

    lateinit var binding: FragmentWallBinding
    private val postListViewModel: PostListViewModel by viewModels()
    lateinit var adapter: PostListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMember()
        initViews()
        fetchPostList()
    }

    private fun initMember() {
        adapter = PostListAdapter()
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.rvPostList.layoutManager = layoutManager
        binding.rvPostList.adapter = adapter
    }


    private fun fetchPostList() {
        lifecycleScope.launch {
            postListViewModel.getPostsFromDb().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}