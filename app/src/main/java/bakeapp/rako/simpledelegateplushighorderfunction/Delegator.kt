package bakeapp.rako.simpledelegateplushighorderfunction

import kotlin.reflect.KProperty

/**
 * Created by rako on 05/06/2018.
 */
class Delegator{
    private var map = mutableMapOf<String, Any?>()
    operator fun <T> getValue(thisRef: Any?, property: KProperty<*>) : T {
        return map[property.name] as T
    }

    operator fun <T> setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        map.put(property.name, value)
    }
}