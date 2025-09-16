public class JNIDemo {
    public native int doubleValue(int x);

    static {
        System.loadLibrary("jnidemo");
    }

    public static void main(String[] args) {
        JNIDemo demo = new JNIDemo();
        int result = demo.doubleValue(10);
        System.out.println("Doppelt: " + result);
    }
}

