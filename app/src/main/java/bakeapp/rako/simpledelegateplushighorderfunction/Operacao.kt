package bakeapp.rako.simpledelegateplushighorderfunction

/**
 * Created by rako on 05/06/2018.
 */
class Operacao{

    private val delegator = Delegator()
    var doOperacao : Any by delegator

    fun getResult() : Double{
        return 0.0
    }
}
