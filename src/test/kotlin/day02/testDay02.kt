package day02

import Command
import Position
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day02Tests {

    @Test
    fun moveForwardByOneFromStart() {
        val position = Position(0,0,0)
        val command = Command(Operation.FORWARD,1)
        val result = position.move(command)

        val expected = Position(1,0,0)
        assertEquals(expected, result)
    }

    @Test
    fun moveDownByOneFromStart() {
        val position = Position(0,0,0)
        val command = Command(Operation.DOWN,1)
        val result = position.move(command)

        val expected = Position(0,0,1)
        assertEquals(expected, result)
    }

    @Test
    fun moveUpByOneFromStart() {
        val position = Position(0,0,1)
        val command = Command(Operation.UP,1)
        val result = position.move(command)

        val expected = Position(0,0,0)
        assertEquals(expected, result)
    }
}