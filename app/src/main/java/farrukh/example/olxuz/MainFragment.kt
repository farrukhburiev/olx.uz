package farrukh.example.olxuz

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import farrukh.example.olxuz.adapter.CategoryAdapter
import farrukh.example.olxuz.adapter.ItemAdapter
import farrukh.example.olxuz.databinding.FragmentMainBinding
import farrukh.example.olxuz.modul.Category
import farrukh.example.olxuz.modul.Items

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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
    val category_items = mutableListOf<Category>()
    val item_items = mutableListOf<Items>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMainBinding.inflate(inflater,container,false)
        category_fill()
        val category_adapter = CategoryAdapter(category_items)
        binding.categoryRecycle.adapter = category_adapter
        var manager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.categoryRecycle.layoutManager = manager


        val item_adapter = ItemAdapter(item_items,object : ItemAdapter.OnClickListener{
            override fun itemClicked(position: Int, item: Items) {
                val intent = Intent()
            }

        } )
        binding.itemsRecylce.adapter = item_adapter
        var manager_item = GridLayoutManager(requireContext(),2,LinearLayoutManager.VERTICAL,false)
        binding.itemsRecylce.layoutManager = manager_item


        binding.hammasi.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main,CategoryFragment()).commit()
        }

        return binding.root
    }

    fun category_fill(){

        category_items.add(Category("Bolalar dunyosi",R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi",R.drawable.property))
        category_items.add(Category("Bolalar dunyosi",R.drawable.childrenworld))
        category_items.add(Category("Ko'chmas mulk",R.drawable.property))
        category_items.add(Category("Bolalar dunyosi",R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi",R.drawable.childrenworld))
        category_items.add(Category("Bolalar dunyosi",R.drawable.childrenworld))

        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
        item_items.add(Items("gilam",R.drawable.gilam,7.88))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}