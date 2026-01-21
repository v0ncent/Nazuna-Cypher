package Util;

public final class Util {
    public static void printSoftwareVersion() {
        final Package pkg = Util.class.getPackage();
        final String version = (pkg != null) ? pkg.getImplementationVersion() : null;

        if (version == null) {
            System.out.println("Nazuna-Cypher (development build)");
        } else {
            System.out.println("Nazuna-Cypher v" + version);
        }
    }
}

