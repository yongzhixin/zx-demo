package com.zx.util.agent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Trace {

	public static String LOG_DIR = "/data/home/user00/log/gameserver/reload/";
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");

	static {
		String givenDir = System.getProperty("ClassHotReloadLogDir");
		if (givenDir != null) {
			LOG_DIR = givenDir;
		}
	}

	private static void generateLogFile(File file) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	/* Error */
	public static void log(String log) {
		// Byte code:
		// 0: new 50 java/io/File
		// 3: dup
		// 4: ldc 75
		// 6: iconst_2
		// 7: anewarray 3 java/lang/Object
		// 10: dup
		// 11: iconst_0
		// 12: getstatic 15 com/playcrab/chr/Trace:LOG_DIR Ljava/lang/String;
		// 15: aastore
		// 16: dup
		// 17: iconst_1
		// 18: getstatic 29 com/playcrab/chr/Trace:dateSdf Ljava/text/SimpleDateFormat;
		// 21: new 77 java/util/Date
		// 24: dup
		// 25: invokespecial 79 java/util/Date:<init> ()V
		// 28: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 31: aastore
		// 32: invokestatic 84 java/lang/String:format
		// (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
		// 35: invokespecial 89 java/io/File:<init> (Ljava/lang/String;)V
		// 38: astore_1
		// 39: aload_1
		// 40: invokestatic 90 com/playcrab/chr/Trace:generateLogFile (Ljava/io/File;)V
		// 43: aload_1
		// 44: invokevirtual 92 java/io/File:canWrite ()Z
		// 47: ifeq +111 -> 158
		// 50: aconst_null
		// 51: astore_2
		// 52: new 95 java/io/PrintWriter
		// 55: dup
		// 56: new 97 java/io/FileOutputStream
		// 59: dup
		// 60: aload_1
		// 61: iconst_1
		// 62: invokespecial 99 java/io/FileOutputStream:<init> (Ljava/io/File;Z)V
		// 65: invokespecial 102 java/io/PrintWriter:<init> (Ljava/io/OutputStream;)V
		// 68: astore_2
		// 69: aload_2
		// 70: new 105 java/lang/StringBuilder
		// 73: dup
		// 74: ldc 107
		// 76: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 79: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 82: new 77 java/util/Date
		// 85: dup
		// 86: invokespecial 79 java/util/Date:<init> ()V
		// 89: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 92: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 95: ldc 114
		// 97: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 100: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 103: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 106: aload_2
		// 107: aload_0
		// 108: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 111: aload_2
		// 112: ldc 123
		// 114: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 117: aload_2
		// 118: invokevirtual 125 java/io/PrintWriter:close ()V
		// 121: goto +30 -> 151
		// 124: astore_3
		// 125: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 128: aload_3
		// 129: invokevirtual 128 java/io/IOException:toString ()Ljava/lang/String;
		// 132: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 135: aload_2
		// 136: invokevirtual 125 java/io/PrintWriter:close ()V
		// 139: goto +62 -> 201
		// 142: astore 4
		// 144: aload_2
		// 145: invokevirtual 125 java/io/PrintWriter:close ()V
		// 148: aload 4
		// 150: athrow
		// 151: aload_2
		// 152: invokevirtual 125 java/io/PrintWriter:close ()V
		// 155: goto +46 -> 201
		// 158: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 161: new 105 java/lang/StringBuilder
		// 164: dup
		// 165: ldc -125
		// 167: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 170: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 173: new 77 java/util/Date
		// 176: dup
		// 177: invokespecial 79 java/util/Date:<init> ()V
		// 180: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 183: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 186: ldc 114
		// 188: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 191: aload_0
		// 192: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 195: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 198: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 201: return
		// Line number table:
		// Java source line #35 -> byte code offset #0
		// Java source line #36 -> byte code offset #39
		// Java source line #37 -> byte code offset #43
		// Java source line #38 -> byte code offset #50
		// Java source line #40 -> byte code offset #52
		// Java source line #41 -> byte code offset #69
		// Java source line #42 -> byte code offset #106
		// Java source line #43 -> byte code offset #111
		// Java source line #44 -> byte code offset #117
		// Java source line #45 -> byte code offset #121
		// Java source line #46 -> byte code offset #125
		// Java source line #48 -> byte code offset #135
		// Java source line #47 -> byte code offset #142
		// Java source line #48 -> byte code offset #144
		// Java source line #49 -> byte code offset #148
		// Java source line #48 -> byte code offset #151
		// Java source line #50 -> byte code offset #155
		// Java source line #51 -> byte code offset #158
		// Java source line #53 -> byte code offset #201
		// Local variable table:
		// start length slot name signature
		// 0 202 0 log String
		// 38 23 1 file File
		// 51 101 2 streamWriter java.io.PrintWriter
		// 124 5 3 ex IOException
		// 142 7 4 localObject Object
		// Exception table:
		// from to target type
		// 52 121 124 java/io/IOException
		// 52 135 142 finally
	}

	/* Error */
	public static void log(Exception e) {
		// Byte code:
		// 0: new 50 java/io/File
		// 3: dup
		// 4: ldc 75
		// 6: iconst_2
		// 7: anewarray 3 java/lang/Object
		// 10: dup
		// 11: iconst_0
		// 12: getstatic 15 com/playcrab/chr/Trace:LOG_DIR Ljava/lang/String;
		// 15: aastore
		// 16: dup
		// 17: iconst_1
		// 18: getstatic 29 com/playcrab/chr/Trace:dateSdf Ljava/text/SimpleDateFormat;
		// 21: new 77 java/util/Date
		// 24: dup
		// 25: invokespecial 79 java/util/Date:<init> ()V
		// 28: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 31: aastore
		// 32: invokestatic 84 java/lang/String:format
		// (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
		// 35: invokespecial 89 java/io/File:<init> (Ljava/lang/String;)V
		// 38: astore_1
		// 39: aload_1
		// 40: invokestatic 90 com/playcrab/chr/Trace:generateLogFile (Ljava/io/File;)V
		// 43: aload_1
		// 44: invokevirtual 92 java/io/File:canWrite ()Z
		// 47: ifeq +111 -> 158
		// 50: aconst_null
		// 51: astore_2
		// 52: new 95 java/io/PrintWriter
		// 55: dup
		// 56: new 97 java/io/FileOutputStream
		// 59: dup
		// 60: aload_1
		// 61: iconst_1
		// 62: invokespecial 99 java/io/FileOutputStream:<init> (Ljava/io/File;Z)V
		// 65: invokespecial 102 java/io/PrintWriter:<init> (Ljava/io/OutputStream;)V
		// 68: astore_2
		// 69: aload_2
		// 70: new 105 java/lang/StringBuilder
		// 73: dup
		// 74: ldc 107
		// 76: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 79: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 82: new 77 java/util/Date
		// 85: dup
		// 86: invokespecial 79 java/util/Date:<init> ()V
		// 89: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 92: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 95: ldc 114
		// 97: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 100: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 103: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 106: aload_0
		// 107: aload_2
		// 108: invokevirtual 139 java/lang/Exception:printStackTrace
		// (Ljava/io/PrintWriter;)V
		// 111: aload_2
		// 112: ldc 123
		// 114: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 117: aload_2
		// 118: invokevirtual 125 java/io/PrintWriter:close ()V
		// 121: goto +30 -> 151
		// 124: astore_3
		// 125: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 128: aload_3
		// 129: invokevirtual 128 java/io/IOException:toString ()Ljava/lang/String;
		// 132: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 135: aload_2
		// 136: invokevirtual 125 java/io/PrintWriter:close ()V
		// 139: goto +44 -> 183
		// 142: astore 4
		// 144: aload_2
		// 145: invokevirtual 125 java/io/PrintWriter:close ()V
		// 148: aload 4
		// 150: athrow
		// 151: aload_2
		// 152: invokevirtual 125 java/io/PrintWriter:close ()V
		// 155: goto +28 -> 183
		// 158: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 161: new 105 java/lang/StringBuilder
		// 164: dup
		// 165: ldc -111
		// 167: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 170: aload_0
		// 171: invokevirtual 147 java/lang/Exception:getMessage ()Ljava/lang/String;
		// 174: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 177: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 180: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 183: return
		// Line number table:
		// Java source line #56 -> byte code offset #0
		// Java source line #57 -> byte code offset #39
		// Java source line #58 -> byte code offset #43
		// Java source line #59 -> byte code offset #50
		// Java source line #61 -> byte code offset #52
		// Java source line #62 -> byte code offset #69
		// Java source line #63 -> byte code offset #106
		// Java source line #64 -> byte code offset #111
		// Java source line #65 -> byte code offset #117
		// Java source line #66 -> byte code offset #121
		// Java source line #67 -> byte code offset #125
		// Java source line #69 -> byte code offset #135
		// Java source line #68 -> byte code offset #142
		// Java source line #69 -> byte code offset #144
		// Java source line #70 -> byte code offset #148
		// Java source line #69 -> byte code offset #151
		// Java source line #71 -> byte code offset #155
		// Java source line #72 -> byte code offset #158
		// Java source line #74 -> byte code offset #183
		// Local variable table:
		// start length slot name signature
		// 0 184 0 e Exception
		// 38 23 1 file File
		// 51 101 2 streamWriter java.io.PrintWriter
		// 124 5 3 ex IOException
		// 142 7 4 localObject Object
		// Exception table:
		// from to target type
		// 52 121 124 java/io/IOException
		// 52 135 142 finally
	}

	/* Error */
	public static void log(String log, Exception e) {
		// Byte code:
		// 0: new 50 java/io/File
		// 3: dup
		// 4: ldc 75
		// 6: iconst_2
		// 7: anewarray 3 java/lang/Object
		// 10: dup
		// 11: iconst_0
		// 12: getstatic 15 com/playcrab/chr/Trace:LOG_DIR Ljava/lang/String;
		// 15: aastore
		// 16: dup
		// 17: iconst_1
		// 18: getstatic 29 com/playcrab/chr/Trace:dateSdf Ljava/text/SimpleDateFormat;
		// 21: new 77 java/util/Date
		// 24: dup
		// 25: invokespecial 79 java/util/Date:<init> ()V
		// 28: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 31: aastore
		// 32: invokestatic 84 java/lang/String:format
		// (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
		// 35: invokespecial 89 java/io/File:<init> (Ljava/lang/String;)V
		// 38: astore_2
		// 39: aload_2
		// 40: invokestatic 90 com/playcrab/chr/Trace:generateLogFile (Ljava/io/File;)V
		// 43: aload_2
		// 44: invokevirtual 92 java/io/File:canWrite ()Z
		// 47: ifeq +124 -> 171
		// 50: aconst_null
		// 51: astore_3
		// 52: new 95 java/io/PrintWriter
		// 55: dup
		// 56: new 97 java/io/FileOutputStream
		// 59: dup
		// 60: aload_2
		// 61: iconst_1
		// 62: invokespecial 99 java/io/FileOutputStream:<init> (Ljava/io/File;Z)V
		// 65: invokespecial 102 java/io/PrintWriter:<init> (Ljava/io/OutputStream;)V
		// 68: astore_3
		// 69: aload_3
		// 70: new 105 java/lang/StringBuilder
		// 73: dup
		// 74: ldc 107
		// 76: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 79: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 82: new 77 java/util/Date
		// 85: dup
		// 86: invokespecial 79 java/util/Date:<init> ()V
		// 89: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 92: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 95: ldc 114
		// 97: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 100: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 103: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 106: aload_3
		// 107: aload_0
		// 108: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 111: aload_3
		// 112: ldc 123
		// 114: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 117: aload_1
		// 118: aload_3
		// 119: invokevirtual 139 java/lang/Exception:printStackTrace
		// (Ljava/io/PrintWriter;)V
		// 122: aload_3
		// 123: ldc 123
		// 125: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 128: aload_3
		// 129: invokevirtual 125 java/io/PrintWriter:close ()V
		// 132: goto +32 -> 164
		// 135: astore 4
		// 137: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 140: aload 4
		// 142: invokevirtual 128 java/io/IOException:toString ()Ljava/lang/String;
		// 145: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 148: aload_3
		// 149: invokevirtual 125 java/io/PrintWriter:close ()V
		// 152: goto +44 -> 196
		// 155: astore 5
		// 157: aload_3
		// 158: invokevirtual 125 java/io/PrintWriter:close ()V
		// 161: aload 5
		// 163: athrow
		// 164: aload_3
		// 165: invokevirtual 125 java/io/PrintWriter:close ()V
		// 168: goto +28 -> 196
		// 171: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 174: new 105 java/lang/StringBuilder
		// 177: dup
		// 178: ldc -104
		// 180: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 183: aload_1
		// 184: invokevirtual 147 java/lang/Exception:getMessage ()Ljava/lang/String;
		// 187: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 190: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 193: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 196: return
		// Line number table:
		// Java source line #77 -> byte code offset #0
		// Java source line #78 -> byte code offset #39
		// Java source line #79 -> byte code offset #43
		// Java source line #80 -> byte code offset #50
		// Java source line #82 -> byte code offset #52
		// Java source line #83 -> byte code offset #69
		// Java source line #84 -> byte code offset #106
		// Java source line #85 -> byte code offset #111
		// Java source line #86 -> byte code offset #117
		// Java source line #87 -> byte code offset #122
		// Java source line #88 -> byte code offset #128
		// Java source line #89 -> byte code offset #132
		// Java source line #90 -> byte code offset #137
		// Java source line #92 -> byte code offset #148
		// Java source line #91 -> byte code offset #155
		// Java source line #92 -> byte code offset #157
		// Java source line #93 -> byte code offset #161
		// Java source line #92 -> byte code offset #164
		// Java source line #94 -> byte code offset #168
		// Java source line #95 -> byte code offset #171
		// Java source line #97 -> byte code offset #196
		// Local variable table:
		// start length slot name signature
		// 0 197 0 log String
		// 0 197 1 e Exception
		// 38 23 2 file File
		// 51 114 3 streamWriter java.io.PrintWriter
		// 135 6 4 ex IOException
		// 155 7 5 localObject Object
		// Exception table:
		// from to target type
		// 52 132 135 java/io/IOException
		// 52 148 155 finally
	}

	/* Error */
	public static void log(String format, Object... args) {
		// Byte code:
		// 0: new 50 java/io/File
		// 3: dup
		// 4: ldc 75
		// 6: iconst_2
		// 7: anewarray 3 java/lang/Object
		// 10: dup
		// 11: iconst_0
		// 12: getstatic 15 com/playcrab/chr/Trace:LOG_DIR Ljava/lang/String;
		// 15: aastore
		// 16: dup
		// 17: iconst_1
		// 18: getstatic 29 com/playcrab/chr/Trace:dateSdf Ljava/text/SimpleDateFormat;
		// 21: new 77 java/util/Date
		// 24: dup
		// 25: invokespecial 79 java/util/Date:<init> ()V
		// 28: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 31: aastore
		// 32: invokestatic 84 java/lang/String:format
		// (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
		// 35: invokespecial 89 java/io/File:<init> (Ljava/lang/String;)V
		// 38: astore_2
		// 39: aload_2
		// 40: invokestatic 90 com/playcrab/chr/Trace:generateLogFile (Ljava/io/File;)V
		// 43: aload_0
		// 44: aload_1
		// 45: invokestatic 84 java/lang/String:format
		// (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
		// 48: astore_3
		// 49: aload_2
		// 50: invokevirtual 92 java/io/File:canWrite ()Z
		// 53: ifeq +122 -> 175
		// 56: aconst_null
		// 57: astore 4
		// 59: new 95 java/io/PrintWriter
		// 62: dup
		// 63: new 97 java/io/FileOutputStream
		// 66: dup
		// 67: aload_2
		// 68: iconst_1
		// 69: invokespecial 99 java/io/FileOutputStream:<init> (Ljava/io/File;Z)V
		// 72: invokespecial 102 java/io/PrintWriter:<init> (Ljava/io/OutputStream;)V
		// 75: astore 4
		// 77: aload 4
		// 79: new 105 java/lang/StringBuilder
		// 82: dup
		// 83: ldc 107
		// 85: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 88: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 91: new 77 java/util/Date
		// 94: dup
		// 95: invokespecial 79 java/util/Date:<init> ()V
		// 98: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 101: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 104: ldc 114
		// 106: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 109: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 112: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 115: aload 4
		// 117: aload_3
		// 118: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 121: aload 4
		// 123: ldc 123
		// 125: invokevirtual 120 java/io/PrintWriter:write (Ljava/lang/String;)V
		// 128: aload 4
		// 130: invokevirtual 125 java/io/PrintWriter:close ()V
		// 133: goto +34 -> 167
		// 136: astore 5
		// 138: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 141: aload 5
		// 143: invokevirtual 128 java/io/IOException:toString ()Ljava/lang/String;
		// 146: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 149: aload 4
		// 151: invokevirtual 125 java/io/PrintWriter:close ()V
		// 154: goto +64 -> 218
		// 157: astore 6
		// 159: aload 4
		// 161: invokevirtual 125 java/io/PrintWriter:close ()V
		// 164: aload 6
		// 166: athrow
		// 167: aload 4
		// 169: invokevirtual 125 java/io/PrintWriter:close ()V
		// 172: goto +46 -> 218
		// 175: getstatic 58 java/lang/System:out Ljava/io/PrintStream;
		// 178: new 105 java/lang/StringBuilder
		// 181: dup
		// 182: ldc -125
		// 184: invokespecial 109 java/lang/StringBuilder:<init> (Ljava/lang/String;)V
		// 187: getstatic 25 com/playcrab/chr/Trace:sdf Ljava/text/SimpleDateFormat;
		// 190: new 77 java/util/Date
		// 193: dup
		// 194: invokespecial 79 java/util/Date:<init> ()V
		// 197: invokevirtual 80 java/text/SimpleDateFormat:format
		// (Ljava/util/Date;)Ljava/lang/String;
		// 200: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 203: ldc 114
		// 205: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 208: aload_3
		// 209: invokevirtual 110 java/lang/StringBuilder:append
		// (Ljava/lang/String;)Ljava/lang/StringBuilder;
		// 212: invokevirtual 116 java/lang/StringBuilder:toString ()Ljava/lang/String;
		// 215: invokevirtual 129 java/io/PrintStream:println (Ljava/lang/String;)V
		// 218: return
		// Line number table:
		// Java source line #100 -> byte code offset #0
		// Java source line #101 -> byte code offset #39
		// Java source line #102 -> byte code offset #43
		// Java source line #103 -> byte code offset #49
		// Java source line #104 -> byte code offset #56
		// Java source line #106 -> byte code offset #59
		// Java source line #107 -> byte code offset #77
		// Java source line #108 -> byte code offset #115
		// Java source line #109 -> byte code offset #121
		// Java source line #110 -> byte code offset #128
		// Java source line #111 -> byte code offset #133
		// Java source line #112 -> byte code offset #138
		// Java source line #114 -> byte code offset #149
		// Java source line #113 -> byte code offset #157
		// Java source line #114 -> byte code offset #159
		// Java source line #115 -> byte code offset #164
		// Java source line #114 -> byte code offset #167
		// Java source line #116 -> byte code offset #172
		// Java source line #117 -> byte code offset #175
		// Java source line #119 -> byte code offset #218
		// Local variable table:
		// start length slot name signature
		// 0 219 0 format String
		// 0 219 1 args Object[]
		// 38 30 2 file File
		// 48 161 3 log String
		// 57 111 4 streamWriter java.io.PrintWriter
		// 136 6 5 ex IOException
		// 157 8 6 localObject Object
		// Exception table:
		// from to target type
		// 59 133 136 java/io/IOException
		// 59 149 157 finally
	}
}