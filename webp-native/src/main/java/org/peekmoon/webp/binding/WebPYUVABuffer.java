// Generated by jextract

package org.peekmoon.webp.binding;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct WebPYUVABuffer {
 *     uint8_t *y;
 *     uint8_t *u;
 *     uint8_t *v;
 *     uint8_t *a;
 *     int y_stride;
 *     int u_stride;
 *     int v_stride;
 *     int a_stride;
 *     size_t y_size;
 *     size_t u_size;
 *     size_t v_size;
 *     size_t a_size;
 * }
 * }
 */
public class WebPYUVABuffer {

    WebPYUVABuffer() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        LibWebPDecode.C_POINTER.withName("y"),
        LibWebPDecode.C_POINTER.withName("u"),
        LibWebPDecode.C_POINTER.withName("v"),
        LibWebPDecode.C_POINTER.withName("a"),
        LibWebPDecode.C_INT.withName("y_stride"),
        LibWebPDecode.C_INT.withName("u_stride"),
        LibWebPDecode.C_INT.withName("v_stride"),
        LibWebPDecode.C_INT.withName("a_stride"),
        LibWebPDecode.C_LONG.withName("y_size"),
        LibWebPDecode.C_LONG.withName("u_size"),
        LibWebPDecode.C_LONG.withName("v_size"),
        LibWebPDecode.C_LONG.withName("a_size")
    ).withName("WebPYUVABuffer");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout y$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("y"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *y
     * }
     */
    public static final AddressLayout y$layout() {
        return y$LAYOUT;
    }

    private static final long y$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *y
     * }
     */
    public static final long y$offset() {
        return y$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *y
     * }
     */
    public static MemorySegment y(MemorySegment struct) {
        return struct.get(y$LAYOUT, y$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *y
     * }
     */
    public static void y(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(y$LAYOUT, y$OFFSET, fieldValue);
    }

    private static final AddressLayout u$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("u"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *u
     * }
     */
    public static final AddressLayout u$layout() {
        return u$LAYOUT;
    }

    private static final long u$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *u
     * }
     */
    public static final long u$offset() {
        return u$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *u
     * }
     */
    public static MemorySegment u(MemorySegment struct) {
        return struct.get(u$LAYOUT, u$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *u
     * }
     */
    public static void u(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(u$LAYOUT, u$OFFSET, fieldValue);
    }

    private static final AddressLayout v$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("v"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *v
     * }
     */
    public static final AddressLayout v$layout() {
        return v$LAYOUT;
    }

    private static final long v$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *v
     * }
     */
    public static final long v$offset() {
        return v$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *v
     * }
     */
    public static MemorySegment v(MemorySegment struct) {
        return struct.get(v$LAYOUT, v$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *v
     * }
     */
    public static void v(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(v$LAYOUT, v$OFFSET, fieldValue);
    }

    private static final AddressLayout a$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("a"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *a
     * }
     */
    public static final AddressLayout a$layout() {
        return a$LAYOUT;
    }

    private static final long a$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *a
     * }
     */
    public static final long a$offset() {
        return a$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *a
     * }
     */
    public static MemorySegment a(MemorySegment struct) {
        return struct.get(a$LAYOUT, a$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *a
     * }
     */
    public static void a(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(a$LAYOUT, a$OFFSET, fieldValue);
    }

    private static final OfInt y_stride$LAYOUT = (OfInt)$LAYOUT.select(groupElement("y_stride"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int y_stride
     * }
     */
    public static final OfInt y_stride$layout() {
        return y_stride$LAYOUT;
    }

    private static final long y_stride$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int y_stride
     * }
     */
    public static final long y_stride$offset() {
        return y_stride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int y_stride
     * }
     */
    public static int y_stride(MemorySegment struct) {
        return struct.get(y_stride$LAYOUT, y_stride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int y_stride
     * }
     */
    public static void y_stride(MemorySegment struct, int fieldValue) {
        struct.set(y_stride$LAYOUT, y_stride$OFFSET, fieldValue);
    }

    private static final OfInt u_stride$LAYOUT = (OfInt)$LAYOUT.select(groupElement("u_stride"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int u_stride
     * }
     */
    public static final OfInt u_stride$layout() {
        return u_stride$LAYOUT;
    }

    private static final long u_stride$OFFSET = 36;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int u_stride
     * }
     */
    public static final long u_stride$offset() {
        return u_stride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int u_stride
     * }
     */
    public static int u_stride(MemorySegment struct) {
        return struct.get(u_stride$LAYOUT, u_stride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int u_stride
     * }
     */
    public static void u_stride(MemorySegment struct, int fieldValue) {
        struct.set(u_stride$LAYOUT, u_stride$OFFSET, fieldValue);
    }

    private static final OfInt v_stride$LAYOUT = (OfInt)$LAYOUT.select(groupElement("v_stride"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int v_stride
     * }
     */
    public static final OfInt v_stride$layout() {
        return v_stride$LAYOUT;
    }

    private static final long v_stride$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int v_stride
     * }
     */
    public static final long v_stride$offset() {
        return v_stride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int v_stride
     * }
     */
    public static int v_stride(MemorySegment struct) {
        return struct.get(v_stride$LAYOUT, v_stride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int v_stride
     * }
     */
    public static void v_stride(MemorySegment struct, int fieldValue) {
        struct.set(v_stride$LAYOUT, v_stride$OFFSET, fieldValue);
    }

    private static final OfInt a_stride$LAYOUT = (OfInt)$LAYOUT.select(groupElement("a_stride"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int a_stride
     * }
     */
    public static final OfInt a_stride$layout() {
        return a_stride$LAYOUT;
    }

    private static final long a_stride$OFFSET = 44;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int a_stride
     * }
     */
    public static final long a_stride$offset() {
        return a_stride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int a_stride
     * }
     */
    public static int a_stride(MemorySegment struct) {
        return struct.get(a_stride$LAYOUT, a_stride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int a_stride
     * }
     */
    public static void a_stride(MemorySegment struct, int fieldValue) {
        struct.set(a_stride$LAYOUT, a_stride$OFFSET, fieldValue);
    }

    private static final OfLong y_size$LAYOUT = (OfLong)$LAYOUT.select(groupElement("y_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t y_size
     * }
     */
    public static final OfLong y_size$layout() {
        return y_size$LAYOUT;
    }

    private static final long y_size$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t y_size
     * }
     */
    public static final long y_size$offset() {
        return y_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t y_size
     * }
     */
    public static long y_size(MemorySegment struct) {
        return struct.get(y_size$LAYOUT, y_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t y_size
     * }
     */
    public static void y_size(MemorySegment struct, long fieldValue) {
        struct.set(y_size$LAYOUT, y_size$OFFSET, fieldValue);
    }

    private static final OfLong u_size$LAYOUT = (OfLong)$LAYOUT.select(groupElement("u_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t u_size
     * }
     */
    public static final OfLong u_size$layout() {
        return u_size$LAYOUT;
    }

    private static final long u_size$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t u_size
     * }
     */
    public static final long u_size$offset() {
        return u_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t u_size
     * }
     */
    public static long u_size(MemorySegment struct) {
        return struct.get(u_size$LAYOUT, u_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t u_size
     * }
     */
    public static void u_size(MemorySegment struct, long fieldValue) {
        struct.set(u_size$LAYOUT, u_size$OFFSET, fieldValue);
    }

    private static final OfLong v_size$LAYOUT = (OfLong)$LAYOUT.select(groupElement("v_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t v_size
     * }
     */
    public static final OfLong v_size$layout() {
        return v_size$LAYOUT;
    }

    private static final long v_size$OFFSET = 64;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t v_size
     * }
     */
    public static final long v_size$offset() {
        return v_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t v_size
     * }
     */
    public static long v_size(MemorySegment struct) {
        return struct.get(v_size$LAYOUT, v_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t v_size
     * }
     */
    public static void v_size(MemorySegment struct, long fieldValue) {
        struct.set(v_size$LAYOUT, v_size$OFFSET, fieldValue);
    }

    private static final OfLong a_size$LAYOUT = (OfLong)$LAYOUT.select(groupElement("a_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t a_size
     * }
     */
    public static final OfLong a_size$layout() {
        return a_size$LAYOUT;
    }

    private static final long a_size$OFFSET = 72;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t a_size
     * }
     */
    public static final long a_size$offset() {
        return a_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t a_size
     * }
     */
    public static long a_size(MemorySegment struct) {
        return struct.get(a_size$LAYOUT, a_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t a_size
     * }
     */
    public static void a_size(MemorySegment struct, long fieldValue) {
        struct.set(a_size$LAYOUT, a_size$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

