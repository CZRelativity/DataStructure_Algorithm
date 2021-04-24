package easy

fun main() {
    test()
}

private fun test() {
    val eg= arrayOf(
            intArrayOf(1,2,2,1,1,3),
            intArrayOf(1,2),
            intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)
    )
    for (i in eg){
        println(uniqueOccurrences(i))
    }
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val count = IntArray(2001)
    for (i in arr) {
        count[i + 1000]++
    }
    val notUnique = BooleanArray(1000)
    for (i in count) {
        if (i != 0) {
            if (notUnique[i]) {
                return false
            } else {
                notUnique[i] = true
            }
        }
    }
    return true
}