package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rootView = findViewById<View>(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainBrain()
    }

    private fun mainBrain() {
        val aMass = intArrayOf(-2, 8, -4, -6, 5, 8, 6, -5, 2, 3)
        val bMass = intArrayOf(2, -7, -4, 2, 7, -4, 5, 2, -7, 5)
        val cMass = intArrayOf(-3, 2, -5, 8, 6, 8, -6, -5, 2, 3)
        val dMass = intArrayOf(-2, 8, -4, -6, 5, 4, 7, 2, -3, 6)
        val eMass = intArrayOf(1, 9, -8, 0, -4, 5, -6, 7, 2, -1)
        val fMass = intArrayOf(9, -7, -0, 8, 3, 5, 6, -7, -2, 5)

        fun massiveZigzag(massive: IntArray): IntArray {
            for (i in 1 until massive.size step 2) {
                if (i + 1 < massive.size) {
                    val temp = massive[i]
                    massive[i] = massive[i + 1]
                    massive[i + 1] = temp
                }
            }
            return massive
        }

        fun massiveMultipleSorter(first: IntArray, second: IntArray): IntArray {
            val sortedFirst = first.sortedArray()
            val sortedSecond = second.sortedArray()
            return (sortedFirst + sortedSecond).sorted().toIntArray()
        }

        fun massiveMaxOfThree(massive: IntArray): Int {
            massive.sort()
            val size = massive.size
            val a = massive[0] * massive[1] * massive[size - 1]
            val b = massive[size - 1] * massive[size - 2] * massive[size - 3]
            return maxOf(a, b)
        }

        fun massiveReverse(massive: IntArray): IntArray {
            massive.reverse()
            return massive
        }

        fun massiveChecker(massive: IntArray): Boolean {
            for (num in massive) {
                if (num % 2 != 0) {
                    return false
                }
            }
            return true
        }

        fun massiveSum(massive: IntArray): Int {
            var sum = 0
            for (element in massive) {
                sum += element
            }
            return sum
        }

        fun massiveDuplicateChecker(massive: IntArray): Boolean {
            val set = HashSet<Int>()
            for (element in massive) {
                if (!set.add(element)) {
                    return true
                }
            }
            return false
        }

        fun massiveConnect(first: IntArray, second: IntArray): IntArray {
            return (first + second)
        }

        fun massiveNullMover(massive: IntArray): IntArray {
            var i = 0
            for (element in massive) {
                if (element != 0) {
                    massive[i++] = element
                }
            }
            while (i < massive.size) {
                massive[i++] = 0
            }
            return massive
        }

        fun massiveAvg(massive: IntArray): Double {
            return massive.average()
        }

        fun massiveMoreThenAvg(massive: IntArray): Int {
            val average = massive.average()
            var count = 0
            massive.forEach {
                if (it > average) {
                    count++
                }
            }
            return count
        }

        fun massiveSecond(massive: IntArray): Int {
            val sortedArray = massive.sortedArray()
            return sortedArray[sortedArray.size - 2]
        }

        fun massiveMinRemove(massive: IntArray): IntArray {
            if (massive.isEmpty()) return massive
            val minIndex = massive.indexOf(massive.minOrNull()!!)
            return massive.filterIndexed { index, _ -> index != minIndex }.toIntArray()
        }

        fun massiveSplit(massive: IntArray): Pair<IntArray, IntArray> {
            val first = mutableListOf<Int>()
            val second = mutableListOf<Int>()
            for (element in massive) {
                if (element % 2 == 0) {
                    first.add(element)
                } else {
                    second.add(element)
                }
            }
            return Pair(first.toIntArray(), second.toIntArray())
        }

        fun massiveCustomReverse(massive: IntArray): IntArray {
            val lastIndex = massive.size - 1
            for (i in 0 until massive.size / 2) {
                val temp = massive[i]
                massive[i] = massive[lastIndex - i]
                massive[lastIndex - i] = temp
            }
            return massive
        }

        fun massiveRemoveLast(massive: IntArray): IntArray {
            if (massive.isEmpty()) return massive
            return massive.copyOfRange(0, massive.size - 1)
        }

        fun massiveAddLast(massive: IntArray, element: Int): IntArray {
            return massive + element
        }

        fun massiveLastRemove(massive: IntArray, index: Int): IntArray {
            if (index < 0 || index >= massive.size) return massive
            val result = mutableListOf<Int>()
            for (i in massive.indices) {
                if (i != index) {
                    result.add(massive[i])
                }
            }
            return result.toIntArray()
        }

        fun massiveLastAdd(massive: IntArray, index: Int, element: Int): IntArray {
            if (index < 0 || index > massive.size) return massive
            val result = mutableListOf<Int>()
            for (i in massive.indices) {
                if (i == index) {
                    result.add(element)
                }
                result.add(massive[i])
            }
            return result.toIntArray()
        }

        fun transformString(input: String): String {
            var result = ""
            var count = 1
            for (i in 1 until input.length) {
                if (input[i] == input[i - 1]) {
                    count++
                } else {
                    result += "${input[i - 1]}$count"
                    count = 1
                }
            }
            result += "${input[input.length - 1]}$count"
            return result
        }

        fun print() {
            println("First: ${massiveZigzag(aMass).contentToString()}")
            println("Second: ${massiveMultipleSorter(bMass, cMass).contentToString()}")
            println("Third: ${massiveMaxOfThree(dMass)}")
            println("Four: ${massiveReverse(eMass).contentToString()}")
            println("Five: ${massiveChecker(fMass)}")
            println("Six: ${massiveSum(aMass)}")
            println("Seven: ${massiveDuplicateChecker(fMass)}")
            println("Eight: ${massiveConnect(dMass, bMass).contentToString()}")
            println("Nine: ${massiveNullMover(dMass).contentToString()}")
            println("Ten: ${massiveAvg(bMass)}")
            println("Eleven: ${massiveMoreThenAvg(fMass)}")
            println("Twelve: ${massiveSecond(fMass)}")
            println("Thirteen: ${massiveMinRemove(eMass).contentToString()}")
            val (first, second) = massiveSplit(aMass)
            println("Fourteen - first: ${first.contentToString()}, second: ${second.contentToString()}")
            println("Fifteen: ${massiveCustomReverse(eMass).contentToString()}")
            println("Sixteen: ${massiveRemoveLast(bMass).contentToString()}")
            println("Seventeen: ${massiveAddLast(cMass, 10).contentToString()}")
            println("Eighteen: ${massiveLastRemove(aMass, 3).contentToString()}")
            println("Nineteen: ${massiveLastAdd(bMass, 2, 100).contentToString()}")
            println("Twenty: ${transformString("aaabbbbbbcdddd")}")
        }

        print()
    }
}