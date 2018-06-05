package bakeapp.rako.simpledelegateplushighorderfunction


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_operacao.*

/**
 * Created by rako on 05/06/2018.
 */
class DialogOperacao : DialogFragment(){
    lateinit var list: ArrayList<String>

    interface ClickPosition{
        fun onClick(position : Int)
    }

    override fun setArguments(args: Bundle?) {
        list = args?.getStringArrayList("lista") as ArrayList<String>
        super.setArguments(args)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_operacao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var arrayAdapter = ArrayAdapter<String>(activity, R.layout.item_operacao,
                list)
        list_operacao.adapter = arrayAdapter
        list_operacao.onItemClickListener = AdapterView.OnItemClickListener { _: AdapterView<*>, view1: View, i: Int, l: Long ->
            (activity as(ClickPosition)).onClick(i)
            dismiss()
        }
    }
}