
# How to generate natives directory

For macos

```shell script

LIBWEBP_VERSION=1.4.0

# For MacOs
# All command must be executed in the root directory of the webp-native project

# Build the native library as dynamic library
curl https://storage.googleapis.com/downloads.webmproject.org/releases/webp/libwebp-$LIBWEBP_VERSION-mac-x86-64.tar.gz --output libwebp-$LIBWEBP_VERSION-mac-x86-64.tar.gz
tar -xvf libwebp-$LIBWEBP_VERSION-mac-x86-64.tar.gz
mkdir  libwebp-obj
cd libwebp-obj
ar -x ../libwebp-$LIBWEBP_VERSION-mac-x86-64/lib/libwebp.a
ar -x ../libwebp-$LIBWEBP_VERSION-mac-x86-64/lib/libwebpdemux.a
ar -x ../libwebp-$LIBWEBP_VERSION-mac-x86-64/lib/libsharpyuv.a

g++ -dynamiclib -o ../src/main/resources/natives/osx_64/libwebp-$LIBWEBP_VERSION.dylib *.o

# Install Jextract
curl https://download.java.net/java/early_access/jextract/22/5/openjdk-22-jextract+5-33_macos-x64_bin.tar.gz --output openjdk-22-jextract+5-33_macos-x64_bin.tar.gz
tar -xvf openjdk-22-jextract+5-33_macos-x64_bin.tar.gz

# Build java binding classes
./jextract-22/bin/jextract libwebp-$LIBWEBP_VERSION-mac-x86-64/include/webp/decode.h --header-class-name LibWebPDecode -t org.peekmoon.webp.binding --output src/main/java
./jextract-22/bin/jextract libwebp-$LIBWEBP_VERSION-mac-x86-64/include/webp/encode.h --header-class-name LibWebPEncode -t org.peekmoon.webp.binding --output src/main/java

```

## For Windows

Install: Visual Studio Community
git clone https://chromium.googlesource.com/webm/libwebp
nmake /f Makefile.vc CFG=release-dynamic RTLIBCFG=static OBJDIR=output
copy dll from output\release-dynamic\x86\bin to natives/windows_64

## For unix like

```
-docker build . -t libwebp-build:1.4.0
docker run --name libwebp-build libwebp-build:1.4.0 /bin/true
docker cp libwebp-build:/tmp/libwebp-1.4.0/src/.libs/libwebp.so.7.1.9 src/main/resources/natives/linux_64/libwebp.so
docker cp libwebp-build:/tmp/libwebp-1.4.0/sharpyuv/.libs/libsharpyuv.so.0.1.0 src/main/resources/META-INF/lib/linux-x86_64/libsharpyuv.so.0
```
 
# Notes

libsharpyuv is not used in the project, but it is required by libwebp. It has to be extracted in a specific directory referenced by the LD_LIBRARY_PATH environment variable.

Trying to build linux binaries extracting object file from archive

```
ar -x ../libwebp-$LIBWEBP_VERSION-$LIBWEBP_OS/lib/libwebp.a
...
```
lead to error message "need to recompile with -fPIC"

