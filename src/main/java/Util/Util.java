package Util;

public final class Util {
    public static String getSoftwareVersion() {
        final Package pkg = Util.class.getPackage();
        final String version = (pkg != null) ? pkg.getImplementationVersion() : null;

        if (version == null) {
            return "(Development Build)";
        }

        return version;
    }
}

