class DateRange(val start: MyDate, val end: MyDate):Iterable<MyDate>{
    override operator fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }
}

class DateIterator(private val range: DateRange): Iterator<MyDate>{

    var current = range.start
    override fun hasNext(): Boolean {
        return current >= range.start && current <= range.end
    }

    override fun next(): MyDate {
        var result = current
        current = current.nextDay()
        return result
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
