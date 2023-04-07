package farrukh.example.olxuz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import farrukh.example.olxuz.adapter.CategoryAdapter
import farrukh.example.olxuz.adapter.CategoryFragmentAdapter
import farrukh.example.olxuz.databinding.FragmentCategoryBinding
import farrukh.example.olxuz.modul.Category

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var category_items = mutableListOf<Category>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentCategoryBinding.inflate(inflater, container, false)

        category_fill()

        val category_adapter = CategoryFragmentAdapter(category_items)
        binding.categoryRecycle.adapter = category_adapter
        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.categoryRecycle.layoutManager = manager

        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main,MainFragment()).commit()
        }

        return binding.root
    }

    fun category_fill() {

        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.property))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Ko'chmas mulk", R.drawable.property))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi", R.drawable.childrenworld))

    }
        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}