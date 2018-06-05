package bakeapp.rako.simpledelegateplushighorderfunction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KProperty
import kotlin.math.pow





class MainActivity : AppCompatActivity(), DialogOperacao.ClickPosition {
    val operacoes = arrayListOf<String>("Elevation 2", "Log")
    var mOperation: Operacao = Operacao()
    lateinit var nameOperation : String

    fun functionOperation(val1 : Double, val2 : Double, operation: (Double, Double) -> Double) : Double{
        return operation(val1, val2)
    }

    fun exponential() : (Double, Double) -> Double = {val1, val2 ->
        val1.pow(val2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //var t = PropsByMap()
        //val l = t.mapDelegate.getValue<SomeData>(t, PropsByMap::p2)
        val t = Teste()
        t.p = waterFilter
        updateDirty(10, 2, t.p as (Int, Int) -> Int)

        setContentView(R.layout.activity_main)
        select_tipo.setOnClickListener(View.OnClickListener {
            var dialogOperacao = DialogOperacao()
            var bundle = Bundle()
            bundle.putStringArrayList("lista", operacoes)
            dialogOperacao.arguments = bundle
            dialogOperacao.show(supportFragmentManager, DialogOperacao::class.java.simpleName)
        })
    }

    override fun onClick(position: Int) {
        var inputValue = (value_input.text).toString()
        var value = inputValue.toDouble()
         when (position) {
            0 ->  {
                mOperation.doOperacao = functionOperation(value, 2.0, exponential())
                result_value.text = "${mOperation.doOperacao}"
            }

        }
    }
}


class MapDelegate {
    private var map = mutableMapOf<String, Any?>()
    operator fun <T> getValue(thisRef: Any?, property: KProperty<*>) : T {
        return map[property.name] as T
    }

    operator fun <T> setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        map.put(property.name, value)
    }
}

class SomeData(val char: Char)
class PropsByMap(){
    val mapDelegate = MapDelegate()
    var p1 : Int by MapDelegate()
    var p2 : SomeData by mapDelegate
    init {
        mapDelegate.setValue(this, PropsByMap::p2, SomeData('K'))
        mapDelegate.setValue(this, PropsByMap::p1, 0)
        p1 = 5
    }
}

class Teste {
    var p : Any by MapDelegate()
}


val waterFilter: (Int, Int) -> Int = { i: Int, i1: Int ->  i1*i}
fun feedFish(dirty: Int) = dirty +10
fun updateDirty(dirty: Int, dirty2: Int, operation: (Int, Int) -> Int) : Int? {
    return operation(dirty, dirty2)
}