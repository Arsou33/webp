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
 * struct WebPRGBABuffer {
 *     uint8_t *rgba;
 *     int stride;
 *     size_t size;
 * }
 * }
 */
public class WebPRGBABuffer {

    WebPRGBABuffer() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        LibWebPDecode.C_POINTER.withName("rgba"),
        LibWebPDecode.C_INT.withName("stride"),
        MemoryLayout.paddingLayout(4),
        LibWebPDecode.C_LONG.withName("size")
    ).withName("WebPRGBABuffer");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout rgba$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("rgba"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *rgba
     * }
     */
    public static final AddressLayout rgba$layout() {
        return rgba$LAYOUT;
    }

    private static final long rgba$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *rgba
     * }
     */
    public static final long rgba$offset() {
        return rgba$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *rgba
     * }
     */
    public static MemorySegment rgba(MemorySegment struct) {
        return struct.get(rgba$LAYOUT, rgba$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *rgba
     * }
     */
    public static void rgba(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(rgba$LAYOUT, rgba$OFFSET, fieldValue);
    }

    private static final OfInt stride$LAYOUT = (OfInt)$LAYOUT.select(groupElement("stride"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int stride
     * }
     */
    public static final OfInt stride$layout() {
        return stride$LAYOUT;
    }

    private static final long stride$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int stride
     * }
     */
    public static final long stride$offset() {
        return stride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int stride
     * }
     */
    public static int stride(MemorySegment struct) {
        return struct.get(stride$LAYOUT, stride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int stride
     * }
     */
    public static void stride(MemorySegment struct, int fieldValue) {
        struct.set(stride$LAYOUT, stride$OFFSET, fieldValue);
    }

    private static final OfLong size$LAYOUT = (OfLong)$LAYOUT.select(groupElement("size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t size
     * }
     */
    public static final OfLong size$layout() {
        return size$LAYOUT;
    }

    private static final long size$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t size
     * }
     */
    public static final long size$offset() {
        return size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t size
     * }
     */
    public static long size(MemorySegment struct) {
        return struct.get(size$LAYOUT, size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t size
     * }
     */
    public static void size(MemorySegment struct, long fieldValue) {
        struct.set(size$LAYOUT, size$OFFSET, fieldValue);
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

