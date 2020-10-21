package br.com.gamemods.nbtmanipulator

import java.io.*
import java.lang.Double.longBitsToDouble
import java.lang.Float.intBitsToFloat
import java.lang.UnsupportedOperationException

/**
 * Implementation of [DataInput] that reads data from an [InputStream] using little endian byte order.
 * @param in the underlying input stream.
 * @author joserobjr
 * @since 2020-10-20
 */
class LittleEndianDataInputStream(`in`: InputStream) : FilterInputStream(`in`), DataInput {
    override fun readFully(b: ByteArray) {
        readFully(b, 0, b.size)
    }

    override fun readFully(b: ByteArray, off: Int, len: Int) {
        if (len < 0) {
            throw IndexOutOfBoundsException()
        }
        var n = 0
        while (n < len) {
            val count = `in`.read(b, off + n, len - n)
            if (count < 0) {
                throw EOFException()
            }
            n += count
        }
    }

    override fun skipBytes(n: Int): Int {
        if (n <= 0) {
            return 0
        }
        
        val toSkip = n.toLong()
        
        var total = 0L
        var cur: Long

        do {
            cur = `in`.skip(toSkip - total)
            if (cur <= 0) {
                break
            }
            total += cur
        } while (total < toSkip)

        return total.toInt()
    }

    override fun readBoolean(): Boolean {
        return readUnsignedByte() != 0
    }

    override fun readByte(): Byte {
        return readUnsignedByte().toByte()
    }

    override fun readUnsignedByte(): Int {
        val b1 = `in`.read()
        if (b1 < 0) {
            throw EOFException()
        }
        return b1
    }

    override fun readShort(): Short {
        return readUnsignedShort().toShort()
    }

    override fun readUnsignedShort(): Int {
        val b1 = `in`.read()
        val b2 = `in`.read()
        if (b1 or b2 < 0) {
            throw EOFException()
        }
        return (b2 shl 8) or b1
    }

    override fun readChar(): Char {
        return readUnsignedShort().toChar()
    }

    override fun readInt(): Int {
        val b1 = `in`.read()
        val b2 = `in`.read()
        val b3 = `in`.read()
        val b4 = `in`.read()
        if (b1 or b2 or b3 or b4 < 0) {
            throw EOFException()
        }
        return (b4 shl 24) or (b3 shl 16) or (b2 shl 8) or b1
    }

    override fun readLong(): Long {
        val b1 = `in`.read().toLong()
        val b2 = `in`.read().toLong()
        val b3 = `in`.read().toLong()
        val b4 = `in`.read().toLong()
        val b5 = `in`.read().toLong()
        val b6 = `in`.read().toLong()
        val b7 = `in`.read().toLong()
        val b8 = `in`.read().toLong()
        if (b1 or b2 or b3 or b4 or b5 or b6 or b7 or b8 < 0) {
            throw EOFException()
        }
        return (b8 shl 56) or (b7 shl 48) or (b6 shl 40) or (b5 shl 32) or 
                (b4 shl 24) or (b3 shl 16) or (b2 shl 8) or b1
    }

    override fun readFloat(): Float {
        return intBitsToFloat(readInt())
    }

    override fun readDouble(): Double {
        return longBitsToDouble(readLong())
    }

    override fun readLine(): String {
        throw UnsupportedOperationException()
    }

    override fun readUTF(): String {
        return DataInputStream.readUTF(this)
    }

}
