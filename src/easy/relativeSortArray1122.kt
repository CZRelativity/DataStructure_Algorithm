package easy

fun main() {
    test()
}

private fun test() {
    val arr1 = intArrayOf(301, 831, 772, 544, 337, 869, 243, 650, 948, 708, 98, 857, 796, 821, 526, 283, 695, 859, 628, 88, 798, 131, 938, 825, 529, 519, 548, 779, 471, 336, 983, 452, 843, 227, 49, 192, 879, 524, 496, 339, 792, 281, 975, 370, 449, 124, 815, 994, 469, 972, 887, 797, 590, 190, 752, 78, 65, 662, 549, 159, 648, 853, 901, 133, 986, 809, 768, 980, 847, 637, 136, 303, 240, 578, 514, 587, 672, 717, 432, 611, 274, 793, 484, 329, 891, 776, 617, 771, 917, 436, 2, 750, 174, 141, 357, 862, 880, 898, 391, 748, 242, 375, 144, 396, 394, 995, 641, 876, 997, 683, 168, 773, 812, 349, 997, 698, 405, 737, 640, 39, 454, 1000, 738, 150, 719, 411, 506, 435, 949, 500, 589, 185, 58, 143, 574, 104, 522, 751, 985, 36, 487, 119, 981, 409, 320, 66, 474, 451, 439, 902, 80, 118, 155, 197, 461, 674, 114, 272, 268, 180, 202, 683, 633, 37, 487, 537, 182, 491, 488, 787, 507, 724, 629, 669, 94, 18, 419, 953, 577, 730, 287, 724, 295, 782, 963, 503, 81, 914, 538, 179, 699, 67, 392, 916, 737, 166, 525, 910, 221, 254)
    val arr2 = intArrayOf(190, 994, 938, 917, 879, 192, 847, 549, 983, 526, 303, 449, 337, 821, 336, 301, 329, 590, 831, 798, 859, 809, 124, 901, 529, 519, 544, 131, 524, 628, 484, 283, 548, 578, 78, 617, 825, 776, 948, 514, 357, 141, 750, 887, 891, 672, 432, 274, 391, 796, 227, 240, 843, 772, 695, 133, 648, 793, 980, 880, 281, 496, 768, 771, 815, 611, 98, 339, 436, 662, 797, 975, 174, 587, 708, 898, 986, 752, 49, 650, 136, 792, 471, 748, 2, 88, 469, 972, 243, 869, 159, 370, 65, 853, 717, 637, 779, 862, 452, 857)
    println(relativeSortArray(arr1, arr2).asList())
}

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val count = IntArray(1001)
    for (i in arr1) {
        count[i]++
    }
    var p = 0
    for (i in arr2) {
        repeat(count[i]) {
            arr1[p] = i
            p++
        }
        count[i] = 0;
    }
    if (p == arr1.size) {
        return arr1
    }
    for (i in count.indices) {
        if (count[i] > 0) {
            repeat(count[i]) {
                arr1[p] = i
                p++
            }
            if (p == arr1.size) {
                break
            }
        }
    }
    return arr1
}
