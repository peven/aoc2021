package day04

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class testDay04 {

    val inputRaw: String = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n" +
            "\n" +
            "22 13 17 11  0\n" +
            " 8  2 23  4 24\n" +
            "21  9 14 16  7\n" +
            " 6 10  3 18  5\n" +
            " 1 12 20 15 19\n" +
            "\n" +
            " 3 15  0  2 22\n" +
            " 9 18 13 17  5\n" +
            "19  8  7 25 23\n" +
            "20 11 10 24  4\n" +
            "14 21 16 12  6\n" +
            "\n" +
            "14 21 17 24  4\n" +
            "10 16 15  9 19\n" +
            "18  8 23 26 20\n" +
            "22 11 13  6  5\n" +
            " 2  0 12  3  7\n"

    val sampleLines = inputRaw.reader().readLines()

    val minimalisticLines = listOf("1,2,3","","  1  4  5")

    @Test
    fun create1x1Matrix() {
        val stringMatrix = listOf("  1")
        val board = BingoBoard.build(stringMatrix)

        val expected = listOf(listOf(1))
        assertEquals(expected, board.matrix)
    }

    @Test
    fun create1x1MatrixWithHeadingBlankLine() {
        val stringMatrix = listOf("", "  1")
        val board = BingoBoard.build(stringMatrix)

        val expected = listOf(listOf(1))
        assertEquals(expected, board.matrix)
    }

    @Test
    fun create1x3Matrix() {
        val stringMatrix = listOf("  1 23  4")
        val board = BingoBoard.build(stringMatrix)

        val expected = listOf(listOf(1, 23, 4))
        assertEquals(expected, board.matrix)
    }

    @Test
    fun create5x5Matrix() {
        val stringMatrix =
            listOf("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19")
        val board = BingoBoard.build(stringMatrix)

        val expected = listOf(
            listOf(22, 13, 17, 11, 0),
            listOf(8, 2, 23, 4, 24),
            listOf(21, 9, 14, 16, 7),
            listOf(6, 10, 3, 18, 5),
            listOf(1, 12, 20, 15, 19)
        )
        assertEquals(expected, board.matrix)
    }

    @Test
    fun buildBingoGameFromSample() {
        val bingo = BingoGame(sampleLines)

        assertTrue(bingo.numbers.count()==27)
        assertTrue(bingo.boards.count()==3)
    }

}