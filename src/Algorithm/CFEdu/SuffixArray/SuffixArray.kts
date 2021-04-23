package Algorithm.CFEdu.SuffixArray

class SuffixArray{

    class Pair: Comparable<Pair> {
        var c : Char
        var p : Int
        override fun compareTo(other: Pair): Int {
            return this.c - other.c
        }
    }

    public static fun main(args: Array<String>) : void {
        d = Pair('d', 1)
        println(d)
    }
}